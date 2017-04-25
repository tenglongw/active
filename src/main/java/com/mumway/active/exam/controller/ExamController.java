package com.mumway.active.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mumway.active.exam.domain.Question;
import com.mumway.active.exam.domain.UserRate;
import com.mumway.active.exam.service.IExamService;
import com.mumway.active.exam.service.IUserWeixinService;
import com.mumway.active.utile.Result;




/**
 * 考试
 * @author wtl
 *
 */
@Controller
@RequestMapping("exam")
public class ExamController {

	static Logger logger = LogManager.getLogger(ExamController.class);
	
	@Resource
	private IExamService examService;
	
	@Resource
	private IUserWeixinService userWeixinService;
	
	/**
	 * 返回考试题目
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getExamQuestion", method = RequestMethod.GET)
	public Object getExamQuestion(){
		logger.info("----getExamQuestion  start ----");
		Result result = new Result();
		List<Question> questionList = null;
		try {
			questionList = examService.queryExamQuestions();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getExamQuestion error !!"+e.getMessage());
		}
		result.setStatus(Result.STATUS_OK);
		result.setData(questionList);
		result.setMsg(Result.MSG_OK);
		return result;
	}
	
	/**
	 * 保存答题信息
	 * @param answerResultsList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/saveExamQuestion", method = RequestMethod.POST)
	public Object saveExamQuestion(@RequestBody Map<String,Object> answerMap){
		logger.info("----saveExamQuestion  start ----");
		Result result = new Result();
		try {
			Map<String,Object> scoring = (Map<String, Object>)answerMap.get("ScoringDbject");
			UserRate userRate = examService.getUserRateInfoByOpenid((String) scoring.get("openid"));
			if(null == userRate){
				examService.saveQuestionAnswers((List<Map<String, Object>>) answerMap.get("Answer"));
				examService.saveUserRate((Map<String, Object>) answerMap.get("ScoringDbject"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("saveExamQuestion error !!"+e.getMessage());
		}
		result.setMsg(Result.MSG_OK);
		result.setStatus(Result.STATUS_OK);
		return result;
	}
	
	/**
	 * 检查用户是否关注
	 * @param openid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isAttention")
	public Object isAttention(@RequestParam(value = "openid") String openid){
		logger.info("----isAttention  start ----{openid:"+openid+"}");
		Result result = new Result();
		Map<String, Boolean> ret = new HashMap<String, Boolean>();
		if(examService.isAttention(openid)){
			ret.put("isAttention", true);
			result.setData(ret);
			result.setMsg(Result.MSG_OK);
			result.setStatus(Result.STATUS_OK);
		}else{
			ret.put("isAttention", false);
			result.setData(ret);
			result.setMsg(Result.MSG_FAIL);
			result.setStatus(Result.STATUS_FAIL);
		}
		
		return result;
	}
	
	/**
	 * 检查用户是否登录
	 * @param openid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "isLogin")
	public Object isLogin(@RequestParam(value = "openid") String openid){
		logger.info("----isLogin  start ----{openid:"+openid+"}");
		Result result = new Result();
		Map<String, Boolean> ret = new HashMap<String, Boolean>();
		if(examService.isLogin(openid)){
			ret.put("isLogin", true);
			result.setData(ret);
			result.setMsg(Result.MSG_OK);
			result.setStatus(Result.STATUS_OK);
		}else{
			ret.put("isLogin", false);
			result.setData(ret);
			result.setMsg(Result.MSG_FAIL);
			result.setStatus(Result.STATUS_FAIL);
		}
		
		return result;
	}
	
	/**获取我的考试成绩
	 * @param openid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getExamInfo")
	public Object getQuestionType(@RequestParam(value = "openid") String openid){
		logger.info("----getExamInfo  start ----{openid:"+openid+"}");
		Result result = new Result();
		//我的答题
		List<Question> questionList = null;
		//我的答题等级
		UserRate userRate = null;
		try {
			questionList = examService.getExamInfoByOpenid(openid);
			userRate = examService.getUserRateInfoByOpenid(openid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getExamInfo error !!"+ e.getMessage());
		}
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("questionList", questionList);
		resultMap.put("userRate", userRate);
		result.setData(resultMap);
		result.setStatus(Result.STATUS_OK);
		result.setMsg(Result.MSG_OK);
		if(questionList.size() == 0 && null == userRate){
			result.setStatus(Result.STATUS_FAIL);
			result.setMsg(Result.MSG_FAIL);
		}
		return result;  
	}
	
	/**获取我的考试成绩
	 * @param openid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSistersRate")
	public Object getSistersRate(@RequestParam(value = "openid") String openid){
		logger.info("----getSistersRate  start ----{openid:"+openid+"}");
		Result result = new Result();
		//姐妹答题信息
		List<UserRate> userRateList = null;
		//邀请姐妹排名
		int ranking = 0;
		try {
			userRateList = userWeixinService.getSistersRateByOpenid(openid);
			ranking = userWeixinService.getSistersRanking(openid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getSistersRate error !!"+e.getMessage());
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("userRateList", userRateList);
		resultMap.put("total", userRateList.size());
		resultMap.put("ranking", ranking);
		result.setData(resultMap);
		result.setStatus(Result.STATUS_OK);
		return result;
	}
	
	
}

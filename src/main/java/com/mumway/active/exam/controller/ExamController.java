package com.mumway.active.exam.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		Result result = new Result();
		List<Question> questionList = examService.queryExamQuestions();
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
		Result result = new Result();
		examService.saveQuestionAnswers((List<Map<String, Object>>) answerMap.get("Answer"));
		
		examService.saveUserRate((Map<String, Object>) answerMap.get("ScoringDbject"));
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
		Result result = new Result();
		result.setMsg(Result.MSG_OK);
		result.setStatus(Result.STATUS_OK);
		return result;
	}
	
	/**获取我的考试成绩
	 * @param openid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getExamInfo")
	public Object getQuestionType(@RequestParam(value = "openid") String openid){
		Result result = new Result();
		//我的答题
		List<Question> questionList = examService.getExamInfoByOpenid(openid);
		//我的答题等级
		UserRate userRate = examService.getUserRateInfoByOpenid(openid);
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("questionList", questionList);
		resultMap.put("userRate", userRate);
		result.setData(resultMap);
		result.setStatus(Result.STATUS_OK);
		return result;
	}
	
	/**获取我的考试成绩
	 * @param openid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getSistersRate")
	public Object getSistersRate(@RequestParam(value = "openid") String openid){
		Result result = new Result();
		//姐妹答题信息
		List<UserRate> userRateList = userWeixinService.getSistersRateByOpenid(openid);
		//邀请姐妹排名
		int ranking = userWeixinService.getSistersRanking(openid);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("userRateList", userRateList);
		resultMap.put("total", userRateList.size());
		resultMap.put("ranking", ranking);
		result.setData(resultMap);
		result.setStatus(Result.STATUS_OK);
		return result;
	}
	
	
}

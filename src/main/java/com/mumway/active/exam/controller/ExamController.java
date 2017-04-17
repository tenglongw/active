package com.mumway.active.exam.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.json.JsonArray;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.mumway.active.exam.domain.AnswerResults;
import com.mumway.active.exam.domain.QuestionType;
import com.mumway.active.exam.service.IExamService;
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
	
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	/**
	 * 返回考试题目
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getExamQuestion", method = RequestMethod.GET)
	public Object getExamQuestion(@RequestParam(value = "userId",required = false) String userId){
		Result result = new Result();
		List<QuestionType> questionTypeList = examService.queryExamQuestions();
		System.out.println(questionTypeList.toString());
		result.setStatus(Result.STATUS_OK);
		result.setData(questionTypeList);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveExamQuestion")
	public Object saveExamQuestion(@RequestBody List<AnswerResults> answerResultsList){
		Result result = new Result();
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getQuestionType")
	public Object getQuestionType(){
		Result result = new Result();
		QuestionType questionType = examService.getQuestionTypeById(1);
		result.setData(questionType);
		result.setStatus(Result.STATUS_OK);
		return result;
	}
}

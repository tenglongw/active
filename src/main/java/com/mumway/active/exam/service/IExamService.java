package com.mumway.active.exam.service;

import java.util.List;

import com.mumway.active.exam.domain.QuestionType;

/**
 * 考试service
 * @author wtl
 *
 */
public interface IExamService {

	//查询考题
	public List<QuestionType> queryExamQuestions();
	
	public QuestionType getQuestionTypeById(int id);
}

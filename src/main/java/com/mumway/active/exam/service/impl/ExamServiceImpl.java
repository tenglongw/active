package com.mumway.active.exam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mumway.active.exam.Mapper.QuestionMapper;
import com.mumway.active.exam.Mapper.QuestionTypeMapper;
import com.mumway.active.exam.domain.QuestionType;
import com.mumway.active.exam.service.IExamService;

@Service
public class ExamServiceImpl implements IExamService {

	@Resource
	private QuestionMapper questionMapper;
	
	@Resource
	private QuestionTypeMapper questionTypeMapper;
	/**
	 * 查询考题
	 */
	public List<QuestionType> queryExamQuestions() {
		return questionTypeMapper.queryExamQuestions();
	}
	
	public QuestionType getQuestionTypeById(int id) {
		return questionTypeMapper.selectByPrimaryKey(id);
	}

}

package com.mumway.active.exam.Mapper;

import java.util.List;

import com.mumway.active.exam.domain.QuestionType;

public interface QuestionTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    QuestionType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
    
    List<QuestionType> queryExamQuestions();
}
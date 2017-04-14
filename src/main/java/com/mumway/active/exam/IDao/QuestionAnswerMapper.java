package com.mumway.active.exam.IDao;

import com.mumway.active.exam.domain.QuestionAnswer;

public interface QuestionAnswerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionAnswer record);

    int insertSelective(QuestionAnswer record);

    QuestionAnswer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionAnswer record);

    int updateByPrimaryKey(QuestionAnswer record);
}
package com.mumway.active.exam.IDao;

import com.mumway.active.exam.domain.AnswerResults;

public interface AnswerResultsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnswerResults record);

    int insertSelective(AnswerResults record);

    AnswerResults selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnswerResults record);

    int updateByPrimaryKey(AnswerResults record);
}
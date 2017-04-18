package com.mumway.active.exam.Mapper;

import java.util.List;
import java.util.Map;

import com.mumway.active.exam.domain.AnswerResults;
import com.mumway.active.exam.domain.Question;

public interface AnswerResultsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnswerResults record);
    
    int insertMap(Map<String,Object> record);

    int insertSelective(AnswerResults record);

    AnswerResults selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AnswerResults record);

    int updateByPrimaryKey(AnswerResults record);
    
    List<Question> getExamInfoByOpenid(String openid);
}
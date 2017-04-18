package com.mumway.active.exam.Mapper;

import java.util.List;

import com.mumway.active.exam.domain.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    List<Question> getExamInfoByOpenid(String openid);
    
}
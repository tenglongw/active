package com.mumway.active.exam.Mapper;

import java.util.List;
import java.util.Map;

import com.mumway.active.exam.domain.UserRate;

public interface UserRateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRate record);
    
    int insertMap(Map<String,Object> recorde);

    int insertSelective(UserRate record);

    UserRate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRate record);

    int updateByPrimaryKey(UserRate record);
    
    UserRate selectByOpenid(String openid);
    
    List<UserRate> getSistersRateByOpenid(String openid);
    
    List<Map<String,Object>> getSistersRanking();
}
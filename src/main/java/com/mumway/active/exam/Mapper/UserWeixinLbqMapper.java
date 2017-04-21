package com.mumway.active.exam.Mapper;

import com.mumway.active.exam.domain.UserWeixinLbq;

public interface UserWeixinLbqMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWeixinLbq record);

    int insertSelective(UserWeixinLbq record);

    UserWeixinLbq selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWeixinLbq record);

    int updateByPrimaryKeyWithBLOBs(UserWeixinLbq record);

    int updateByPrimaryKey(UserWeixinLbq record);
    
    UserWeixinLbq getUserlbqByOpenid(String openid);
}
package com.mumway.active.exam.Mapper;

import com.mumway.active.exam.domain.UserWeixin;

public interface UserWeixinMapper {
    int insert(UserWeixin record);

    int insertSelective(UserWeixin record);
}
package com.mumway.active.exam.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mumway.active.exam.Mapper.UserRateMapper;
import com.mumway.active.exam.domain.UserRate;
import com.mumway.active.exam.service.IUserWeixinService;

@Service("userWeixinService")
public class UserWeixinServiceImpl implements IUserWeixinService {

	@Resource
	UserRateMapper userRateMapper;
	public List<UserRate> getSistersRateByOpenid(String openid) {
		// TODO Auto-generated method stub
		return userRateMapper.getSistersRateByOpenid(openid);
	}
	public int getSistersRanking(String openid) {
		List<Map<String,Object>> resultList = userRateMapper.getSistersRanking();
		int ranking = 0;
		for(int i=0; i<resultList.size(); i++){
			Map<String,Object> temp = resultList.get(i);
			if(openid.equals(temp.get("openid"))){
				ranking = i+1;
				break;
			}
		}
		return ranking;
	}

}

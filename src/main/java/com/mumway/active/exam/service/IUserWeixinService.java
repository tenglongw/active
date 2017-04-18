package com.mumway.active.exam.service;

import java.util.List;

import com.mumway.active.exam.domain.UserRate;

public interface IUserWeixinService {

	List<UserRate> getSistersRateByOpenid(String openid);
	
	/**获取姐妹排名
	 * @param openid
	 * @return
	 */
	int getSistersRanking(String openid);
}

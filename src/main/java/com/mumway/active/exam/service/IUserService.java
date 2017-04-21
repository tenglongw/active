	package com.mumway.active.exam.service;

import com.mumway.active.exam.domain.User;

public interface IUserService {

	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);
}

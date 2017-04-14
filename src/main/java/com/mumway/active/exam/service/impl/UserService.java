package com.mumway.active.exam.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mumway.active.exam.IDao.UserMapper;
import com.mumway.active.exam.domain.User;
import com.mumway.active.exam.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	@Resource
	private UserMapper userDao;
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.mumway.active.exam.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mumway.active.exam.Mapper.UserMapper;
import com.mumway.active.exam.domain.User;
import com.mumway.active.exam.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.mumway.active.exam.service.IUserService#getUserById(int)
	 */
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

}

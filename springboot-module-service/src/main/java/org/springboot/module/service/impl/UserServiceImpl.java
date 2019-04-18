package org.springboot.module.service.impl;

import org.springboot.module.dao.IUserDao;
import org.springboot.module.dao.UserMapper;
import org.springboot.module.model.User;
import org.springboot.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao iUserDao;

	@Autowired
	private UserMapper userMapper;

	@Override
	public User findById(String id) {
		System.out.println("select user id: " + id);
		User user = iUserDao.selectById(id);
		System.out.println(user);
		user = userMapper.selectById(id);
		System.out.println(user);
		return user;
	}

}

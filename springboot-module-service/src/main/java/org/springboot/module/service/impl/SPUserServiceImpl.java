package org.springboot.module.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springboot.module.common.BaseConstant;
import org.springboot.module.mapper.SpUserMapper;
import org.springboot.module.model.User;
import org.springboot.module.service.ISPUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPUserServiceImpl implements ISPUserService {

	@Autowired
	private SpUserMapper userMapper;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsers() {
		System.out.println("SPUserServiceImpl.findUsers()");
		Map<String, Object> params = new HashMap<>();
		userMapper.selectUserAll(params);
		return (List<User>) params.get(BaseConstant.OUT_ENTITIES);
	}

	@Override
	public User findUserById(String userId) {
		System.out.println("SPUserServiceImpl.findUserById()");
		User user = new User();
		user.setUserId(userId);
		userMapper.selectUserByUserId(user);
		return user;
	}

	@Override
	public void addUser(User user) {
		System.out.println("SPUserServiceImpl.addUser()");
		userMapper.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		System.out.println("SPUserServiceImpl.updateUser()");
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(String userId) {
		System.out.println("SPUserServiceImpl.deleteUserById()");
		// TODO
		System.out.println("TODO delete user by userId...");

	}

}

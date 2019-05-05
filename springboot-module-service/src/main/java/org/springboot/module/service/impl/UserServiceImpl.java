package org.springboot.module.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springboot.module.mapper.IUserDao;
import org.springboot.module.mapper.UserMapper;
import org.springboot.module.model.User;
import org.springboot.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

	@Override
	public User findByName(String name) {
		System.out.println("select user name: " + name);
		User user = userMapper.selectByName(name);
		System.out.println(user);
		return user;
	}

	@Override
	public User login(String userName, String password) {
		System.out.println("UserServiceImpl.login()");
		return userMapper.login(userName, password);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByName(username);
		if (user == null) {
			// throw exception inform front end not this user
			throw new UsernameNotFoundException("user + " + username + "not found.");
		}
		List<String> roleCodeList = Arrays.asList("rolea,roleb");// FIXME

		List<GrantedAuthority> authorities = roleCodeList.stream().map(e -> new SimpleGrantedAuthority(e))
				.collect(Collectors.toList());

		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(), authorities);

		return userDetails;
	}

}

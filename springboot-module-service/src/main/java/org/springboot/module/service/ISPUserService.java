package org.springboot.module.service;

import java.util.List;

import org.springboot.module.model.OraclePage;
import org.springboot.module.model.User;

public interface ISPUserService {

	public List<User> findUsers();
	
	public OraclePage<User> findUsersByPage(OraclePage<User> page);

	public User findUserById(String userId);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUserById(String userId);

}

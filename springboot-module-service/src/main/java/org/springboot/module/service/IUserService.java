package org.springboot.module.service;

import org.springboot.module.model.User;
import  org.springframework.security.core.userdetails.UserDetailsService;



public interface IUserService extends UserDetailsService{
	User login(String userName, String password);
	User findById(String id);
	User findByName(String name);
}

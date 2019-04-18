package org.springboot.module.service;

import org.springboot.module.model.User;

public interface IUserService {
	User findById(String id);
}

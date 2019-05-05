package org.springboot.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springboot.module.model.User;

@Mapper
public interface UserMapper {
	public User login(String userName, String password);
	public User selectById(String id);
	public User selectByName(String userName);
}

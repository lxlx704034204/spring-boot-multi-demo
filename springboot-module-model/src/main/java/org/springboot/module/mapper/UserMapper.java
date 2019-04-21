package org.springboot.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springboot.module.model.User;

@Mapper
public interface UserMapper {
	public User selectById(String id);
}

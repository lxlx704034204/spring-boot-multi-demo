package org.springboot.module.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springboot.module.model.OraclePage;
import org.springboot.module.model.User;

@Mapper
public interface SpUserMapper {

	public void selectUserAll(Map<String,Object> params);
	
	public void selectUserByPage(OraclePage<User> page);
	
	public void selectUserByUserId(User user);
	
	public void addUser(User user);
	
	public void updateUser(User user);

}

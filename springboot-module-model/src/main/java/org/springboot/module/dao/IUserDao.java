package org.springboot.module.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springboot.module.model.User;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDao {
	@Select("select * from CCH.T_USER where USER_ID = #{id}")
	public User selectById(String id);
}

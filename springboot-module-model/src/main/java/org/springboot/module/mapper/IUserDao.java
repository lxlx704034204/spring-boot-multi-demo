package org.springboot.module.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springboot.module.model.User;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDao {
	/***
	 * --oracle 分页查询介绍
	 * --如果想要用rownum不大于5，需按下面方法使用
	 * select a.*, rownum rn from t_user a where rownum <=5;
	 * select a.*, rownum rn from (select * from t_user) a where rownum <=5;
	 * select a.* from (select t_user.*, rownum rn from t_user) a where rn <=5;
	 * 
	 * --如果想要用rownum不从1开始，需按下面方法使用
	 * select a.* from (select t_user.*, rownum rn from t_user) a where rn >5;
	 * 
	 * --分页查询一      (rownum bettwen 2 and 5)
	 * select * from (select a.*, rownum rn from (select * from t_user) a where rownum <=5) where rn>=2;
	 * 
	 * --分页查询二
	 * select a.* from (select t_user.*, rownum rn from t_user where rownum <=5;) a where rn >=2;
	 * 
	 * --分页查询三
	 * select a.* from (select t_user.*,rownum rn from t_user) a where rn between 2 and 5;
	 * 
	 * */
	
	/*@Select("select * from CCH.T_USER where USER_ID = #{id}")*/
	@Select("select USER_ID as userId, USER_NAME as userName, birthday from CCH.T_USER where USER_ID = #{id}")
	public User selectById(String id);
	
}

package org.springboot.module.mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springboot.module.BaseUnitTest;
import org.springboot.module.common.BaseConstant;
import org.springboot.module.model.OraclePage;
import org.springboot.module.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import oracle.jdbc.OracleTypes;

public class SpUserMapperTest extends BaseUnitTest {
	@Autowired
	private SpUserMapper userMapper;

	@Test
	public void selectUserAllTest() {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(BaseConstant.OUT_ENTITIES, OracleTypes.CURSOR);
		userMapper.selectUserAll(param);

		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) param.get(BaseConstant.OUT_ENTITIES);
		System.out.println("user size is " + users.size());
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void selectUserByPageTest() {

		OraclePage<User> page = new OraclePage<>(2, 5);
		userMapper.selectUserByPage(page);

		System.out.println("page index: " + page.getStart());
		System.out.println("page size: " + page.getSize());
		System.out.println("allCount: " + page.getAllCount());
		System.out.println("lists size: " + page.getLists().size());

		page.getLists().forEach(item -> {
			System.out.println(item);
		});
	}

	@Test
	public void selectUserByUserIdTest() {
		User user = new User();
		user.setUserId("10001");

		userMapper.selectUserByUserId(user);

		System.out.println(user);
	}

	@Test
	public void addUserTest() {
		User user = new User();
		user.setUserId("99999");
		user.setUserName("userName");
		user.setPassword("password");
		user.setPhone("phone");
		user.setAddress("address");
		user.setBirthday(new Date());

		userMapper.addUser(user);

		System.out.println(user);
	}
	
	@Test
	public void updateUserTest() {
		User user = new User();
		user.setUserId("99999");
		user.setUserName("userName2");
		user.setPassword("password2");
		user.setPhone("phone2");
		user.setAddress("address2");
		user.setBirthday(new Date());
		
		userMapper.updateUser(user);
		
		System.out.println(user);
	}

}

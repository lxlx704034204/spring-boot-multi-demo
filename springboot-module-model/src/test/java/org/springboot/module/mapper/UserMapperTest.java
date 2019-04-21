package org.springboot.module.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springboot.module.BaseUnitTest;
import org.springboot.module.mapper.UserMapper;
import org.springboot.module.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseUnitTest {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void selectByIdTest() {
		User user = userMapper.selectById("10001");
		assertNotNull("user is null !!!", user);
		System.out.println(user);
	}

}

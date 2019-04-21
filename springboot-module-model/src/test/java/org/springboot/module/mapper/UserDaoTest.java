package org.springboot.module.mapper;

import org.junit.Test;
import org.springboot.module.BaseUnitTest;
import org.springboot.module.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseUnitTest{
	@Autowired
	private IUserDao userDao;
	
	@Test
	public void selectByIdTest() {
		System.out.println("UserDaoTest::selectByIdTest()...");
		User user = userDao.selectById("10001");
		System.out.println(user);
	}

}

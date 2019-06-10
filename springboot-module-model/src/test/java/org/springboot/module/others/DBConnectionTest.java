package org.springboot.module.others;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springboot.module.mapper.SpUserMapper;
import org.springboot.module.mapper.UserMapper;
import org.springboot.module.model.User;
import org.springboot.module.self.DBUtils;

public class DBConnectionTest {


	@Test
	public void connectDBTest() throws Exception {
		System.out.println("hello");
		Connection conn = DBUtils.getConn();

		if (conn != null) {
			String userName = conn.getMetaData().getUserName();
			System.out.println("login user: " + userName);
		}

		DBUtils.closeConn(conn);
	}

	@Test
	public void mybatisConnectTest() throws IOException, SQLException {
		String resource = "mybatis_config_example.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		String userName = sqlSession.getConnection().getMetaData().getUserName();		
		System.out.println("login user: " + userName);
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.selectById("10001");
		System.out.println("user(10001):" + user);

		SpUserMapper spUserMapper = sqlSession.getMapper(SpUserMapper.class);
		user.setUserId("10002");
		spUserMapper.selectUserByUserId(user);
		System.out.println("user(10002): " + user);
		
		sqlSession.close();
	}

}

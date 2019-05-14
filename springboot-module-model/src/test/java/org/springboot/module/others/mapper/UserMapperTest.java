package org.springboot.module.others.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springboot.module.mapper.SpUserMapper;
import org.springboot.module.model.TestEntity;
import org.springboot.module.others.BaseJunit;
import org.springboot.module.others.MyBatisConnectUtil;

public class UserMapperTest extends BaseJunit {

	@Test
	public void selectUserAllTest() {

		try (SqlSession sqlSession = MyBatisConnectUtil.getSqlSession();) {
			SpUserMapper mapper = sqlSession.getMapper(SpUserMapper.class);
			Map<String, Object> params = new HashMap<>();

			mapper.selectUserAll(params);
			for (String key : params.keySet()) {
				System.out.println(key);
				System.out.println(params.get(key).getClass());
				System.out.println(params.get(key));
			}
			// sqlSession.close();
		} catch (Exception e) {
			System.err.println("error:" + e.getMessage());
		}
	}

	@Test
	public void batchAddUserTest() {
		try (SqlSession sqlSession = MyBatisConnectUtil.getSqlSession();) {
			SpUserMapper mapper = sqlSession.getMapper(SpUserMapper.class);
			Map<String, Object> params = new HashMap<>();
			List<TestEntity> users = new ArrayList<>();
			for (int i = 0; i < 2; i++) {
				TestEntity user = new TestEntity(i, "demo" + i);
				users.add(user);
			}
			params.put("iUsers", users);
			// params.put("vCount", 0);

			System.out.println("params.size() before is: " + params.size());
			mapper.batchAddUser(params);
			System.out.println("params.size() after is: " + params.size());

			for (String key : params.keySet()) {
				System.out.println(key + ": " + params.get(key));
			}
		} catch (Exception e) {
			System.err.println("error:" + e.getMessage());
		}
	}

}

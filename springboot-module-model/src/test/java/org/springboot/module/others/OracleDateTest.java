package org.springboot.module.others;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.springboot.module.self.DBUtils;
import org.springboot.module.self.DateUtils;

public class OracleDateTest {
	
	@Test
	public void test() throws Exception {
		Connection conn = DBUtils.getConn();
		String sql ="select user_name, birthday from t_user where user_id='10001'";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Object username = rs.getObject(1);
			Timestamp birthday = DBUtils.getOracleTimestamp(rs.getObject(2));		
			Date date  = new Date(birthday.getTime());
			System.out.println("username:" + username);
			System.out.println("birthday:" + DateUtils.getCnDateTime(date,DateUtils.YYYY_MM_DD_HH_MM_DD));
			System.out.println("birthday.getTime():" + birthday.getTime());
			System.out.println("date:" + DateUtils.getCnDateTime(date,DateUtils.YYYY_MM_DD_HH_MM_DD));
			System.out.println("date.getTime():" + date.getTime());
		}
		DBUtils.closeConn(conn);
	}
	


}

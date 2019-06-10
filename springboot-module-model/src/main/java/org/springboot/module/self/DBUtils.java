package org.springboot.module.self;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;

public class DBUtils {
	
	private DBUtils() {
		
	}
	
	private static final String JDBCNAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:cchdba";
	private static final String USER = "cch";
	private static final String PASSWORD = "root";

	public static Connection getConn() throws Exception {
		Class.forName(JDBCNAME);
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("connection has been created...");
		return conn;
	}

	public static void closeConn(Connection conn) throws Exception {
		if (conn != null) {
			conn.close();
		}
		System.out.println("connection has been closed...");
	}
	
	public static Timestamp getOracleTimestamp(Object value) {
	    try {
	        Class<? extends Object> clz = value.getClass();
	        Method m = clz.getMethod("timestampValue");
	        //m = clz.getMethod("timeValue", null); 时间类型
	        //m = clz.getMethod("dateValue", null); 日期类型
	        return (Timestamp) m.invoke(value);	 
	    } catch (Exception e) {
	        return null;
	    }
	}

}

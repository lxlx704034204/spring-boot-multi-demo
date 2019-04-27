package org.springboot.module.typehandler;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeException;
import org.springboot.module.model.TestEntity;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;

//这个注解声明了他是处理jdbc类型的  @MappedTypes()也可以用这个注解指定javaType.进行约束,一般不用
@MappedJdbcTypes(JdbcType.ARRAY)
public class UserArrayTypeHandler extends BaseTypeHandler<List<TestEntity>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<TestEntity> parameter, JdbcType jdbcType)
			throws SQLException {
		String typeName = null;
		if (parameter instanceof List) {
			// typeName = "SELF_TestEntity";
			typeName = "PKG_SEFTTYPE_TEST.SELF_USER_ARRAY";
		}
		if (typeName == null) {
			throw new TypeException(
					"TestEntityArrayTypeHandler parameter typeName error, your type is " + parameter.getClass().getName());
		}
		// 这3行是关键的代码，创建Array，然后ps.setArray(i, array)就可以了
		System.out.println("##########");
		// ERROR TODO
		Connection conn = ps.getConnection();
		
		//Array array = conn.createArrayOf(typeName, parameter.toArray());
		//ps.setArray(i, array);
		// 这里必须得用大写，而且必须要引入一个包，如果不引入这个包的话字符串无法正常转换，包是：orai18n.jar(这个并没试过)
		// 这个应该是封装的一个转换方法吧.不是很清楚
		 ArrayDescriptor arrayDes = ArrayDescriptor.createDescriptor("CCH.PKG_TYPETEST.S_U_ARY",conn);
		 //这里是声明一个数据库的数组类型
		 ARRAY array = new ARRAY(arrayDes, conn, parameter.toArray());
		 ps.setArray(i, array);
		System.out.println("***********");
		
	}

	@Override
	public List<TestEntity> getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestEntity> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TestEntity> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

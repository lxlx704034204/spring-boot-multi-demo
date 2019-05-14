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
import org.springboot.module.model.TestEntity;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

//这个注解声明了他是处理jdbc类型的  @MappedTypes()也可以用这个注解指定javaType.进行约束,一般不用
@MappedJdbcTypes(JdbcType.ARRAY)
public class UserArrayTypeHandler extends BaseTypeHandler<List<TestEntity>> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, List<TestEntity> parameter, JdbcType jdbcType)
			throws SQLException {
		// 数据库的type名必须大写
		String selfType = "SELF_TYPE";
		String selfTypeArry = "SELF_TABLE_TYPE";
		// 这3行是关键的代码，创建Array，然后ps.setArray(i, array)就可以了
		Connection conn = ps.getConnection();
		ARRAY array = null;
		array = getArray(conn, selfType, selfTypeArry, parameter);
		ps.setArray(i, array);
	}

	private ARRAY getArray(Connection con, String OracleObj, String Oraclelist, List<TestEntity> data)
			throws SQLException {
		// 定义描述
		StructDescriptor structdesc = new StructDescriptor(OracleObj, con);
		ArrayDescriptor desc = ArrayDescriptor.createDescriptor(Oraclelist, con);
		// 定义结构数组
		STRUCT[] structs = new STRUCT[data.size()];
		for (int i = 0; i < data.size(); i++) {
			Object[] result = { data.get(i).getId(), data.get(i).getName() };
			structs[i] = new STRUCT(structdesc, con, result);
		}
		// 返回ARRAY
		return new ARRAY(desc, con, structs);
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

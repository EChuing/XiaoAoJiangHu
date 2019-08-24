package cn.itcast.b_metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import cn.itcast.utils.JdbcUtil;

public class App {

	//1. 数据库元数据
	@Test
	public void testDB() throws Exception {
		// 获取连接
		Connection conn = JdbcUtil.getConnection();
		// 获取数据库元数据
		DatabaseMetaData metaData = conn.getMetaData();// alt + shift + L  快速获取方法返回值
		
		// 基本不用
				//获取用户名字
				System.out.println(metaData.getUserName());
				//获取连接路径
				System.out.println(metaData.getURL());
				//获取数据库类型
				System.out.println(metaData.getDatabaseProductName());
	}
	




	//2. 参数元数据（主要）
	@Test
	public void testParams() throws Exception {
		// 获取连接
		Connection conn = JdbcUtil.getConnection();
		// SQL
		String sql = "select * from dept where deptid=? and deptName=?";
		// Object[] values = {"tom","888"};
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 参数元数据									 //（me te） 元
		ParameterMetaData p_metaDate = pstmt.getParameterMetaData();
		// 获取参数的个数       (pe rua mente)参数
		int count = p_metaDate.getParameterCount();// 获取元数据（基本数据类型）的 个数
		
		
		// 测试
		System.out.println(count);
	}
	
	// 3. 结果集元数据
	@Test
	public void testRs() throws Exception {
		String sql = "select * from dept ";
		
		// 获取连接
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		// 得到结果集元数据(目标：通过结果集元数据，得到列的名称)
		ResultSetMetaData rs_metaData = rs.getMetaData();
		
		// 迭代每一行结果
-->主要 while (rs.next()) {
			// 1. 获取列的个数
			int count = rs_metaData.getColumnCount();
			// 2. 遍历，获取每一列的列的名称
			for (int i=0; i<count; i++) {
				// 得到列的名称
				String columnName = rs_metaData.getColumnName(i + 1);
				// 获取每一行的每一列的值
				Object columnValue = rs.getObject(columnName);
				// 测试
				System.out.print(columnName + "=" + columnValue + ",");
			}
			System.out.println();
		}
		
	}
	
	
	
}









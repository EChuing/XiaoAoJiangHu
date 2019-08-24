JDBC 主要用于连接数据库， 调用数据库的信息



Util 类
----------------------------------------------------------
package cn.itcast.utils;

import java.sql.Connection;		科 ne 沈
import java.sql.DriverManager;  拽we，妈呢爪
import java.sql.ResultSet;		ruisou Set
import java.sql.SQLException; 
import java.sql.Statement;		Sdei ment

public class JdbcUtil{
	
	//路径对象
	private static String url = "jdbc:mysql:///jdbc_demo";
	//用户名对象
	private static String user = "root";
	//密码对象
	private static String password = "root";


	/**
			静态代码块中（只加载一次）
	*/
	public static Connection getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url,user,password);
		}catch (Exception e){

			throw new RuntimeException(e);
		}
	}
	public static void clloseAll(Connection con, Statement stmt, ResultSet rs){
		try{
			if (rs != null){
				rs.close();
			}
			if (stmt != null){
				stmt.close();
			}
			if (con != null){
				con.close();

			}
		}catch (SQLException e ){
			throw new RuntimeException(e);
		}
	}
}



WebUtils 类
-------------------------------
package cn.itcast.utils;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

public class WebUtils{
	/**
		处理请求数据的封装
	*/
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz){
		try{
			//这里可以写 注册日期类型的转换器

			


			//创建对象
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e ) {
			throw new RuntimeException(e);
		}
	}
}


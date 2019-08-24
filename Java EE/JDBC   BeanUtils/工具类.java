Util 类
-----------------------------------------------------------------

package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtil {

	
	// private String url = "jdbc:mysql://localhost:3306/jdbc_demo";
	private static String url = "jdbc:mysql:///jdbc_demo";
	private static String user = "root";
	private static String password = "root";

	/**
	 * 静态代码块中（只加载一次）
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	public static void closeAll(Connection con, Statement stmt, ResultSet rs) {
		try {					//快捷键捕获异常 Alt + Shift + z 
			if (rs != null) {
				rs.close(); // 只是关闭 并未释放资源
				rs = null; // 建议垃圾回收器释放资源
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null && !con.isClosed()) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}


WebUtils 类
----------------------------------------------------------
package cn.itcast.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


public class WebUtils {
	/**
	 * 处理请求数据的封装
	 */
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		try {
			// （此处可写 注册日期类型转换器）
			
			// 创建对象
			T t = clazz.newInstance();
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

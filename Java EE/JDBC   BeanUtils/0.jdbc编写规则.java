 package gz.itcast.a_tag;

import java.sql.Connection;
import java.sql.Statement;

注册驱动
连接对象
创建Statement

发送sql语句    查询语句   and  更新语句

关闭对象



public class Demo {
	//连接数据库的URL
	private String url = "jdbc:mysql://localhost:3306/day15";
					    //jdbc协议：数据库类型：//主机：端口号/连接的数据库

	private String user = "root";//用户名
	private String password = "root";//密码
	
	//第一种方法
	@Test
	public void testl() throws Exception{
		//1.创建驱动程序类对象
		//     zhuai  we
		Driver driver = new com.mysql.jdbc.Driver() ; //新版本
	  //Driver driver = new org.gjt.mm.mysql.Driver();  // 旧版本
		
		//2.设置用户名和密码
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", password);
		
		//连接数据库，返回连接对象
		Connection conn = driver.connect(url, props);
		 
		System.out.println(conn);
	}
	
	//使用驱动管理器类连接数据库(注册了两次，没必要)
	@Test
	public void test2() throws Exception{
		Driver driver = new com.mysql.jdbc.Driver();
		//Driver driver2 = new com.oracle.jdbc.Driver();
		//1.注册驱动程序(可以注册多个驱动程序)
		DriverManager.registerDriver(driver);
		//DriverManager.registerDriver(driver2);
		
		//2.连接到具体的数据库
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		
	}
				throw new RuntimeException(e);

	 //（推荐使用这种方式连接数据库）
	 //推荐使用加载驱动程序类  来 注册驱动程序 
	@Test
	public void test3() throws Exception{
		//Driver driver = new com.mysql.jdbc.Driver();
		
		//通过得到字节码对象的方式加载静态代码块，从而注册驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//Driver driver2 = new com.oracle.jdbc.Driver();
		//1.注册驱动程序(可以注册多个驱动程序)
		//DriverManager.registerDriver(driver);
		//DriverManager.registerDriver(driver2);
		
		//2.连接到具体的数据库
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		
	}

}


class Demo{
	//连接数据库的URL
	private String url = "jdbc:mysql://localhost:3306/day15";
					    //jdbc协议：数据库类型：//主机：端口号/连接的数据库

	private String user = "root";//用户名
	private String password = "root";//密码
	Connection conn = null;
	Statement stmt = null ;
	public void testInsert(){
		
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
	
			//2.获取连接对象
			 conn = DriverManager.getConnection(url,user,password);		
			
			//3.创建Statement对象    si deitemen
			 stmt = conn.createStatement();
			//4.sql语句
			String sql = "INSERT INTO studen(NAME,gender) VALUES('李四','女')";
			//5.执行sql语句
			int count = stmt.executeUpdate(sql);
			System.out.println("影响了"+count+"行");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			// 先创建 后关闭
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
		}
	}
}


// 可以用于执行DDL和DML 语句
--------------------------------------------------------------------

class Demo{
	
	public void tset1(){
		Connection conn = null ;
		Statement stmt = null ; 
		try{
			//获取连接
			conn = JdbcUtil.getConnection();  //  弄成工具直接调用
			//创建Statement
			stmt = conn.createStatement();
			//准备sql
			String sql = "SELECT * FROM student";
			//执行sql   rv sao set
			ResultSet rs = stmt.execute(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn,stmt);
		}
	}
}





// 公共部分提取成工具类 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcUtil {
	// 连接数据库的URL
	private static String url = "jdbc:mysql://localhost:3306/day15";
	private static String user = "root";// 用户名
	private static String password = "root";// 密码

	// 静态代码块 只加载一次
	static {
		// 注册驱动程序
		try {// (zhuai we)   通过字节码对象 加载静态代码块 ，从而注册驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动程序注册出错");
		}
	}

	// 抽取获取连接对象的方法
	public static Connection getConnection(){
		try {
			//连接到具体数据库
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 释放资源方法     （关闭资源）
	public static void close(Connection conn, Statement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}

}

------------------------------


@Test
	public void test1(){
		//连接到具体数据库
		Connection conn = null;
		
		Statement stmt = null;
		try{
			//获取连接
			conn = JdbcUtil.getConnection();
			//创建Statement
			stmt = conn.createStatement();
			//准备sql
			String sql = "SELECT * FROM student";
			//执行sql
			ResultSet rs = stmt.executeQuery(sql);
			
			//移动光标
			/*boolean flag = rs.next();
			
			flag = rs.next();
			flag = rs.next();
			if(flag){
				//取出列值
				//索引
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				System.out.println(id+","+name+","+gender);
				
				//列名称
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				System.out.println(id+","+name+","+gender);
			}*/
			
			//遍历结果
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				System.out.println(id+","+name+","+gender);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
}
package cn.itcast.DBCP;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class App {

	//硬编码方式实现连接池  
	@Test
	public void testDbcp() throws Exception{
		//DBCP连接池核心类      date sosi
		BasicDataSource dataSouce = new BasicDataSource();

		//连接池参数初始化： 初始化连接数、最大连接数、当前连接数
		
		dataSouce.setUrl("jdbc:mysql:///jdbc_Demo");//数据库连接字符串
		dataSouce.setDriverClassName("com.mysql.Driver");//驱动
		dataSouce.setUsername("root");//数据库连接用户
		dataSouce.setPassword("root");//数据库连接密码
		dataSouce.setInitialSize(3);//初始化连接
		dataSouce.setMaxActive(6);//最大连接数（setmax a tetui）
		dataSouce.setMaxIdle(3000);//最大空闲时间
		
		//获取连接
		Connection con = dataSouce.getConnection();
		//													(X qiu  a det)执行更新						
		con.prepareStatement("select from admin where id=3").executeUpdate();
		//关闭
		con.close();
	} 





-----------------------------------------------------------------------------
	

	@Test
	// 2. 【推荐】配置方式实现连接池  ,  便于维护
	public void testProp() throws Exception {
		// 加载prop配置文件
		Properties prop = new Properties();
		// 获取文件流
		InputStream inStream = App.class.getResourceAsStream("db.properties");
		// 加载属性配置文件
		prop.load(inStream);
		// 根据prop配置，直接创建数据源对象
		DataSource dataSouce = BasicDataSourceFactory.createDataSource(prop);
		
		// 获取连接
		Connection con = dataSouce.getConnection();
		con.prepareStatement("delete from admin where id=4").executeUpdate();
		// 关闭
		con.close();
	}
}

/**    文件 ：db.properties
 * 
  		url=jdbc:mysql:///jdbc_demo
		driverClassName=com.mysql.jdbc.Driver
		username=root
		password=root
		initialSize=3
		maxActive=6
		maxIdle=3000
*/

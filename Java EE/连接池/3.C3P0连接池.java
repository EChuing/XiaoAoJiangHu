package cn.itcast.C3P0;

import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0 {

	/**
	 * 1.硬编码实现C3P0    不便于维护
	 * @throws Exception
	 */
	@Test
	public void testCod() throws Exception{
		//创建连接核心工具类 (kanbo pou date sousi )
		ComboPooledDataSource  dataSource = new ComboPooledDataSource();
		//设置连接池参数，url、驱动、用户密码、初始连接数、最大连接数
		dataSource.setJdbcUrl("jdbc:mysql:///jdbc_Demo");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		dataSource.setMaxIdleTime(1000);
		
		//从连接池对象中，获取连接对象
		Connection con = dataSource.getConnection();
		//执行更新
		con.prepareStatement("delete form admin where id=7").execute();
		//关闭
		con.close();
		
	}
	
		


	/**
	 * 2.XML配置方式:使用c3p0连接池管理连接
	 * 开发三部曲               1.引入.jar文件      	2.引入配置		3.程序中使用下面的代码
	 * 需要  c3p0-config.xml 放进src中
	 * @throws Exception
	 */
	@Test
	public void testXML() throws Exception{

		//创建c3p0连接池核心工具
		//自动加载src下p3co的配置文件     （c3p0-config.xml） 自己下载
		ComboPooledDataSource dataSource = new ComboPooledDataSource();//这里可以指定引入的xml配置的config 若没有就会是有默认的配置    若默认配置出错  程序就会报错
		
		//获取连接
		Connection con = dataSource.getConnection();
		//执行更新
		con.prepareStatement("select * from admin").executeUpdate();
		//关闭
		con.close();
	}
}

文件 ： c3p0-config.xml



<c3p0-config>
	<default-config>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/jdbc_demo
		</property>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="user">root</property>
		<property name="password">root</property>
		<property name="initialPoolSize">3</property>
		<property name="maxPoolSize">6</property>
		<property name="maxIdleTime">1000</property>
	</default-config>


	<named-config name="oracle_config">
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/jdbc_demo</property>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="user">root</property>
		<property name="password">root</property>
		<property name="initialPoolSize">3</property>
		<property name="maxPoolSize">6</property>
		<property name="maxIdleTime">1000</property>
	</named-config>


</c3p0-config>
------------------------------------------------------------------------------

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class App {
	private String url = "jdbc:mysql://localhost:3306/jdbc_demo";
	private String ni = "root";
	private String nii = "root" ;
	
	//(ke neshen)
	Connection con;
	//(si deimen)
	Statement stmt ;
	ResultSet rs;
	
	
"1.没有防止sql注入的案例
	@Test
	public void testLogin() throws Exception{
			//模拟用户登录用户名，密码
			String userName ="tom100";
			//String pwd = "888";
			String pwd = " 'or 1=1 -- ";  //使用 注入  
			
			
			//SQL语句
			String sql="select * from admin where userName='"+userName+"' and pwd='"+pwd+"' ";

		try {
			//1.1加载驱动，创建连接		
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url,ni,nii);
			//1.2创建stmt对象
			stmt = con.createStatement();
			//1.3执行查询
			rs=stmt.executeQuery(sql);
			//业务判断
			if(rs.next()){
				System.out.println("登录成，编号:"+rs.getInt("id"));
			}else{
				System.out.println("账户不存在！！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//1.4关闭
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}


------------------------------------------------------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class App {
	private String url = "jdbc:mysql://localhost:3306/jdbc_demo";
	private String ni = "root";
	private String nii = "root" ;
	
	
	
	//(ke neshen)
	Connection con;
	
	//(pu pedsi deimen t)
	PreparedStatement pstmt;  // 有效防注入 方式登录
	ResultSet rs;
	
"防注入登录方式
	@Test
	public void testLogin() throws Exception{
			//模拟用户登录用户名，密码
			String userName ="tom";
			//String pwd = "888";
			String pwd = " 'or 1=1 -- ";  //使用 注入  
			
			
			//SQL语句
			String sql="select * from admin where userName=? and pwd=?";

		try {
			//1.1加载驱动，创建连接		
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url,ni,nii);
			//1.2创建stmt对象
			pstmt = con.prepareStatement(sql);//创建对象时就传入SQL语句
			//设置支占位符值
			pstmt.setString(1,userName);
			pstmt.setString(2, pwd);
			
			//1.3执行查询
			rs=pstmt.executeQuery(); // 区分上面  用perpaer的这里不用传 sql语句 

			
			//业务判断 
			if(rs.next()){
				System.out.println("登录成，编号:"+rs.getInt("id"));
			}else{
				System.out.println("账户不存在！！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//1.4关闭
			try {
				
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}




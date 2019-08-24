import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class Demo{

	/**
	  * 添加     相比之前的 ；(2)处的好处在于有几个? 就赋值多少次  
	  *							不会找出混乱
	  */
	
	public void testl(){
	Connection conn = null ;
	//(pu tede si deiment)
	PreparedStatement stmt = null;
	try {
		//1.获取连接
		conn = JdbcUtil.getConnection();
		//2.准备预编译的sql
		String sql ="INSERT INTO student(NAME,gende) VALUES(?,?)";
		//3.执行预编译sql语句
			stmt = conn.prepareStatement(sql);
		//4.设置参数的值   setXX方法   根据（2）判断 ： 字符串型        ； 参数位置从1开始
			stmt.setString(1, "李四");
			stmt.setString(2, "王五");

		//5.发送参数
			int count = stmt.executeUpdate();
			
		System.out.println("影响了"+count+"行！");	
	}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
}
	
----------------------------------------------
	/**
	  * 修改
	  * 在原基础上只需修改     （ 预编译语句 ，  更改替换参数值）
	  * 
	  * 删除
	  * 修改 预编译语句  更改设置参数值的语句
	  
	  */
	
	public void testl(){
	Connection conn = null ;
	//(pu tede si deiment)
	PreparedStatement stmt = null;
	try {
		//1.获取连接
		conn = JdbcUtil.getConnection();
		
		//2.准备预编译的sql 
			// 修改！
			//String sql ="UPDATE student SET NAME=? WHERE id=?";   //修改的 可以用 ？ 代替
			
			//删除！
			//String sql = "DELETE FROM student WHERE id=?";
		
		//3.执行预编译sql语句
			stmt = conn.prepareStatement(sql);
		
		//4.设置参数的值     注意这里要按顺序（第一个问号..第二个问号）   并判断原基础的数据类型
			//修改！
			//stmt.setString(1, "李白");   
			//stmt.setInt(2,9);
			
			//删除！
			//set.setInt(1,9); 第一个 ？的  ID=9  的 数据 执行预编译语句
			
			
			
		//5.发送参数
			int count = stmt.executeUpdate();
			
		System.out.println("影响了"+count+"行！");	
	}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(conn, stmt);
		}
	}
--------------------------------------------
	/**
	 * 查询
	 * 
	 */
	public void testl(){
	Connection conn = null ;
	//(pu tede si deiment)
	PreparedStatement stmt = null;
	
	//查询 会多出新建对象 需要关闭
	ResultSet rs = null ; 
	try {
		//1.获取连接 
		conn = JdbcUtil.getConnection();
		
		//2.准备预编译的sql
		String sql ="SELECT * FROM student";
		
		//3.执行预编译sql语句
			stmt = conn.prepareStatement(sql);
		
		//执行sql
			 rs = stmt.executeQuery();  //没有读取到数据就会放回fales
		//遍历rs
			while(rs.next()){   //next  读取数据 （存在放回true） 并自动跳下一行
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				System.out.println(id+","+name+","+gender);	
			}
	}catch(Exception e){
		e.printStackTrace();
		throw new RuntimeException(e);
	}finally{
		JdbcUtil.close(conn, stmt,rs);
	}
	}	
}  


public class JdbcUtil{

	private static String url = "jdbc:mysql://localhost:3306/day15";
	private static String user = "root";
	private static String pwd = "root";

	//静态代码块   只加载一次
	// 当jdbc 被调用时 会自动加载
	static{
		try{
			//注册驱动程序
			//通过字节码对象加载静态代码块 来注册驱动
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e)
			e.printStackTrace();
			System.out.println("注册驱动程序出错！")
	}


	//抽取  获取连接对象的方法
	public static Connection getConnection(){
		try{
			Connection conn = DriverManager.getConnection(url,user,pwd);
			return conn;
		}catch(SQLException e){
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

----------------------------
执行 SQL 语句的方法： 有sql执行的内容 决定
	executeQuery()		执行查询，产生单个结果集的语句，例SELECT  
	executeUpdate()		执行更新，返回影响的行数 
	execute()			了解， 其他高级别的功能




------------
这种方式的sql语句是写死的   存在注入风险


class Demo{
	private String url = "jdbc:mysql://localhoat:3306/day15";

	private String use = "root";
	private String pwd = "root";
	
	Connection conn = null; 
	Statement stmt = null;


	public void test(){
	
		try{
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn = DriverManager.getConnection(url,use,pwd);
			//创建sql语句
			stmt = conn.createStatement();
			
			//编写sql语句
			String sql = "INSERT INTO studen(name ,gender) VALUES（'李四','女'）";
			//执行sql语句
			int count = stmt.executeUpdate(sql);
			System.out.println("影响了"+count+"行.");
		}catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			//先创 后关
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





--防注入--------
sql语句有多少个？ 就赋值多少次 

Connection con ; 
PreparedStatement pstmt ;  //有效防注入
ResultSet rs ; 

public  void tset() throws Exception{
	String user = "tom";
	String pwd = "    'or 1=1 --   " ; 注入

	String sql = "select * from admin where user=? and pwd=?";

	try{
		//加载驱动，创建连接
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection( url,user,pwd );

		//创建stmt对象 创建的时候就传入sql语句
		pstmt = con.prepareStatement(sql)； // PreparedStatement 少个 d
		
		//对 ?  赋值
		pstmt.setString(1,user);
		pstmt.setString(2,pwd);
		//执行
		rs = pstmt.executeQuery(); //不用传入 sql 
	
		//业务判断 
		if(rs.next()){//next()不存在会返回false 并跳到下一行
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



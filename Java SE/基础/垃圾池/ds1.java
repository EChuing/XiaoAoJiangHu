Jdbc
--------------------------

executeQuery() 执行查询	 
executeUpdate() 执行更新



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



class Demo{
	private String url = "jdbc:mysql://localhoat:3306/day15";

	private String use = "root";
	private String pwd = "root";

	Connection con; 
	PreparedStatement pstmt ;
	ResultSet rs;
	public void test() throws Exception{
	
	try{
		//加载驱动，创建连接
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,use,pwd);
		//创建stmt对象，并传入sql语句
		pstmt = con.prepareStatement(sql);

		//对 问号 赋值
		pstmt.setString(1,use);
		pstmt.setString(2,pwd);
		//执行sql语句
		rs = pstmt.executeQuery();
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




String name = new String(name.getBytes("ios-8859-i"),"utf-8");

request.set Character Encoding("utf-8");
set kawe duingkoding


String name = new String(name.getBytes("ios-8859-i"),"utf-8");
request.set Character Encoding("utf-8");
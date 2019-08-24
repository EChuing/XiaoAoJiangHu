/*
以后数据库的用户名与密码一般会 保存到properties(配置文件)pe lou pe tisi


一般情况下程序不能写死

*/




class Demo {
	//程序写死  称：硬编码
	static String userName = "root";
	static String password = "123";

	public static void main(String[] args) 
	{
		System.out.println("用户名： "+userName+ "密码： "+password);
	}
}

----------------------------
//如果经常发生变化的书我们可以定义在配置文件上。 比如：数据库的用户名和密码

配置文件的路径应该如何写？
			
			绝对路径（指明文件路径）：一个文件的完整路径信息。
						缺陷：绝对路径都包含盘符  在Linux中  只有 " \ " 代表根目录
							  有些系统是没有盘符的
			相对路径：相对于当前程序的路径，执行java命令时，控制台所在的路径就是当前路径		
			
			类文件路径：用classpath的路径找对应资源文件


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;




public class Demo110 {
	
	static Properties properties;  
	
	static{
		try {		
			properties = new Properties();
			//去加载配置文件                  加载附加文件
	法一：	properties.load(new FileReader("db.properties"));  
		
		/*--------------------------------------
		法二：//用类文件路径
				

				Class clazz = DBUtil.class;   // 获取class对象
				
				InputStream inputStream 
				= clazz.getResourceAsStream("/db.properties");  // " / "代表Classpath路径
						（get sousi As siqun） 一定要用这个方法
				
				
				最后返回的类型可以利用           				
				properties.load(inputStream);
		
		---------------------------------------*/



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("用户名： "
		+properties.getProperty("userName")
		+"密码： "+properties.getProperty("password"));


		//显示当前路径
		System.out.println("当前路径： "+new File(".").getAbsolutePath());


	}

}

------------------------------------------

//附加文件  DB.properties

userName=廖乐萍
password=123123
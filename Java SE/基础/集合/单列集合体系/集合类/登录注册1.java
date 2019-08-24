reg login

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/*
 
作业2：使用集合实现注册登陆功能，

第一步： 提示用户选择功能， A（注册）  B(登陆) 。 要求： 功能选择 的时候要忽略大小写。

注册：
	1. 提示用户输入注册的账号(数字)与密码，如果输入账号已经存在集合中，提示用户重新输入。 注册完毕之后，把集合中的所有用户信息打印出来。(使用：toArrry()方法)	
登陆： 
	提示用户输入登陆的账号与密码,如果账号与密码这个用户已经存在集合中，那么登陆成功，否则登陆失败。
 
 
 
 */
//用户
class User{
	
	int id;  //账号
	
	String password;  //密码

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String password) {
		this.id = id;
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		User user = (User)obj;
		return this.id==user.id;
	}
	
	@Override
	public String toString() {
		return "{ 账号："+this.id+" 密码："+this.password+"}";
	}
}


public class Demo {
	
	static Scanner scanner = new Scanner(System.in);  //键盘输入
	
	//父类指向型   
	static Collection users = new ArrayList(); //使用该集合保存所有的用户信息..    Collection 单列集合的根接口
	//多态：提高代码的扩展性
	public static void main(String[] args) {
		
		while(true){  // 用于不断循环  为是么是   true  还不懂
			System.out.println("请选择功能      A(注册 )    B(登陆)");
				  （噢 shen）
			String option = scanner.next();		// 用于存储   获取的元素	
			if("a".equalsIgnoreCase(option)){   // 与'a' 比较  不考虑大小写
				 reg();
				
						（yi kuo Ege nokei） 忽略大小写
			}else if("b".equalsIgnoreCase(option)){
				login();
				
				
			}else{
				System.out.println("你的选择有误,请重新输入");
			}
		}
		
	}
	
//生成自定义代码块   在eclipse 中 选中代码  - Refactor - Extract Method

//登录     
	public static void login() {
		System.out.println("请输入账号：");
		int id = scanner.nextInt();
		System.out.println("请输入密码:");
		String password = scanner.next();
		//判断集合的用户是否存在该用户名与密码
		//遍历集合的元素，查看是否存在该用户信息
		
		boolean isLogin = false; 	//定义变量用于记录是否登陆成功的信息  , 默认是没有登陆成功的
		Iterator it = users.iterator();
		while(it.hasNext()){
			User user = (User) it.next();
			if(user.id==id&&user.password.equals(password)){
				//存在该用户信息，登陆成功...
				isLogin = true;
			}
		}
		
		if(isLogin==true){
			System.out.println("欢迎登陆...");
		}else{
			System.out.println("用户名或者密码错误，登陆失败...");
		}
	}
	
	
//注册
	public static void reg() {
		//110  , 220
		User user = null;
		while(true){
				System.out.println("请输入账号:");
				int id = scanner.nextInt();  //220 
				user = new User(id,null);
				if(users.contains(user)){  // contains底层依赖了equals方法。
					//如果存在
					System.out.println("该账号已经存在，请重新输入账号");
				}else{
					//不存在
					break;
				}
		}
		
		System.out.println("请输入密码：");
		String password = scanner.next();
		user.setPassword(password);
		//把user对象保存到集合中
		users.add(user);
		System.out.println("注册成功!");
		System.out.println("当前注册的人员："+users);
	}

}

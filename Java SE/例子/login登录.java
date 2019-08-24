/*

作业2：使用集合实现注册登陆功能，

第一步： 提示用户选择功能， A（注册）  B(登陆) 。 
要求： 功能选择 的时候要忽略大小写。



注册：
	1. 提示用户输入注册的账号(数字)与密码，
	如果输入账号已经存在集合中，提示用户重新输入。
	注册完毕之后，把集合中的所有用户信息打印出来。
	(使用：toArrry()方法)	

登陆： 
	提示用户输入登陆的账号与密码,如果账号与密码这个
	用户已经存在集合中，那么登陆成功，否则登陆失败。
 

*/

class  User
{
	int id; 
	
	String password;

	public int getId(){
		return id;
	}
	
	public String getPassword(){
		return password()
	}
	
	public boolean equals(Object obj){
		User user = User(obj);
		return this.id==user.id;
	}
		
	public String toString(){	
		return "{ 账号："+this.id+" 密码："+this.id+"}";
	}


}

public class Demo{
	
	static Scanner secanner = new Scanner(System.in);
	/* Object 增删快 查寻慢  存储数据*/
	static Collection user = new ArrayList()
	
	public static void main(String[] args)
	{
		while(true){
			System.out.println("请输入功能  A（注册）   B（登录）");
			String option = scanner.next(); // 存储   获取元素
			if("a".equalsIgnoreCase(option))
				reg();
			}else ("b".equalsIgnoreCase(option)){
				login();
			}else{
				System.out.println("你的输入有误， 请重新输入");
			}
		}
	}


	public static void login(){
		System.out.println("请输入账号");
		int id = scanner.nextInt();
		System.our.println("请输入密码");
		String password = scanner.next();


		//定义一个标记 是否成功登录
		boolean isLofin = false;
		Iterator it = users.iterator();
			while(it.hasNext()){
				User user = (User) it.next();
				if(user.id==id&&user.password.equals(password)){
					//存储信息
					isLogin true;
				}
			}	
		if(isLogin==true){
			System.out.println("欢迎登录..");
		}else {
			System.out.println("用户名或密码错误，登录失败")；
		}
	
	}
	

	public static void reg(){
		User user = null;
		while(true){
			System.out.println("请输入账号:");
			int id = scanner.nextInt();
			user = new User(id,null);
			if(user.containe(user)){
				System.out.println("该账号已经存在");
			}else{
				//不存在
				break;
			}
		}
		System.out.println("请输入密码：");
		String password = scanner.next();
		user.setPassword(password);
		users.add(user);
		System.out.println("注册成功");
		System.our.println("当前注册人员："+users);
	}

}
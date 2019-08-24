'在登录注册 的基础上 添加 判断是否已经存在的 功能'


键盘输入用户名 与 密码，如果用户名与密码 已经存在集合中
						  那么视为重复元素，不允许添加到HashSet


难点：数据 都是字符串  需要返回 int类型 数据


class User
{	String userName;
	String password;

	public User(String userName, String password){
		super();
		this.userName = userName;
		this.password = password;
	
	}
	public String toString(){
		return "{ 用户名："+this.userName+"密码："+this.password+"}";
	}

	//N1   
	public int hashCode(){
		return userName.hashCode()+password.hashCode();
	}

	public boolean equals(Object obj){
		User user = (User)obj;   // 强行转换
		return this.userName.equals(user.userName)&&this.password.equals(user.password);
	}

}
public class Demo{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		HashSet set	= new HashSet();

		while(true)
		{
			System.out.println("请输入用户名");
			String userName = scanner.next();
			System.out.println("请输入密码");
			String password = scanner.next();
			//创建一个对象
			User user = new User(userName,password);
			if(set.add(user)){    // 运用Set 里的 HashCode  需要重写 N1
				System.out.println("注册成功");
				System.out.println("当前的用户有："+set);
			
			}else{
				System.out.println(注册失败);
				 }
		}


	
	}
}

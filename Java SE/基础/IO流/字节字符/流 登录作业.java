
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

'需求：   用缓冲输入 输出字符流 写登录器'



public class Login{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("请选择功能： A(注册)	B(登录)");
		String option = scanner.next();
		if("a".equalsIgnoreCase(option)){
			//注册
			reg();
			
		}else if("b".equalsIgnoreCase(option)){
			//登录
			login();
		}else {
			System.out.println("你的输入有误！....");
		}
	}
	//注册
	public static void reg(){
		System.out.println("输入用户名：");
		String userName = scanner.next();
		System.out.println("输入密码：");
		String password = scanner.next();
		//把用户信息写到文件上去
		File file = new File("指定写入文件的路径");
		FileWriter fileWriter = new FileWriter(file,true);
		//建立缓冲输出字符流
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
		//把用户信息写出    （要回车换行）
		String info = userName+"	"+ password;
		bufferedWriter.write(info);
		bufferedWriter.newLine();
		//关闭资源
		bufferedWriter.close();
		
	}
	//登录
	public static void login(){
		System.out.println("输入用户名：");
		String userName = scanner.next();
		System.out.println("输入密码：");
		String password = scanner.next();
		String info = userName+"	"+password;  //对照上面 用 行 作判断 （出去切割字符 比较）
		//读取用户信息，查看是否存在，如果存在则成功
		//File file = new File("和上面相同");  可省略
		//建立和数据通道         FileReader() 直接传入路径可上略 new File()
		FileReader fileReader = new FileReader("写上面的路径");
		//建立缓冲输入字符流
		BufferedReader bufferedReader = new BufferedReader(fileReader); 
		String line = null;
		boolean isLogin = false; // 记录登录的标志   默认是失败的
		//不断读取文件的内容
		while((line = bufferedReader.readLine())!=null){
			if(info.equals(line)){
				System.out.println("登录成功.....");
				isLogin = true;
				break;
			}
		}
		if(isLogin){
			System.out.println("欢迎"+userName+"回来！");
		}else {
			System.out.println("不存在该用户信息,请注册!!");
		}
	}
}
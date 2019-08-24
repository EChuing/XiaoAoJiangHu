Web开发入门


之前的程序：java桌面程序，控制台控制  socket界面 	javaSE规范 （规范 就是里面的技术运行）
之后学习的： javaweb程序，浏览器控制					javaEE规范




JavaEE的13种技术
		JDBC					数据库访问技术
		JNDI					命名和目录接口
		EJB （企业Java Beans）	分布式应用
		RMI						用于远程对象
		JSPs (JavaServer Pages)		
		Java servlet
		Java IDL/CORBA
		JTA/JTS					Java事物体系/Java事物服务
		JavaMail / JavaBeans激活架构  
		JMS						Java信使服务
		XML						扩展标记语言
		SSH						struts+sprint+hibernate
		JAF
		












软件结构
		  （kelaien te）
		C/S： Client - Server  客户端 - 服务器
				QQ 红蜘蛛
			
			特点
				需下载客户端
				服务器升级，客户端就升级

           （bu laosi）
		B/S： Broswer - Server  浏览器 - 服务器
				QQ官网  ...
			
			特点
				只需浏览器即可
				服务器升级，浏览器不用升级


javaweb程序  就是 B/S模式


JAVAweb：

	客户端：不作要求

	服务器：  8核 8G以上   T来计算  带宽100M
		

		服务器的称呼：
				在PC中安装具有某项特殊功能的软件 ，就为某某服务器
						具有数据库管理服务		      数据库服务器
						具有发送邮件服务				    邮件服务器



Socket
---------------------
public class Server{
	public static void main(String[] args){
	
		//创建ServerSocket
		ServerSocket server = new ServerSocket(8888);  
		System.out.println("服务器已经开启！！！！！");
		//接受客户端连接
		Socket socket = server.Socket();
		//读取本地文件
		FileInputStream in = new FileInputStream(new File("文件路径"));
		//构建数据通道
		OutputStream out = socket.getOutputStream();
		//发送数据
		byte[] buf = new byte[1024];
		while(len=in.read(buf)!=-1){
			out.write(buf,0,len);
		}
		//关闭资源
		out.close();
		in.close();
	}

}

web服务就是 socket的服务器

浏览器就是一个socket的客户端

		
Web服务软件
		
	   "作用： 把本地资源共享给外部访问



		例如：	WebLogic  BEA公司的产品	支持javeEE规范
				WebSphere IBM公司的产品	支持javeEE规范
				JBoss Redhat公司的产品		支持javeEE规范


				Tomcat 开源组织Apache的产品     免费..(仅支持部分 servlet jsp jdbc )


		


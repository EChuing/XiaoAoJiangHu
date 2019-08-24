
'发送端
public class Demo{

	public static void main(String[] args)throws IOException{
		//建立UDP的服务
		DatagramSocket DSocket = new DatagramSocket();
		//准备数据  数据封装到数据包中
		String date = "UDP---------------";
		DatagramPacket packet = 
				new DatagramPacket(
			date.getBytes()
			,date.getBytes().length
			,InetAddress.getLocalHost
			,8080);

		//调用UDP 发送数据包
		DSocket.send(packet);
		//释放资源 实则关闭 端口号
		DSocket.close();
	}
}

public class Demo{

	public static void main(String[] args){
		DatagramSocket socket = new DatagramSocket();
		String data = "1111111111111";
		DatagramPacket packet = new DatagramPacket(
			data.getBytest()
			,data.getBytest().length
			,InetAddress.getLocalHost
			,8080
		);
		socket.send(packet);
		socket.close();
	}
}

public class Demo{
	public static void main(String[] args){
		DatagramSocket socke = new DatagramSocket();
		DatagramPacket packet = new DatagramPacket


	}

}


--------------------------------
'接收端
public class Demo1{

	public static void main(String) throws IOException{
	//建立UDP的服务 并监听一个端口
	DatagramSocket DSocket = new DatagramSocket(8080);
	//准备空包 存储数据
	DatagramPacket packet = new DatagramPacket(buf,buf.length);
	//调用UDP接收数据
	DSocket.recive(packet);   // recive 没接收到就一直等到
	System.oout.println("接收数据"+ new String(
		buf,0,packet.getLength())
	);//实际大小只有 packet知道

	//关闭资源
	DSocket.close();
	}
}

public class Demo{
	public static void main(String[] args){
		DatagramSocket socket = new DatagramSocket(8080);
		DatagramPacket packet = new DatagramPacket(
			buf,buf.length	
		);
		socket.recive(packet);
		socket.close();
	
	}
}

过滤规则------------------------------
	/*
		获取文件路径
		遍历文件（注意区分文件和文件夹）
	*/

public class Demo{
	public static void main(String args){
	
		File dir = new File("路径")
		
	}

	public static void flastFile(File dir){
		//获取所有的子文件
		File[] files = dir.listFiles();
		
		System.out.println("文件：");
		for(File fileItem.isFile()){
			if(fileItem.isFile()){//判断是否为文件
				System.out.println("/t"+fileItem.genName());
			}
	
		System.out.println("文件假：");
		for(File fileItem : files){
			if(fileItem.isDirectory()){
				System.out.println("\t"+fileItem.getName());
			}
		}
	}
}
sun过滤器---------------------------
/*
	实现FilenameFilter接口，重写过滤规则

*/
class MyFilter implements FilenameFilter{
	//重写
	public boolean accept(File dir, String name){
		//统计
		System.out.println("文件夹:"+dir+",文件名："+name);
		//返回指定类型的文件
		return namee.endsWith(".java");  
	}
}

public class Demo{
	public static void main(Sting[]  args){
		File dir = new File("路径")；//"E:\\"2015JAVA\\文件\\day6\\代码"
		listJava2(dir);
	}
	//这里获取所有文件 传到 过滤器中
	public static void listJava2(File dir){
	//获取所有文件夹和文件
	File[] files =	dir.listFiles(new MyFilter());
	
	//遍历
	for(File file : files){
		System.out.println(file.getName());
		
	}
	}
}











Collection 
	添加： add  addAll 
	删除： clear  remove 
	查看： size 
	判断： isEmpty   contains   containsAll
	迭代： toArray   iterator

Map
	添加： put  putAll
	删除： clear   remove 
	获取： get size
	判断： containskey  containsValue   isEmpty
	迭代： keySet   values  entrySet


编码问题

GET:	String name = new String(name.getBytes("ios-9958-i"),"utf-8");
POST:	request.set Character Encoding("UTF-8"); 
			set kawe duingkoding    // 设置  字符编码

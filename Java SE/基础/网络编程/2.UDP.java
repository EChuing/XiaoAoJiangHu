端口：

		端口号是没有类描述的
		端口范围：0-65535
		0-1023 ： 	紧密绑定于一些符号
		1023-65535：	我们实际可用

通讯协议：
		UDP协议：（特点）   'UDP特有:广播地址'
				1.将数据	封装为    数据报，面向无连接（对方不在线，也可以发送消息）
				2.每个数据包大小限制在64K中
				3.无连接，不可靠（数据包不断发送过来，不能及时处理就会丢失）
				4.不需建立连接，所以速度快
				5.udp通讯不分服务器与客户端，之区分 发送端 和 接收端

				如：对讲机  QQ 游戏...

		TCP协议：(特点)
				面向连接，有特定通道
				在连接中传输大量数据
				通过三次握手机制，可靠协议
				通信前必须建立连接，效率稍低
				
				如：打电话 传输文件 电影  浏览器 服务器...




java中网络通讯也称  Socket 通讯，要求两台机器都需安装
（sou ke）  插座





udp协议下的Socket：
		DatagramSocket(udp插座服务)
		DatagramPacket(数据包类)
		DatagramPacket(buf,buf.lenth,address,port)
			buf:发送的内容
			length:发送数据内容的大小
			address:发送目的的IP对象
			port:端口号


发送端的使用步骤：
		1.建立UDP的服务器
		2.准备数据，把数据封装到数据包中发送，发送端的数据包要带上 IP地址、端口号
		3.调用UDP的服务，发送数据
		4.关闭数据



接收端的使用步骤：
		1.建立UDP的服务器
		2.准备空的数据包  接收
		3.调用UDP的服务接收数据
		4.关闭资源



每个网络程序都有自己特定格式数据（加密），如果不符合特定的格式 会当成垃圾文件处理

	如：飞Q接收的格式
				version:time:sender:ip:flag:content ;
				版本号：时间：发送人：IP：发送标识符（32）；正真的内容;
											32:是聊天
			
在UDP协议中，有一个IP地址 是广播地址 （同一个网络断）
	192.168.15.255




---------------'发送方 端口
					getBytes()	将字符串转换成字节数组
					senf()		发送数据包

public class Demo{			
	public static void main(String[] args) throws IOException  {
		//建立UDP的服务		date 归 soket
		DatagramSocket datagramSocket = new DatagramSocket();
		//准备数据，把数据封装到数据包中
		String data = "一个udp的例子...";
		//创建了一个数据包			paket
		DatagramPacket packet = new DatagramPacket(data.getBytes(),data.getBytes().length,InetAddress.getLocalHost(),8080 );     
		//调用UDP服务 发送数据包
		datagramSocket.send(packet);
		//关闭资源 --- 实际 释放占用的端口号
		datagramSocket.close();
	}
}

-------------'接收方 端口

	getLength()	获取数据包存储了几个字节 
	 receive()	阻塞型方法，没有接受到数据包会一直等待

public class Demo1 {
	public static void main(String[] args)throws IOException {
		//建立UDP服务,并要监听一个端口。                             监听8080
		DatagramSocket socket = new DatagramSocket(8080);
		byte[] buf = new byte[1024];
		//准备空的数据包 用于存储数据			需要传入一个字节数组
		DatagramPacket packet = new DatagramPacket(buf,buf.length);
		//调用udp服务接收数据
		socket.receive(packet);//实际存储到了	自己的byte数组中
	
		System.out.println("接收数据"+ new String(buf,0,packet.getLength()));//存储实际大小只有 packet 知道 
		//关闭资源
		socket.close();
	}
}



可以结合 eclipse 和 cmd 窗口  
			先运行 接受端口   
			
			cmd 运行  ：cd 进入到bin目录 后  'java  包名.类名' 即可运行
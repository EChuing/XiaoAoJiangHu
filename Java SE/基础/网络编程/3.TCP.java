TCP通讯协议特点：
	1.基于IO流进行的数据传输， 面向连接
	2.进行数据传输的时候是没有大小限制
	3.tcp面向连接，通过三次握手机制 保证数据的完整性，可靠协议
	4.面向所连接，以通讯慢
	5.区分客户端与服务端


三次握手：通讯前 会互相检查是否联通


TCP写一下的Socket
	Socket(客户端)			客户端一旦启动就要与服务端进行连接
	ServerSocket(服务端)
	
步骤：
	1.建立tcp服务
	2.获取到对应的流对象
	
	
服务端：
	ServerSocket使用步骤：
	（se wue  soke）		1.建立tcp服务端的服务
						2.接收客户端的连接  产生一个Socket	
						3.获取对应的流对象或者写出数据
						4.关闭资源

accept()  阻塞的方法 		没有客户端连接上 会一直等待

异常：	java.net.BindException:  端口被占用


//客户端
class	Demo  {
	public static void main(String[] args) throws IOException {
		//建立tcp客户端
		Socket socket = new Socket(InetAddress.getLocalHost(),9090); 
		//获取到Socket的流对象
		OutputStream outputStream = socket.getOutputStream();    
		//利用输出流对象把数据写出  注意后面是 .getBytes（）
		outputStream.write("服务器你好".getBytes());  
				
		//------为了友好回应----------
			//获取客户端会送的数据
			InputStream inputStream = socket.getInputStream();
			byte[] buf = new byte[1024];
			int length = inputStream.read(buf);
			System.out.println("客户端接收到的数据：");
		//------------------------------

		//关闭资源
		socket.close();
	
	}
}
---------------------------------------


//服务端
class	Demo{
	public static void main(String[] args) throws IOException {
		//建立tcp服务端
		ServerSocket serverSocket = new ServerSocket(9090);
		//获取输出流对象，读取客户端 发送的消息 -> 行不通 需要Socket 的方法
		//所以，接收客户端的连接
		Socket socket = serverSocket.accept(); // 接收Socket 消息，调用Socket的输入流方法
		//获取输入流对象，读取客户端发送的内容
		InputStream inputStream = socket.getInputStream();
		byte[] buf = new byte[1024];
		int length = 0;
		length = inputStream.read(buf);
		System.out.println("服务器接收："+new String(buf,0,length));
		

		//------为了友好回应----------
			//获取socket输出流对象
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("客户端你好啊！！！！".getBytes());
											   //把字符串转化成数组		
		//------------------------------
			
		
		//关闭资源
		serverSocket.close();
	}
}
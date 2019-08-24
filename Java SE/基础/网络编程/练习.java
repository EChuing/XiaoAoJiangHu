
--------------UDP------------------------------------

'发送方 端口
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

'接收方 端口

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

-------------------------TCP---------------------------------

 需求： 客户端与服务端一问一答聊天。
 
 
 1.如果使用BuffrerdReader的readline方法一定要加上\r\n才把数据写出。
 2.使用字符流一定要调用flush方法数据才会写出。
 
			'客户端
					建立TCP的客户端
					获取socket的输出流对象
					读取数据
					关闭资源
			
			'服务端
					建立TCP分服务器
					接收客户端
					利用客户端的socket获取输入流对象
					读取客户端的数据
					关闭资源
 

-'客户端
public class Demo {

	public static void main(String[] args) throws IOException {
		//建立tcp的客户端服务
		Socket socket = new Socket(InetAddress.getLocalHost(),9090);
		//获取socket的输出流对象。			转换成行输出的字符流
		OutputStreamWriter socketOut =
			new OutputStreamWriter(socket.getOutputStream());
		
		//-------------------
			//获取socket的输入流对象									
			BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//-------------------
			
		//获取键盘的输入流对象，读取数据		转换成行输入的字符流	
		BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		//不断的读取键盘录入的数据，然后把数据写出   readLine()本身不包含/r/n 否则服务器那边读取不了  不是很懂！
		while((line = keyReader.readLine())!=null){
			socketOut.write(line+"\r\n");
			//刷新       读取的数据会先存到 缓冲数组中（内存）    刷新至硬盘
			socketOut.flush();
			
				//读取服务端回送的数据
				line = socketReader.readLine();
				System.out.println("服务端回送的数据是："+line);
		}
		//关闭资源
		socket.close();
	}
	
	
}


'服务端
public class Demo1 {

	public static void main(String[] args) throws IOException {
		//建立tcp的服务端								建立端口？
		ServerSocket serverSocket = new ServerSocket(9090);
		//接受客户端的连接，产生一个SOcket
		Socket socket = serverSocket.accept(); //阻塞作用
		//获取到Socket的输入流对象					转换						行输入			
		BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		//-------------
			//获取到Socket输出流对象
			OutputStreamWriter socketOut =  new OutputStreamWriter(socket.getOutputStream());
			//获取键盘的输入流对象
			BufferedReader keyReader = new BufferedReader(new InputStreamReader(System.in));
		//-------------	
		
		//读取客户端的数据
		String line = null;			//客户端出如果也是 readLine（） 会冲突
		while((line = socketReader.readLine())!=null){
			System.out.println("服务端接收到的数据："+ line);
			
				System.out.println("请输入回送给客户端的数据：");
				line = keyReader.readLine();
				socketOut.write(line+"\r\n");
				socketOut.flush();
		}
		
		//关闭资源
		serverSocket.close();
	}
	
}




----------------模拟Tomcat服务器---------------


public class TomcatDemo extends Thread {
	
	Socket socket;
	
	public TomcatDemo(Socket socket){
		this.socket = socket;
	}
	
	
	public void run() {
		try {
			//获取socket的输出流对象
			OutputStream outputStream = socket.getOutputStream();
			//把数据写到浏览器上
			outputStream.write("<html><head><title>aaa</title></head><body>你好啊浏览器</body></html>".getBytes());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) throws IOException {
		//建立tcp的服务端
		ServerSocket serverSocket = new ServerSocket(9090);
		//不断的接受客户端的连接
		while(true){
			Socket socket = serverSocket.accept();
			new TomcatDemo(socket).start();
		}
	}
	
}

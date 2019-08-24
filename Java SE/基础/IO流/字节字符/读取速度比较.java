import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;




File类： 用于描述一个文件夹 或 文件的
	
		通过File对象我们可以读取 文件夹 或 文件的属性， 入股我们需要读取
		文件的	内容数据	，那么我们需要使用IO流技术。
		
IO流技术：

IO流分类：
	
	按数据的流向划分：（判断依据：以当前程序问参照物，看似流入还是流出）
		
				输入流
				
				输出流
				
	按处理的单元划分：
			
				字节流：读取的都是文件中二进制数据，读取二进制数据不会经过任何处理
						
						
				字符流：读取的都是文件中二进制数据，会对二进制数据转换为我们 能识别的字符
						将二进制转换为字符	字符为单位
				字符流 = 字节流 + 解码	
		
	
字节流	

	（abe sique）
有abstract 都是抽象类
--------------------------------------------------------------------
输入字节流
		
		|InputStream类  (inpe siqun)  所有字节流的基类
			|FileInputStream （fai e inpe siqun）
			
			
			
			'读取文件 通常用第四种 最快'
			
使用FileInputStream读取文件数据的步骤:
			1.找到目标文件
			2.搭建数据输入的通道
			3.读取文件的数据 
			4.关闭资源 
				
			
read()方法返回读入缓冲区的字节数，如果数据读完了就返回-1			
（rui de）			
	
	不同的软件都是经过加密的   解析方式都不同

-------------------------------------------------------------
public class Demo1{
	
	public static void main(String[] args)throws IOException {
		readTest1();
	}
	'读取最快'
	//法四 使用缓冲数组 配合 循环一起读取
	public static void readTest4() throws IOException{
		//找到目标文件
		File file = new File("a.txt");
		//建立数据通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲数组
		int length = 0;//保存每次读取的字节数
		byte[] buf = new byte[1024];
		while((length = fileInputStream.read(buf))!=-1); //read()  读到文件末尾会返回 -1 表示
			System.out.println(new String(buf,0,length));// [0,length]  读取的方式是 覆盖
		// read 一开始没有值 ，且将读取到的字符 存入buf中，当读入到末尾时 read 就会返回-1，使得length = 1， 就结束循环
			
			
		//关闭资源
		fileInputStream.close();
	}
	
	//法三：使用缓冲数组 读取     缺点： 无法读取完整的文件  数据。
	public static void readTest3() throws IOException{
		//找到目标文件
		File file = new File("a.txt");
		//建立数据通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲  字节数组， 读取文件的数据
		byte[] buf = new byte[3];	// 类似以购物车
		
		//读取的数据传入 字节数组中 ，    返回值是  传入字节数组中的个数 
		int length = fileInputStream.read(buf);	
		
		//使用字节数组构建字符串
		String content = new String(buf);
		System.out.println("内容"+content);
		//关闭资源
		fileInputStream.close();
	
	}
	
	
	//法二：使用循环读取文件的数据   缺陷：读取得太慢
	public static void readTest2() throws IOException{
	//找到目标文件
	File file = new File("a.txt");
	//建立
	FileInputStream fileInputStream = new FileInputStream(file);
	//读取
	int content = 0;// 声明该变量用于存储读取到的资源
	while((content = fileInputStream.read())!=-1){
	//				read（）读取到数据位空时 会返回 -1  
	System.out.println((char)content);  //打印读到的文件
	}
	//关闭
	fileInputStream.close();
	}
	
	
	
	
//	读取方式一：    缺陷：无法读取完整一个文件		throws防止 N1 处存储时出错
	public static void readTest1() throws IOException{
	//找到目标文件
	File file = new File("a.txt");
	//建立数据的输入通道
	FileInputStream fileInputStream = new FileInputStream(file);
	//读取文件中的数据
	int content =	fileInputStream.read(); // read() 每次只读取一个字节数据       N1
	System.out.println("读取到的内容"+content);
	//关闭资源  （使用完后，释放资源的作用）
	fileInputStream.close();
	}
}
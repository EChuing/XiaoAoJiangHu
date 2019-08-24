
import java.io.*;


  
  字节流：  文件中的二进制数据，不会转换成'中文'字符
  
 字符流：将读取到的二进制数据 进行对应的 编码和解码     字符流 = 字节流 + 编码（解码） 
  

输入字符流：
		（V de）
-------|Reader 	输入字符流的基类 	抽象类
			|FileReader  读取文件的输入字符流
			|BufferedReader	缓冲输入字符流。       提高读取文件	  字符的速率和扩展FileReader的功能    
			 							其实该类内部也是维护了 字符数组



缓冲流：都不具备读取的能力

//读取记事本（中英混合文本） 不用担心 会乱码
public class Demo1{
	public static void main(String[] args) throws IOException {
		readTest1();
		readTest2();

	}


	//使用缓冲字符数组读取文件
	public static void readTest2() throws IOException {
		//找到目标文件
		File file = new File(" ");
		//建立数据的输入通道
		FileReader fileReader = new FileReader(file);
		char[] buf = new char[1024];
		int length = 0;
		while((length = fileReader.read(buf))!=-1){ // 每次读取一个数据  效率低    
			System.out.println(new String(buf,0,length));
		}
		//关闭资源
		fileReader.close();
	}
	
	
	
	//普通
	public static void readTest1() throws IOException {
		//找到目标文件
		File file = new File(" ");
		//建立数据的输入通道
		FileReader fileReader = new FileReader(file);
		int content = 0;
		while((content = fileReader.read())!=-1){ // 每次读取一个数据  效率低    
			System.out.println((char)content);
		}
		//关闭资源
		fileReader.close();
	}
}

--------------------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Demo{
	
	public static void main(String[] args) throws IOException {
		readTest1();
	}
	public static void readTest1() throws IOException{
		//找到目标文件
		File file = new File(" "); 
		//建立数据输入通道
		FileReader fileReader = new FileReader(file);
		//建立	缓冲输入字符流
		BufferedReader	bufferedReader = new BufferedReader(fileReader);
		//读取数据
			//一个字符的读取
			int content = bufferedReader.read();
			System.out.println((char)content);
			//使用扩展功能        一次读取一行，读到末尾返回 null，不是 -1
			String line = null;//        （rui lai） 
			while((line = bufferedReader.readLine())!=null){
				System.out.println(line);
			}
		//关闭资源
		bufferedReader.close();
	}
	
	
}

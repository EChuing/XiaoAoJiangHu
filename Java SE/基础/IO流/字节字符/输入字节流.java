
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

 
读取文件 用缓冲数组     效率更高       
     
     
sun 提供了一个 缓冲输入字节流对象   提高效率
     



------------|InputStream	输入字节流的基类
----------------|FileInputStream			读取文件数据的输入字节流
----------------|BufferedInputStream		缓冲输入字节流  缓冲输入字节流   提高效率  
					

特有方法：

read()： 方法返回读入缓冲区的字节数，如果数据读完了就返回-1   int 类型 每次一个数据





缓冲字节流类   内部 维护了一个人 8 KB的 字节数组

	'注意：凡是缓冲流 都不具备文件读写的能力'
	
	
	bufferedInputStream  内部维护了一个 8 KB的字节数组           数组的内容是存在 内存中
	相当于   帮你省去自己写的：  byte[] buf = new byte[1024*8]; 
	 且 bufferedInputStream 每次都要判断 是否 读取完毕（费时）。					
	 					
	 建议： 
		 还是用自己写的好   但是按效率更高的话    
		 还是用 bufferedInputStream  
		 因为他的数据 是存在内存中的  
		
	
	
									读取速度：   内存的数据 》 硬盘的数据
使用 BufferedInputStream 步骤：
     	1.找到目标文件
     	2.建立数据的输入通道
     	3.建立缓冲输入字节流
     	4.关闭资源
     

public class Demo {
	
	public static void main(String[] args) throws IOException{
		readTset();
	}
	
	public static void readTset() throws IOException {
		//找到目标
		File file = new File("路径");
		//建立数据的输入通道
		FileInputStream fileInputStream = new FileInputStream(file);
		//建立缓冲输入字节流
		//BufferedInputStream 本身不具备读取文件的能力 ， 所有需要借助 FileInputStream 来读取文件数据
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		//读取文件数据
		int content = 0;
		//(kantan te)
		//bufferedInputStream       read（） 获取缓存内容  值为空时 返回-1   每次只读取一个数据    用做循环的条件 控制输出
		while(( bufferedInputStream.read())!= -1){  // 将读取到的字符 存进 contion 读到末尾是 会返回 -1
			System.out.println((char)content); //存储 转换成字符数据
		}
		//关闭资源
		bufferedInputStream.close();  // 实际是关闭 fileInputStream.close();
		
		
	
	
	
	
	}
}
	
	

	

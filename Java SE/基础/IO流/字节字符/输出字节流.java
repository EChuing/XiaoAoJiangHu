import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



			aopu siqun
------------|OutputStream	输出字节流的基类
				（fai e aopu siqun）
----------------|FileOutputStream		向文件输出数据的输出字节流
----------------|BufferedOutputStream  	缓冲输出字节流   内部也是维护了一个8KB的字节数组  
				（bafe  inpu siqun） 						   提高读取文件的效率  	
 			  
（外 de）   '输出字符流： Writer  多了个r'
write 方法： 
			默认是向内部数组中存储（内存），
			只有在
			调用 flush （fe laxu）
			或者 close  （kelou si）
			或者 8KB字节数组存满时
			才会将内存的数据真正 
			存入硬盘中



使用BufferedOutputStream 的 步骤
		1.找到目标文件
		2.建立数据的输出通道
		3.建立数据缓冲输出字节流对象
		4.把数据写入
		5.把缓冲数组中的数据写到硬盘上

		
BufferedOutputStream 要注意的细节
	1.使用 BufferedOutStream 写入数据的时候，  
	write方法是 先把数据写入内部维护的字节数组中，
	如果需要把数据真正的写入硬盘上，
	需要调用flush方法 或者 close 方法  或者  字节数组已经填满的时候
	
		*/			
	
public class Demo{
	public static void main(String[] args) throws IOException {
		//找到目标文件
		File file = new File("路径");
		//建立数据的输出通道1
		FileOutputStream  fileOutputStream  = new FileOutputStream(file);
		//建立数据缓冲输出字节流对象
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		//把数据写入			(bai te)
		bufferedOutputStream.write("Hello world". getBytes());   //getBytes  字符转换成 字节 的方法
		//把缓冲数组中的数据写到硬盘上	
		bufferedOutputStream.flush();//(fela  xu)
		bufferedOutputStream.close();// 都可以    ( ke lous)	
	}	
		
}

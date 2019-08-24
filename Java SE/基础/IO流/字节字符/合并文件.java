package cn.itcast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;


SequenceInputStream(序列流)
 

需求：把a.txt与b.txt 文件的内容合并。


public class Demo {
	
	public static void main(String[] args) throws IOException {
		merge3();
	}

//方法一：将读取 a b 的内容存到数组中 ，转交给c 。
	public static void merge1() throws IOException{
		//找到目标文件
		File inFile1 = new File("F:\\a.txt");
		File inFile2 = new File("F:\\b.txt");
		File outFile = new File("F:\\c.txt");
		//建立数据的输入输出通道
		FileOutputStream fileOutputStream = new FileOutputStream(outFile);
		FileInputStream fileInputStream1 = new FileInputStream(inFile1);
		FileInputStream fileInputStream2 = new FileInputStream(inFile2);
		
		//把输入流存储到集合中，然后再从集合中读取
		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		list.add(fileInputStream1);
		list.add(fileInputStream2);
		
		//准备一个缓冲数组
		byte[] buf = new byte[1024];
		int length = 0 ; 
		
		for(int i = 0 ; i< list.size() ; i++){
			FileInputStream fileInputStream = list.get(i);
			while((length = fileInputStream.read(buf))!=-1){
				fileOutputStream.write(buf,0,length);
			}
			//关闭资源
			fileInputStream.close();
		}
		fileOutputStream.close();
		
	}
	
	
	
	
	
//法2
	// xi款  ce      xi款 ten pasi jun    顺序输入流
//	使用SequenceInputStream合并文件。
	public static void merge2() throws IOException{
		//找到目标文件
		File inFile1 = new File("F:\\a.txt");
		File inFile2 = new File("F:\\b.txt");
		File outFile = new File("F:\\c.txt");
		//建立数据的输入输出通道
		FileOutputStream fileOutputStream = new FileOutputStream(outFile);
		
		FileInputStream fileInputStream1 = new FileInputStream(inFile1);
		FileInputStream fileInputStream2 = new FileInputStream(inFile2);
		//建立序列流对象												传入要合并的文件   先读取1 后 读取2
		SequenceInputStream inputStream = new SequenceInputStream(fileInputStream1,fileInputStream2);
		byte[] buf = new byte[1024];
		int length = 0 ; 
		
		while((length = inputStream.read(buf))!=-1){
			fileOutputStream.write(buf,0,length);
		}
		//关闭资源
		inputStream.close();// 关闭合并的通道  相当于 关闭inFile1 和 inFile2的通道
		fileOutputStream.close();
	}

//法3
//把三个文件合并成一个文件
	public static void merge3() throws IOException{
		//找到目标文件
		File file1 = new File("F:\\a.txt");
		File file2 = new File("F:\\b.txt");
		File file3 = new File("F:\\c.txt");
		File file4 = new File("F:\\d.txt");
		
		
		//建立对应 的输入输出流对象
		FileOutputStream fileOutputStream = new FileOutputStream(file4);
		FileInputStream fileInputStream1 = new FileInputStream(file1);
		FileInputStream fileInputStream2 = new FileInputStream(file2);
		FileInputStream fileInputStream3 = new FileInputStream(file3);

'--->'	//创建序列流对象
		Vector<FileInputStream> vector = new Vector<FileInputStream>();
		vector.add(fileInputStream1);
		vector.add(fileInputStream2);
		vector.add(fileInputStream3);
		Enumeration<FileInputStream> e = vector.elements();  // 之前有学   不会用

		SequenceInputStream sequenceInputStream = new SequenceInputStream(e);
		
		//读取文件数据
		byte[] buf = new byte[1024];
		int length = 0; 
		
		while((length = sequenceInputStream.read(buf))!=-1){
			fileOutputStream.write(buf,0,length);
		}
		//关闭资源
		sequenceInputStream.close();
		fileOutputStream.close();
	}
	
}
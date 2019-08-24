
使用 '缓冲字输入字节流' 拷贝一个人图像

import java.io.*;

public class Demo1{
	
	public static void main(String[] args) throws IOException {
		//找到目标文件
		File inFile = new File("拷贝路径");
		File outfile = new File("新路径");
		//建立数据的输出通道1
		FileInputStream fileInputStream = new FileInputStream(inFile);
		FileOutputStream  fileOutputStream  = new FileOutputStream(outfile);
		//建立数据缓冲输出字节流对象
		BufferedInputStream  bufferedInputStream = new BufferedInputStream(fileInputStream);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		//把数据写入
		int content = 0;
		while((content = bufferedInputStream.read())!=-1){
		//		bufferedOutputStream.flush();   数据是连续读取 读满时会自动存进硬盘   所以不用 flush
		}
		//关闭资源
		bufferedOutputStream.close();
		bufferedInputStream.close();
		
	}

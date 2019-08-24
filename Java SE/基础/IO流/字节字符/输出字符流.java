import java.io.*;


输出字符流:	（luai te）			抽象类都不可以直接使用
----------|Writer	输出字符流的基类	抽象类
-------------|FileWriter	向文件输出 数据的输出字节流
-------------|BufferedWriter	缓冲输出字符流			
								提高效率 拓展FileWriter 
								的 newLine() 回车 			

输出字节流 有个 write 的方法
输出字符流		Writer 多了个r	

FileWriter 步骤:
	1.找到目标
	2.建立数据输出通道
	3.写出数据
	4.关闭资源
	
	注意：
		FileWriter 写数据时, FileWriter 的（爷爷）Writer 
		内部维护了一个1024的字节数组，需要调用 flush 或者 close 或者 内部数组填满时 
		才会真正写到硬盘上
		
		使用FileWriter的时候 ,目标文件存在，会先清空数据，再重新写入，
		如果需要追加数据 需要用 nwe FileWriter( File , boolean )  
		的构造方法 第二个参数为 true

（fai e 歪de.外 的）
fileWriter.write


public class Demo1{
	public static void main(String[] args) throws IOException {
		writeTest1();
		writeTest2();

	}
	//普通
	public static void writeTest1() throws IOException {
		//找到目标文件
		File file = new File("文件");
		//建立数据的输出通道
		FileWriter fileWriter = new FileWriter(file);// 目标文件存在 会清空，重新写入
		//FileWriter fileWriter = new FileWriter(file,true);// 这样可以在原数据 追加数据写入
		//准备数据，把数据写出
		String data = "今天天气不错";
		fileWriter.write(data);
		//刷新字节流
		fileWriter.flush(); 使内存的数据存到硬盘中
		//关闭资源
		fileWriter.close();
		
	
	//缓冲输出字符流  增加 newLine 功能
	public static void writeTest2() throws IOException {
		//找到目标文件
		File file = new File("文件");
		//建立数据的输出通道
		FileWriter fileWriter = new FileWriter(file,true);// 目标文件存在 会清空，重新写入
		//建立缓冲数据输出通道
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//写出数据
		bufferedWriter.newLine(); // 换行， 实际是向文件输出/n/r（回车）		
		bufferedWriter.write("\n\r");//  和上面的功能一样
		bufferedWriter.write("大家好！！");
		//关闭
		bufferedWriter.close();//或者 flush
		
	}
}


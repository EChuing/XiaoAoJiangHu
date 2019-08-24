
IO流  (Input Output)   (inpo  onpo)  输入 输出流


IO技术主要的作用：是解决设备与设备之间的传输问题
				硬盘---读取到-->内存      
				内存的数据----->硬盘上
				键盘的数据----->内存中
				
				
IO技术的引用场景：
		导出报表，上传大头照，下载，解析xml文件
	
数据保存到硬盘上，该数据就可以做到永久性保存。 
数据一般是以文件的形式保存到硬盘上


sun使用了一个File类 描述了文件 或 文件夹的


File  (fai e)类

File类可以描述一个文件 或 文件夹年

File类的构造方法：
	
	File(String pathname) 指定 文件 或 文件夹 的路径 创建一个File 文件 

	File(File parent, String child) 根据 paren 抽象路径 和 child 路径名 字符串创建一个 新的 File 实例
			(pen te)     	(chai)			路径和路径名分开了 
	File(String parent,String child)
	

目录分隔符：
		在windows机器上的 目录分隔符 ：	\ 
		在Linx机器 的目录分割符：			/

但是 windows 上，    /也可以  只用写一个 


public class Demo{
	public static void main(String[] args) {
		
		//File file = new File("F:\\Tufo\\美女.jpg");
		
		File parentFile = new File("F:\\Tufo\\");
		File file = new File("F:\\","美女.jpg");
		
		System.out.println("存在么？" + file.exists());//exists（）  （Ese ti） 存在返回true   
		System.out.println("目录分隔符："+File.separator);

	
	
	
	
	}
	
}
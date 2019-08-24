拷贝图片   +   异常处理


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
	
	public static void main(String[] args) throws IOException {
		readTest();		
	}
	
	
	public static void readTest() throws FileNotFoundException, IOException {
		//找到目标
		File inFile = new File("原路径");
		File destFile = new File("新路径");
		//建立数据的数据的输入输出通道
		FileInputStream fileInputStream = new FileInputStream(inFile);
		FileOutputStream fileOutputStream = new FileOutputStream(destFile);
		//建立缓冲数据， 边度边写  （复制）
		byte[] buf = new byte[1024];
		int length = 0;
		while((length = fileInputStream.read(buf))!=-1){
			//fileOutputStream.write(buf);//这样会偏大
			fileOutputStream.write(buf,0,length);//读多少 复制多少
		}
		//关闭资源
		fileInputStream.close();
		fileOutputStream.close();
	}
}


read(x)	输入流  的  读取数据  将读到的数据存到 x 中   
write(x)  输出流 的  写出数据  根据X的内容写出数据   注意长度


----------------------------------------------------------------------

'拷贝图片异常处理'

public static void copyImage(){
			//这两个要声明到外面  否则不可见
			FileInputStream fileInputStream = null;
			FileOutputStream fileOutputStream = null;
			//(踹)
		try{
			//找到目标
			File inFile = new File("原路径");
			File destFile = new File("新路径");
			//建立数据的数据的输入输出通道
			fileInputStream = new FileInputStream(inFile);
			fileOutputStream = new FileOutputStream(destFile);
			//建立缓冲数组， 边度边写  （复制）
			byte[] buf = new byte[1024];  
			int length = 0;	   "read： 把读到的数据存到 buf 中"
			while((length = fileInputStream.read(buf))!=-1){
				fileOutputStream.write(buf,0,length);//读多少 复制多少，指定buf数组 从0中开始 length个字节写入缓冲流
			}
		//  IO处理异常代码  
		//(ka qu)     
		}catch(IOException e){ 
			System.out.println("拷贝图片出错...");
			throw new RuntimeException(e);// 将抛出的异常 包裹一层（糖衣），方便调用者处理
						// (润tai Esha shen)
		}finally{
			//关闭资源
			try {
				if(fileOutputStream != null){ // 防止没有读到文件就 报错
					fileOutputStream.close();
					System.out.println("关闭输出了对象 成功....");
				}
			} catch (Exception e) {
					System.out.println("关闭输出了对象 失败....");
					throw new RuntimeException(e);
			}finally{
					if(fileInputStream != null){
					try {
					fileInputStream.close();
					System.out.println("关闭输入了对象 成功....");
					} catch (Exception e) {
					System.out.println("关闭输入了对象 失败....");
					throw new RuntimeException(e);
					}
					}
					}
			}
		}


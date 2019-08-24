
finally 块(fai ne li)
		使用前必须存在try块
		任何时候都会执行 只有jvm退出时会停止执行
		常用于资源释放的工作，可以保证资源在任何时候都可以被释放

三种组合：
	1.用于有异常要处理，但没有资源的释放
			
		try{
			可能发生异常的代码
		}catch （捕获的异常类型 变量名）{
				处理异常		
		}
		
	2.有异常要处理，要资源释放

		try{
			可能发生异常的代码
		}catch （捕获的异常类型 变量名）{
				处理异常		
		}finally{
				释放资源的代码；		
		}

	3.内部抛出的是运行时异常，需要资源释放  （ 少用 ）

		try{
			可能发生异常的代码
		}finally{
				释放资源的代码；

		编译时异常就一定要处理 运行时异常可以不用处理


--------------------------finally 块  使用-----------------------------------

class Love001 
{
	public static void main(String[] args) 
	{
		div(4,0);
	}
	public static void div(int a,int b){
		try{
			if(b==0){
				System.exit(0);//退出jvm
			}	
			int c = a/b;
			System.out.println("c="+c);
		
		}catch(Exception e){
			System.out.println("出现了除数为0的异常...");
			throw e;	
		}finally{
			System.out.println("finally块运行了...");
		}
	}

}
--------------------- finally 块释放资源 -------------------


import java.io.*;
class Love001
{	
	public static void main(String[] args)
	{	
		FileReader fileReader = null;
		try
		{	//找目标文件
			File file = new File("f://a.txt");				// 文件在哪里还不知道
			//建立程序与文件的数据通道
			fileReader = new FileReader(file);
			//读取文件
			char[] buf = new char[1024];
			int length = 0;
			length = fileReader.read(buf);
			System.out.println("读取到的内容："+ new String(buf,0,length));
		catch(IOException e){
			System.out.println("读取资源文件失败");
		}finally
		 {	
			try{
				//关闭资源
				fileReader.close();
				System.out.println("释放资源文件成功....");
			catch{IOException e}{
				System.out.println("释放资源文件成功....");
			}
		 }
	}
}
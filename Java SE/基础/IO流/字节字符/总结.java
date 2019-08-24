

输入字节流：
------------|InputStream	输入字节流的基类
----------------|FileInputStream			读取文件数据的输入字节流
----------------|BufferedInputStream		缓冲输入字节流  缓冲输入字节流   提高效率  


输出字节流：
------------|OutputStream	输出字节流的基类
				（fai e Opu siqun）
----------------|FileOutputStream		向文件输出数据的输出字节流
----------------|BufferedOutputStream  	缓冲输入字节流   内部也是维护了一个8KB的字节数组  
				（bafe  inpu siqun） 						   提高读取文件的效率  	
 			 
字符流 = 字节流 + 编码（解码）
		  

输入字符流：
（rui de）
-------|Reader 	输入字符流的基类 	抽象类
------------|FileReader  读取文件的输入字符流
------------|BufferedReader	缓冲输入字符流。       提高读取文件	  字符的速率和扩展FileReader的功能    
		


输出字符流:	（luai te）			抽象类都不可以直接使用
----------|Writer	输出字符流的基类	抽象类
-------------|FileWriter	向文件输出 数据的输出字节流
-------------|BufferedWriter	缓冲输出字符流			
								提高效率 拓展FileWriter 
								的 newLine() 回车 			





缓冲字节流 内部都维护了一个 8 KB 的 字节数组

编码：字符->数字 
解码：数字->字符（中文）
记事本具有解码的功能


字节流不可以写直接写中文：
							但是借助getBytes 对字符串进行了编码

getBytes（）   可以把字符串转换成	字节数组

字节流不可字直接读取中文：
							会乱码
码表
ANSI(美国)
GBK（中国） ：一个中文 2 个字节
UTF-8 （万国表）： 一个中文 3 个 字节  
			GBK - UTF-8 转换就会乱码

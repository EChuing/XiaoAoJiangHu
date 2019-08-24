
包:
java中的包 相当于windows文件夹

	package （pa ke gu）  在什么文件夹
	import （in po）		导包语句
	


	作用
			1.解决类名重复、冲突
			2.便于软件版本发布


  定义格式：
	package  包名;

	
	报名规范：包名全部小写

	注意：	1.package 语句必须位于java文件中第一个语句.
			2.如果一个类加上包名语句，那么该类的完整的类名就是： 包名.类名
			3.一个java文件只能有一个包语句

	
	javac -d 指定文件夹的存放路径 java源文件
	
	javac -d . xxx.java -->  在源文件下创建 相应文件夹 并生成编译文件 .的作用

----------------------包类 与 类 的访问-----------------------------------
sun 提供
导包语句 import
		作用：
			1.简化书写   （误区： 把一个类导入到内存中）


		格式：
			import 包名.类名;  （导入xxx包中某各类）
			import 包名.*;    写通配符 会混乱  
			import aa.*; 是不会作用于aa包下的子包 

		注意：
			1.一个java文件中可以出现多个导包语句。
			2." * "是 导包的通配符 可以匹配任何的类名。


-------------------------------------------------------------
package aa; 
import aa.*;
class Love002  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}

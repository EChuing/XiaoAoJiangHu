

创建：
		createNewFile()	在指定位置创建一个空文件，
						创建成功就返回true
						创建失败（文件夹已经存在），返回false
		

		mkdir()			一层目录创建，如果上级目录不存在就抛异常。
		mkdirs()		多次目录创建，不存在的会自动创建
						
		
		renameTo(File dest)	重命名文件或文件夹，也可以操作非空的文件夹，文件不同时相当于文件的剪切,剪切时候不能操作非空的文件夹。
		（rui nanto）		移动/重命名成功则返回true，失败则返回false。



删除：
		delete()  （di lite）	删除文件或一个空文件夹，如果是文件夹且不为空，则不能删除，成功返回true，失败返回false。
		
		deleteOnExit()			在虚拟机终止时，请求删除此抽象路径名表示的文件或目录，保证程序异常时创建的临时文件也可以被删除
								一般用于删除临时文件
		
		注意：一个是	立刻删除
		  	  一个是	jvm结束时 再删除   （酷狗临时文件，QQ聊天内容）	
		


判断：
		exists()		文件或文件夹是否存在。
		isFile()		是否是一个文件，如果不存在，则始终为false。
		isDirectory()	是否是一个目录，如果不存在，则始终为false。
		isHidden()		是否是一个隐藏的文件或是否是隐藏的目录。
		isAbsolute()	测试此抽象路径名是否为绝对路径名。

获取：（有些很假）
	getName()		获取文件或文件夹的名称，不包含上级路径
	length()		获取文件的大小（字节数），如果文件不存在则返回0L，如果是文件夹也返回0L。
	getParent()		返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回null。
	lastModified()	获取最后一次被修改的时间。
	

	getPath()			相对路径，目录要指定
	getAbsolutePath()	绝对路径，与文件是否存在没关系




------------------------------------------------------------

import java.io.File;
import java.io.IOException;

//创建
public class Demo1 {
	
	public static void main(String[] args) throws IOException {
		File f = new File("F:\\aa");
		System.out.println("创建文件夹"); 
		f.mkdirs()
		
		

}

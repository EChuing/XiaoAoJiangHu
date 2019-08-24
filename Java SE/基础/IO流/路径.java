
 路径的问题：

绝对路径: 该文件在硬盘上的 完整路径。绝对路径一般都是以盘符开头的。
相对路径： 相对路径就是 资源文件夹  相对于当前程序 所在的路径
	
	. 	当前路径
	..	上一路径

注意：
	如果程序当前锁在的路径 与 资源文件不是在用一个盘 下面， 是没有办法写相对路径
 */

public class Demo{
	
	public static void main(String[] args) {
		File file = new File(".");
		System.out.println("当前路径："+file.getAbsolutePath());
	}	//									输出file的当前路径						
}
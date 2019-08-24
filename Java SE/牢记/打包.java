
打 jar 包：需要使用到jdk的开发工具 （ jar.exe ） 

jar的用法

使用格式：
		jar cvf jar文件的名字 class文件或者是文件夹


		注意：
				1.一个程序打完jar之后 必须要在清单文件上指定入口类  格式： Main-class: 包名.类名
				2.jar包双击运行仅对于图形化界面的程序起作用，对控制台的程序不起做用

jar文件的作用：		
				1.方便用户快速运行一个项目
				2.提供工具类给别人使用

如果使用jar包里面的类 必须要先设置 classpath 路径

jre = jvm + 核心类库

package qq;
import javax.swing.*; 
class Love002
{
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("QQ程序");
		frame.setSize(400,500);
		frame.setVisible(true);// 设置窗口可见
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


先编译出 .class 文件， 后将 .class 文件 打包成jar 包
{
}
 
F:\Tufo>javac Love002.java

F:\Tufo>javac -d . Love002.java

F:\Tufo>java qq.Love002

F:\Tufo>jar cvf qq.jar qq
已添加清单
正在添加: qq/(输入 = 0) (输出 = 0)(存储了 0%)
正在添加: qq/Love002.class(输入 = 482) (输出 = 360)(压缩了 25%)


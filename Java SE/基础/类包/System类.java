package cn.itcast;

import java.io.IOException;



System 系统类 		主要用于获取系统的属性 数据
--------------------------------------------------------
			arraycopy(Object src, int srcPos, Object dest, int destPos, int length )
				src  		源数组(数组的名字)
				srcPos 		 源数组   开始复制的位置
				dest		存放在 目标数组
				destPos 	在目标数组    开始粘贴的	起始位置
				length		在目标数组    开始粘贴的	束的位置
				
(重点)		currentTimeMillis() 	获取系统时间 （毫秒）
				
(一般)		exit(int status)		退出jvm  如果参数是0表示正常退出jvm，非0表示异常退出jvm	
			gc()			建议jvm快速启动jvm 回收垃圾
			getenv(String name)  根据环境变量的名字    获取环境变量
			getProperty(key)	
				

/*
import java.util.Arrays;
import java.util.Properties;

class Person{
	
	String name;
	
	public Person(String name){
		this.name = name;
		
	}
	
	public void finalize() throws Throwable{
		super.finalize();
		System.out.println(this.name+"被回收了..");
		
	}
	
}


public class Love3 {
	public static void main(String[] args){		
		
		int[] srcArr ={10,12,14,16,19};
		//把sreArr的数组元素拷贝到 destArr数组中
		int[] destArr = new int[4];
		System.arraycopy(srcArr, 1, destArr,0,2);
		System.out.println("目标数组的元素："+ Arrays.toString(destArr));
		
		//System.exit(0);  // 退出jvm虚拟机
		System.out.println("获取系统的时间"+System.currentTimeMillis()); //获取从1970.1.1到今天的毫秒时间
		System.out.println("环境变量"+System.getenv("path"));   //获取path的环境变量
		
		
		
		for(int i = 0;i<4; i++){
			new Person("狗娃"+i);
			System.gc(); // 建议马上启动垃圾回收器
		}
		
		
	Properties properties = System.getProperties();   //获取系统的属性
	properties.list(System.out);
	
	String value = System.getProperty("os.name");  //获取指定系统  属性
	System.out.println("当前系统："+value);
	}
}
*/


RunTime   该类  主要代表了应用程序运行环境
-------------------------------------------------------
	
		getRunTime()   返回当前引用程序的运行环境对象。
		exec(String command)	根据指定的路径执行对应的可执行文件
		freeMemory()   返回jvm 中空闲的内存量    以字节单位
		maxMemory()    返回jvm 试图使用的最大内存量
		totalMemory    返回jvm 中内存总量
		
		
		
		
		

public class Love3 {
	public static void main(String[] args) throws IOException, InterruptedException{
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("C:\\Windows\\notepad.exe");  //运行指定路径的文件
		Thread.sleep(3000);// 让当前程序停止三秒后    关闭
		process.destroy();
		
		System.out.println("jvm空闲的内存量"+runtime.freeMemory());
		System.out.println("jvm试图使用的最大内存量"+runtime.maxMemory());
		System.out.println("返回jvm内存总量"+runtime.totalMemory());
		
		
		
	}
	
	
}

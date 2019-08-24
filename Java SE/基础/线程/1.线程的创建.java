-----------'线程

进程=程序    进程负责空间的划分

问题：windows 号称多个任务的操作系统，那么Windows是同时运行对个引用程序？
  				宏观：   是的
				微观： 	不是
					
				单核cpu在一个时间只执行一个程序
				cpu快速切换动作  ，  我们感觉不到 



线程： 线程在一个进程中 负责代码的执行  就是进程中一个执行路径
	
多线程： 一个进程 执行多个线程同时执行	
			'cpu的资源抢夺'
    	
		任何一个java程序，在 jvm在运行的时候 会创建一个main线程执行  main方法中所有代码。
    
    	
    	
一个java应用程序至少执行多少分线程？
		至少有两个线程： 一个是main主线程 	负责main代码执行
					一个是垃圾回收器   	垃圾回收

多线程的好处：
		1.解决了一个进程能同时执行多个任务的问题
		2.提高资源的利用率


	      弊端：	 
		 1.增加cpu的负担
	     2.降低了一个进程中线程的执行概率
    	 3.引发线程安全
    	 4.出现死锁的现象
	           
	    
创建多线程	//自定义线程
		
		不需传入值
		方法一;			   (si vade)
			1.自定义一个类继承Thread类。
			
			2.重写Thread类的方法。	
					疑问：为何重写？ 
							每个线程都有自己的任务
							jvm创建主线程的任务代码就是        
							main方法中的所有代码
					
							而自定义线程的任务代码 就写在run方法中  
							自定义线程负责run的方法
			
			 3. main 中创建Thread的子类对象，并且调用start方法开启线程。
			 				一个线程一旦开启，呢么线程就会执行run方法中的代码， 
			 				run方法不可以直接调用， 调用就等以普通方法 而 没开启线程
			
					
		（需要传入值）			
		方法二；				(rua nebou) 可运行
			1.自定义一个类实现 Runnable 接Runnable口

			2.实现 Runnable 接口的方法，把自定义线程的任务 定义在run方法上

			3.创建 Runnable 类的对象 
			
			4.创建 Thread 类对象  并 Runnable 作为实参传递
												     		参数传递 Thread （ Runnable target , String name）
			5.调用 Thread 对象 的 start 方法  开启一个线程				Runnable的对象一个，自定义的一个

				
				问题：
					1.Runnable 实现类的对象是 线程对象么？
						答:  Runnable 实现类的对象 并不是一个线程对象, 只不过是实现类Runnable接口的方法而已
							  只有 Thread 或者是 Thread 的子类 才是线程对象。

					2.为什么要把 Thread 的实现类对象作为实参传递给Thread对象呢？ 有什么作用？
						答：	  作用就是把Runnable实现类对象的run方法作为线程的 任务代码去执行。

			当前线程： Thread.currentThread()



法一：(1)
----------------------------------------------------------------------
							//		just friends?

public class love extends Thread{

	public void run() {
		for(int i =0;i<100;i++){
			System.out.println("自定义线程"+i);
			
		}
	}

	public static void main(String[] args){	
		love L = new love();   //创建 子类方法
		L.start();  //创建子类对象 用start 调用   ， 开启多线程
		for(int i =0;i<100;i++){
			System.out.println("主线程"+i);
		
		}
	}
}	
(2)
--------------------------------------------------------------------------------------------------------------------


package cn.itcast;

/*
	模拟Q聊天和视频.

*/

class TalkThread extends Thread{
		public void run(){
			while(true){
				System.out.println("你好..........");				
			}	
		}
}

class VideoThread extends Thread{
	public void run(){
		while(true){
			System.out.println("视频聊天...");
		}		
	}	
}

public class love{
	public static void main(String[] args){
		TalkThread talkThread = new TalkThread();
		talkThread.start();
		VideoThread videoThread = new VideoThread();
		videoThread.start();
	}
}

法二：(1)
----------------------------------------------------------------------------

				  (in pemen s) 修正
public class Demo3 implements Runnable{
	
	public void run(){
		for(int i=0 ; i<100; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}					   /*    当前线程              */
	}

	public static void main(String[] args){
		//创建 Runnable实现类对象
		Demo3 d = new Demo3();          ---- d 就是Runnable实现类对象
		//创建Thread类的对象，把 Runnable作为实现类对象作为实参传递
		Thread thread = new Thread(d,"狗娃");            参数传递 Thread （ Runnable target , String name）
		//调用trhead对象的start方法   开启线程；
		thread.start();

		for(int i=0 ; i<100; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

(2)
---------------------------------------------------------------------------------------------------------------------

class SaleTicket implements Runnable
{
	int num = 50 ;// 票数

	public void run(){
		while(true){
			synchronized("锁"){
				if(num>0){	
					System.out.println(Thread.currentThread().getName()+"售出第"+num+"好票！");
					num--;
				}else{
					System.out.println("售空！..");
					break;
				}
			}
		}
	}
}	

public class Demo3
{
	public static void main(String[] args){
		
		SaleTicket s = new SaleTicket();   
		//SaleTicket 里的 int = 50  只有一份  使得前面不用加 start
		
		
		Thread t1 = new Thread(s,"111号");
		Thread t2 = new Thread(s,"222号");
		Thread t3 = new Thread(s,"333号");
		t1.start();
		t2.start();
		t3.start();
	
	}
}






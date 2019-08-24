
用线程调用函数时    共同项要加上静态   不然会创建 新的对象 

线程安全问题；   cup的资源抢夺问题     

			1.存在两个或两个以上的线程对象， 而且线程间共享着一个资源
			2.有多个语句操作了共享语句


解决方法：（同步）


   法一：
	 同步代码块
	    synchronized ("锁对象"){
	 	   需要同步的代码..
	   }

     同步代码块要注意:
       1.锁 对象  可以使任意一个
       2.再同步代码中调用了sleep方法并不会释放锁对象的
       3.如果没有线程安全问题时候不要使用同步代码块，  
         否则会降低效率
       4. 锁 对象，必须是唯一共享的，否则锁不住
	


   方法二：
	
	同步函数           
		使用 synchronized 修饰一个函数

	注意：
		1.如果一个非静态同步函数的锁 对象是 this 对象，
		  如果静态同步函数的锁 对象时当前函数所属类的 
		  字节码文件（ class 对象 ）.
		2.同步函数的锁对象时固定的 不能由你来指定

  


class SaleTicket extends Thread{
	
	// 不是静态的话 会创建出多份   数据
	static int num = 50;
	
	//创建一个共享的        锁对象
	static Object o = new Object();
	
	
	public SaleTicket(String name){
		super(name);
		
	}
	
	public void run(){
		while(true){
			//同步代码块
			synchronized(o)
			{
			if(num>0){
				System.out.println(Thread.currentThread().getName()+"售出了第"+num+"号票");
				num--;
			}else{
				System.out.println("售空..");
				break;
			}
			}
		}
	}
}
public class love{
	public static void main(String[] args){
		SaleTicket thread1 = new SaleTicket("窗口1");
		SaleTicket thread2 = new SaleTicket("窗口2");
		SaleTicket thread3 = new SaleTicket("窗口3");
		thread1.start();
		thread2.start();
		thread3.start();	
 }

}
--------------------------------------------------------------------------
     
	 取钱问题      
	 
class BankThread extends Thread{

	static int count = 5000;
	
	public BankTherad(String name){
		super(name);
	}
	
	public void run(){
	
		while(true){
			synchronized("锁"){
				if（count>0）{
					System.out.println(Thread.currentThread().getName()+"取走了1000块，"+"还剩"+(count-1000)+"元");
				}else{
					System.our.println("取光了......");
					break;
				}
			
			}
		}
	}
	
	public class love{
		
		public static void main(String[] args){
			//创建两个线程对象
			BankTherad thread1 = new BankTherad("老公");
			BankTherad thread2 = new BankTherad("老婆");
			thread1.start();
			thread2.start();
		}
	
	}
}



-----------------------练习----------------------

  取钱问题    同步函数方法      
  
  做法一：
  
class BankThread extends Thread{

	static int count = 5000;
	
	public BankTherad(String name){
		super(name);
	}
	// 锁函数方法      将方法锁住   会影响代码运行的效率
	public synchronized void run(){
	
		while(true){
			
				if（count>0）{
					System.out.println(Thread.currentThread().getName()+"取走了1000块，"+"还剩"+(count-1000)+"元");
				}else{
					System.our.println("取光了......");
					break;
				}
			
			}
		
	}
	//静态的函数     ->  函数锁 属性的字节码文件  -> BankThread.class
	public static synchronized void getMoney(){}


	public class love{
		
		public static void main(String[] args){
			//创建两个线程对象
			BankTherad thread1 = new BankTherad("老公");
			BankTherad thread2 = new BankTherad("老婆");
			thread1.start();
			thread2.start();
		}
	
	}
}

---------------------------------------------------------------------------

  取钱问题    同步函数方法   
  
	做法二：

class BankThread extends Thread{

	static int count = 5000;
	
	public BankTherad(String name){
		super(name);
	}
	// 和上相同   但会引起 一个线程 取光所有的钱  
	public void run(){
		getMoney（）;
		
	}
	
	public static synchronized void getMoney(){
		while(true){
			
				if（count>0）{
					System.out.println(Thread.currentThread().getName()+"取走了1000块，"+"还剩"+(count-1000)+"元");
				}else{
					System.our.println("取光了......");
					break;
				}
			
			}
	
	}


	public class love{
		
		public static void main(String[] args){
			//创建两个线程对象
			BankTherad thread1 = new BankTherad("老公");
			BankTherad thread2 = new BankTherad("老婆");
			thread1.start();
			thread2.start();
		}
	
	}
}
c

public class Demo implements Runnable{
	
	public void run{
		for(int i = 0 ; i > 100 ; i++ ){
			System.out.println(Thread.currentThread().getName+":"+i);
		}
	}

	public static void main(String[] args){
		Demo d = new Demo();

		Thread T = new Thread(D,"外部线程");
		T.start();

		//本地线程
		public void run{
		for(int i = 0 ; i > 100 ; i++ ){
			System.out.println(Thread.currentThread().getName+":"+i);
		}
		}
	
	}
}
public class Demo implements Runnable
{
	public voic run{
	
	}
	public static void main(String[] args){
		Demo d = new Demo("外部线程");
		Thread T = new Thread(d);
		T.start();

	}
}


线程 安全   


法一同步代码块
	synchronized



public class love extends Thread
{
	public void run(){
	
		for(int i=0 ; i>100 ; i++){
			System.out.println("2222222222222222");
		}
	}

	public static void main(String[] args){
	
		love l = new love();
		l.start();

		for( int i=0 ; i>100 ; i++ ) {
			System.out.println("1111111111111111111");
		} 	
	}
}

public class Demo implements Runnable
{
	public void run(){
		for(int i=0 ; i>100 ; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}

	public static void main(String[] args){
		Demo d = new Demo("外部线程");
		Thread t = new Thread(d);
		t.start();

		for(int i=0 ; i>100 ; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	
	}
}



------售票机---------
/**
	一个售票机 供多个人使用
*/

class SaleTicket implements Runnable
{

	int num = 50 ; //票数
	
	public void run(){
	while(true){
		synchronized("锁"){ // synchronized
			if(num>0){
				System.out.println(Thread.currentThread().getName()+"售出第"+i+"张票！");
				num--;
			}else{
				System.out.println("售空！..");
				break
			}
		}
	}
	}
}
public class Demo
{
	public static void main(String[] args){
		SaleTicket s = new SaleTicket();

		Thread t1 = new Thread(s,"小红");
		Thread t2 = new Thread(s,"小明");
		Thread t3 = new Thread(s,"小黄");

		t1.start();
		t2.start();
		t3.start();
	}
}


死锁的出现  共享的资源出现2个或以上

线程安全




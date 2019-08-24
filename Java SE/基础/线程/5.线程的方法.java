


线程通讯： 一个线程完成了自己的任务时，要通知另外一个线程去完成另外一个任务.
 
生产者与消费者


wait():  等待   使线程进入锁状态，并释放 锁 等待 notify 唤醒。
notify()： 唤醒   线程池中的一个

notifyAll() : 唤醒 线程池中所有


wait与notify方法要注意的事项：
	1. wait方法与notify方法是属于Object对象 的。
	2. wait方法与notify方法必须要在同步代码块或者是同步函数中才能 使用。
	3. wait方法与notify方法必需要由锁对象调用。   锁对象不同 建立的线程池也不同
	



线程的停止（下有）
join()  优先执行







问题一：出现了线程安全问题。 价格错乱了...
 

//产品类
class Product{
	
	String name;  //名字
	
	double price;  //价格
	
	boolean flag = false; //产品是否生产完毕的标识，默认情况是没有生产完成。
	
}

//生产者
class Producer extends Thread{
	
	Product  p ;  	//产品
	
	public Producer(Product p) {
		this.p  = p ;
	}
	
	
	

	public void run(){
		int i = 0 ; 
		while(true){
		 synchronized (p) {
			if(p.flag==false){
			if(i%2==0){
				p.name = "苹果";
				p.price = 6.5;
			}else{
				p.name="香蕉";
				p.price = 2.0;
			}
				System.out.println("生产者生产出了："+ p.name+" 价格是："+ p.price);
				p.flag = true;
				i++;
				p.notifyAll(); //唤醒消费者去消费
			}else{
		//已经生产 完毕，等待消费者先去消费
			try {
				p.wait();   //生产者等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}	 
			}	
			}	
		}
		}


//消费者
class Customer extends Thread{
	
	Product p; 
	
	public  Customer(Product p) {
		this.p = p;
	}
	
	
	@Override
	public void run() {
		while(true){
			synchronized (p) {	
				if(p.flag==true){  //产品已经生产完毕
					System.out.println("消费者消费了"+p.name+" 价格："+ p.price);
					p.flag = false; 
					p.notifyAll(); // 唤醒生产者去生产
				}else{
					//产品还没有生产,应该 等待生产者先生产。
					try {
						p.wait(); //消费者也等待了...
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}	
	}
}

public class love {
	
	public static void main(String[] args) {
		Product p = new Product();  //产品
		//创建生产对象
		Producer producer = new Producer(p);
		//创建消费者
		Customer customer = new Customer(p);
		//调用start方法开启线程
		producer.start();
		customer.start();
		
		
	}
	
}
--------------'线程停止


 线程的停止：
 	1. 停止一个线程 我们一般都会通过一个变量去控制的。
 	2. 如果需要停止一个处于等待状态下的线程，那么我们需要通过变量配合notify方法或者interrupt()来使用。
 


public class Demo6 extends Thread {
	
	boolean flag = true;
	
	public Demo6(String name){
		super(name);
	}
	
	
	@Override  
	public synchronized void run() {
		int i = 0 ;
		while(flag){
			try {
				this.wait(); //狗娃等待..
			
			} catch (InterruptedException e) {
				System.out.println("接收到了异常了....");
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
			i++;
		}
	}
	
	
	
	public static void main(String[] args) {
		Demo6 d = new Demo6("狗娃");
		d.setPriority(10);
		d.start();
		
		for(int i = 0 ; i<100 ; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
			//当主线程的i是80的时候停止狗娃线程。
			//d.interrupt();  // interrupt()根本就是无法停止一个线程。
			if(i==80){
				d.flag = false;
				d.interrupt(); //把线程的等待状态强制清除，被清除状态的线程会接收到一个InterruptedException。 
				/*synchronized (d) {					
					d.notify();
				}*/				
			}
		}
	}
}
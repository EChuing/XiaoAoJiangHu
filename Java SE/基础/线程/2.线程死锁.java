
java中同步机制 解决类线程安全问题 ， 但是 却引起死锁






如下例题：
	死锁：    （有时会出现  有时不会出现）
			 一个拿到电池， 一个拿到遥控器   
			 且还留在锁中，  等待对方出来。





出现死锁的原因：

				存在两个或者两个以上的线程和资源

解决方案：
				没有方法，只可以尽量避免







class DeadLock extends Thread{
	
	public DeadLock(String name){
		super(name);
	}	

	public void run(){
		if("张珊".equals(Thread.currentThread().getName())){
			synchronized("遥控器"){
				System.out.println("张珊拿到了遥控器，还有那电池...");
			synchronized("电池"){
				System.out.println("张珊拿到了遥控器与电池");
		}else if("狗娃".equals(Thread.currentThread().getName())){
			synchronized("电池"){
				System.out.println("狗娃拿到了电池，还有那电池...");
			synchronized("遥控器"){
				System.out.println("狗娃拿到了遥控器与电池");
				}	
		}
	}
}



class love
{
	public static void main(String[] args) 
	{
		DeadLock thread1 = new DeadLock("张珊");
		DeadLock thread2 = new DeadLock("狗娃");
		// 开启线程
		thread1.start（）；
		thread2.start（）；

	}
}
     

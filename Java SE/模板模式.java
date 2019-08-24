
模板模式： 某类事情的步骤有些事固定的，有些时会发生变
			化的，那么这时候我们可以为这类事情提供一个
			模板代码，从而提高效率。

需求： 编写一个计算程序运行时间 的模板 
		
		步骤：
				1.先写出解决 该类事情其中的 一件的解决方案
				2.分析代码，把会发生变化的代码抽取出来 
				  独立成一个方法。  成抽象的方法
				3.使用 final 防止别人 重写你的模板 

--------------------------------------------------------------
class  MyRuntime
{
	public void getTime()
	{
		long startTime = System.currentTimeMillis();  // 记录开始的时间
		for(int i = 0; i<100 ; i++){
			System.out.println("i="+i);
		}
	
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间："+(endTime-startTime)); //记录结束的时间
	}
}

class Love15
{
	public static void main(String[] args){
		MyRuntime time = new MyRuntime();
		time.getTime();
	}
}


-----------------------抽取 共同部分------------------------------------

abstract class  MyRuntime   // 模板
{
	public final void getTime()
	{
		long startTime = System.currentTimeMillis();  // 记录开始的时间
		code();	
		long endTime = System.currentTimeMillis();
		System.out.println("运行时间："+(endTime-startTime)); //记录结束的时间
	}
	public abstract void code();
}

class Love15 extends MyRuntime
{
	public static void main(String[] args){
		Love15 d = new Love15();
		d.getTime();

	}
	
	// 想要用code的模板 就要
	public void code(){
		int i = 0;
		while(i<100){
			System.out.println("i="+i);
			i++;
		}
	}
}
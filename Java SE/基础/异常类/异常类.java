
学一个体系时：都是从上往下学   


	异常体系：
				  Throwable 所有错误类的超类					Throwable Error Exception				
			     （qua bou）
			     |	      |
		Error 错误		Exception 异常								
		（ a e ）	        |（E sai shen）|
				     运行异常		 编译异常




（抛出）											作用
Throwable
	toString()				  字符串           返回当前异常对象的完整类名
	getMessage()  （Me shi ju） 得到消息		返回创建Throwable传入的字符创信息
	printStackTrace() （printsida qunsi）			打印异常的栈信息

异常类			一般都会通过代码去处理
Exception  （esha shen）  
	ArithmeticException		算术异常  （e ruitemen tiE sai shen）
	NullPointerException	空指针异常 （Nen pote E sai shen）
  
  RuntimeException
	运行时异常：如果一个方法内部抛出一个运行时异常，那么方法上可以 处理或不处理
	编译时异常：如果一个方法内部抛出一个编译时异常对象，那么方法上就必须要声明，调用者也必须处理
				     （runtai Exception ）
		运行时异常： RuntimeException 以及 其子类都属于运行时异常
		编译时异常： 

错误类    一般由 jvm 或者是 硬件 引发的问题，所以我们一般不会通过代码去处理
Error



如何区分错误与异常：
	如果程序出现不正常的信息，如果不正常的信息的类是以Error结尾，那么肯定是一个错误。
	如果是以Exception结尾的，那么肯定是一个异常
		    （esha shen）

*/
class Love1 
{	
	public static void main(String[] args) 
	{	
	//	创建一个 Throwable 对象		
		Throwable t = new Throwable("头晕，感冒..");
		
		String info = t.toString();
		System.out.println("toString:"+info);
		// java.lang.Throwable 包名+类名 = 完整类名

		String message = t.getMessage();
		System.out.println("toString:"+info);

		System.out.println("message"+message);
		test();
	}

	public static void test(){
		Throwable t =new Throwable();
		t.printStackTrace();
	}
	
	/*
	//第二个 
	public static void main(String[] args)
	{
		//java 虚拟机在默认的情况下 只能管理64m内存。
		byte[] buf = new byte[?];
		System.out.println("Hello World!");
	}*/
}
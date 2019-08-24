
--------------------------处理方式： 捕获处理------------------------------
class Love12 
{
	public static void main(String[] args) 
	{
		div(4,0);
	}

	public static void div(int a, int b , int[] arr){
		int c = 0;
		// Exception 是 ArithmeticException 和 NullPointerException 的 父类
		try{
		int c = a/b; //jvm检测到不正常情况，会创建一个异常
		System.out.println("数组长度："+arr.length);
		} catch(Exception e)   // 运用了多态 Exception = new NullPointerException();
			System.out.println("到了医院，就先打上盐水 和葡萄糖点滴....")；
				
		}catch( ArithmeticException e){//"定义变量指向异常"
			//处理异常的代码
			System.out.println("异常处理了...");
			System.out.println("toString："+e.toString());
	
		}catch （ NullPointerException e）{   // 用于处理空指针
			System.out.println("出现了空指针异常...！");
			
		}
		System.out.println("c="+c);
	} 
}
		Error结尾:			错误
		( e a )
		Exception结尾的:	异常
		（esha shen)
下面信息是通过： printStackTrace 打印出来的
				 （printsida qunsi）
-------------------------------------------------------
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Love12.div(Love12.java:9)
        at Love12.main(Love12.java:5)
-------------------------------------------------------
jvm：运行到a/b这个语句的时候，发现b为零，除数为 0 对于我们属于不正常的情况，
jvm一旦发现，就会拿上创 建printStackTrace的方法来处理




java出现异常时 下面的程序就不在运行


异常的处理：
		第一种： 捕获处理      尝试 捕抓
					
						格式： try{ 可能发生的异常代码 
							}catch{ 捕获异常的类型 变量名}{
							 (kA H)理异常的代码...
						}	
				疑问：
						1.异常的处理感觉没什么作用，因为是输出一句话而已
										
								可以用于跳转页面 链接 输出 维护页面+

						2.以后捕获处理 的时候 直接 Exception 即可？
				
								现实开发中，不同的异常 ，会有不同的处理方式，要分类
				捕获处理注意：
						1.如果try块中代码出现了异常经过了处理后，那么try-cath块外代码可以正常运行执行。
						2.	try{}块中出现异常， 只执行 catch{} 的代码。
							try{}块中出现正常， 只执行 try{} 的代码。
						3.一个try块可以 跟多个cath块 ， 捕获多种异常类型。	
						4.一个try块可以捕获多种异常的类型，但捕获的异常类必须是从小到大进行捕获，否则编译报错。
				



		第二种： 抛出处理--类似于 药店不敢不收的 病人       函数调用， 抛出给调用者
							（ throw  throws ）
				
				抛出处理注意：
						1.如果一个方法内部抛出编译时异常 对象 ， 那么须要在方法上声明抛出。
						2.如果调用了一个声明抛出异常 的方法，那么调用者必须要处理异常
						3.如果一个方法内部抛出了一个异常对象，那么 throw 语句后面的代码都不会继续执行了。
						4.一个方法遇到了 throws （su lou）关键字，这方法 会停止执行
						

			throw 和 throws 关键字：
						throw  作用于方法内部，抛出一个异常对象。

						throws	作用于方法声明上，声明抛出异常类型上
								且 后面可以依次  声明抛出  多种类型的 异常								
				疑问：
						何时使用抛出处理？何时使用捕获处理	？
							如果需要通知调用者，你代码出错了，就抛出处理
						 	如果代码直接与用户打交道，就需要捕获处理	web跳转友好页面。	 "异常不可以抛给用户"		
-----------------------处理方式： 抛出处理-------------------------------				

class Love12 
{
	public static void main(String[] args)  
	{	
	
		div(4,0); // 运行报错 由 throw new Exception();  引起
	}
									// 在方法上什么抛出	
	public static void div(int a, int b)throws Exception { 
		if(b == 0){
			throw new Exception();  // 抛出一个异常对象
		}
		int c = a/b;
		System.out.println("c="+c);
	}
}

---------------------------上式  处理后  自己处理-----------------------------

class Love12 
{
	public static void main(String[] args)     
	{	
		try{
			div(4,0); // 运行报错 由 throw new Exception();  引起
		}catch(Exception e){   
			System.out.println("出现了异常....");
			e. printStackTace();
							 }
		}
									// 在方法上什么抛出	
	public static void div(int a, int b)throws Exception { 
		if(b == 0){
			throw new Exception();  // 抛出一个异常对象
		}
		int c = a/b;
		System.out.println("c="+c);
	}
}
---------------------------上式  抛给jvm处理 -------------------------------
class Love12 
{															 // 依次多种声明多个多种				
	public static void main(String[] args) throws  Exception,NullPointerException//将2号个异常 抛出 给jvm虚拟机     
	{	
			div(4,0); // 2号，运行报错 由 throw new Exception();  引起
	}
									// 在方法上什么抛出	
	public static void div(int a, int b)throws Exception { 
		if(b == 0){
			throw new Exception();  // 1号，抛出一个异常对象  给2号
		}
		int c = a/b;
		System.out.println("c="+c);
	}
}
 jvm对于抛出异常的处理方式是 直接打印异常的 栈信息
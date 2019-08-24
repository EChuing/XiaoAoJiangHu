package cn.itcast.genrictiry;




 
 自定义泛型：  自定义泛型就是一个数据类型的占位符或者是一个数据类型的变量。
 
 方法上自定义泛型：
 	
 	修饰符		<声明自定义的泛型> 返回值类型		函数名(使用自定义泛型 ...){
 	
 	}

											修饰符 <自定义泛型声明>返回值类型 函数名（使用自定义泛型   名字）{}

	public static <T>T name(T  o){
	
	return o;
	}


 
泛型不可以使用基本数据类型，只可以用包装类类


基本类型的包装类
不同：
 int----> Integer           整型
 char---> Character			字符型     
首字母大写

 byte----> Byte				字节
 short---> Short			短整型
 long----> Long				长整型
 double ----> Double		双精度浮点型
 float -----> Float			单精度浮点型
 boolean-----Boolean		布尔型
 
 


 
 方法泛型注意的事项：
 	1. 在方法上自定义泛型，这个自定义泛型的具体数据类型是在调用该 方法的时候
		传入实参时确定具体的数据类型的。
 	
	2. 自定义泛型只要符合标识符 的命名规则即可, 
		但是自定义泛型我们一般都习惯使用一个大写字母表示。 
																		T Type  E Element
 	
----------------------------------------------------------------------------------------------------

 需求： 定义一个方法可以接收任意类型的参数，而且返回值类型必须 要与实参的类型一致。

public class Demo2 {

	public static void main(String[] args) {
		String str = getData("abc");
		Integer i = getData(123);
	}
	
	
	public static <abc>abc getData(abc o){   // 自定义类型 函数名供main调用     会根据传入的值 自动确定具体的参数类型
		
		return o;
	}
}

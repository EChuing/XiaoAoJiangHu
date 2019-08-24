
jdk1.5 新特性  ：  可变参数


需求：定义一个函数做加法功能（函数做几个数据  的加法功能是不确定的）


可变参数格式:   固定（  ... ）
	
		数据类型... 变量名
		
		
注意：	定义了可变参数   里面的参数 可传可不传
		可变参数实际上是一个数组对象
		可变参数最多位于形参中最后一个函数
		一个函数最多只有一个可变参数 （要位于最后一个）
		


 


public class Demo{
	
	
	public static void main(String[] args) {
		add(1,6);
		
		
	}
	
	
	/*
	//借用数组  加起来
	public static void add(int[] arr){
		int result = 0;
		for(int item : arr){
			result+=item;
		}
		System.out.println("综合："+ result);
	}
	*/
	
	
	
	
	
	//用可变参数
	//借用数组  加起来
	public static void add(int... arr){   // 可传可不传
		int result = 0;
		for(int item : arr){
			result+=item;
		}
		System.out.println("综合："+ result);
	
	}

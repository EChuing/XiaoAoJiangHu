
import java.util.ArrayList;

泛型：  在编译的时期进行检测，避免繁琐的类型转换



 '泛型是jdk1.5使用的新特性。'
 
黄色波浪线： 安全警告  运行时不会报错！
 
范型：在容器中添加    < >  
 
 
泛型的好处：
		1. 将运行时的异常提前至了编译时。
		2. 避免了无谓的强制类型转换 。

		注意：只在编译的时候有效，编译后不会有泛型出现
  	
  
泛型在集合中的常见应用：  （若知道类型， 两端必须一致，或者只有一端）
  

      前面接收					后面定义泛型的类型
  	ArrayList<String>  list = new ArrayList<String>();  true     推荐使用。
  	
  	ArrayList<Object>  list = new ArrayList<String>();  false
  	ArrayList<String>  list = new ArrayList<Object>();  false
  	(泛型中没有多肽类)
  	"特殊：  ArrayList<int> list = new ArrayList<int>();  不能是基本数据类型
	


//以下两种写法主要是为了兼顾新老系统的兼用性问题。 
    ArrayList<String>  list = new ArrayList();           true   
    ArrayList    list = new ArrayList<String>();   true   

'关键字 ？
//可接收任何类型泛型，不能编辑集合值 ：  一般菜方法参数中用
List<?> list = new ArrayList<String>();
list.add(1);  //报错



"关键字 extends   （上限： 限元素范围  必须是该元素的父类）
		父类泛型使用继承

 "关键字 super  （下限）
		子类使用泛型    子类调用		

注意： 泛型没有多态的概念，左右两边的数据类型 必须要一致，也可以只写一遍 。    
		
		推荐使用： 两边都写泛型。
 
		（左边：编译时   ，  右边：运行时）


 -------------------------------------------------------------------------------------------
 需求： 把一个集合中元素全部转成大写。 
 



public class Demo {

	public static void main(String[] args) {
		ArrayList<String>  list = new ArrayList<String>();  //<String> 表示该容器只能存储字符串类型 的数据。
		
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		for(int i = 0 ; i < list.size() ; i++){
			String str =  list.get(i);
			System.out.println("大写："+ str.toUpperCase());  // 字符转大写   数字的话会报错
		}					
		
		
		MyUtil.print(list);
		
		
		ArrayList<String> list2 = MyUtil.getList();
		
		
		
	}
	
}


"泛型的反射
	设置通用方法，会用到反射泛型



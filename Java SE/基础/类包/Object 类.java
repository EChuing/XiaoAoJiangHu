package cn.itcast;

/*
 
 java 面向对象语言 找适合对象 做适合事情
  
  方式一： 自定义类 然后同过自定义的类创建对象
  方式二： sun提供许多类使用， 我们只需认识      通过类 来创建
  
  
  Object 是所有类的父类 
  
  
  Object 类：
  		toString（）   	返回对象字符表示
  						作用：
  							
		equals（Object obj）  用于比较内存地址，判断对象是否相同
  		hashCode









 String()  构造方法：
 
 		String() 创建一个空内容 的字符串
 		String(bye[] bytes) 使用一个字节数组构建一个字符串对象
 
 
 		替换		String replace(String oldChar,String newChar)   
 		切割		String[] split(String regex)

 		指定 开始与结束的 索引值 取子串
				String substring(String beginIndex, int endIndex)
				begin Index 
				end   Index
				
				String toUpperCase()   转大写
				String toLowerCase()   转小写
				String trim()		   去除空格

 
 */
 
 
public class Love1 {
	public static void main(String[] args){
		Object o = new Object();
		System.out.println("toString:"+o.toString());
		// java.lang.Object@18b3364   完整类名 + @ + 对象的哈希码
		System.out.println("o="+o);// 和上面的输出结果一样
//由源代码 可知  实际调用了 println的toString 的方法
	}
	/*public static void main(String[] args) {
		String str = new String();
		byte[] buf = {97,98,99};
	}*/

}

package cn.itcast;

 字符串特点；字符串是常量，他们的值在创建之后不能更改
 
 一点变化 就会创建一个新的对象
 注意： 字符串的内容频繁修改，因为一旦 就会创建一个新对象    
 
 频繁修改 建议使用字符串缓冲类       
 -------------------------------------------------------
 缓冲类  stringBuffer  其实就是储存字符的一个容器
 
 笔试题目： 使用stringbuffer无参的构造函数创建一个对象是， 默认的初始容量是对少？如果长度不够使用，自动增长多少倍？
 		stringBuffer  底层是依赖了一个 字符数组才能 储存字符数据的， 该字符串数组默认的初始值容量是16， 长度不够用 自增长一倍
 		
 		容器具备 的行为      
 			
 			增加   
(a pende)	 	append(boolean b)   可以添加任意类型  数据到容器中
(in sete)		insert(int offset, boolean b) 指定插入的索引值，插入对应的内容
 		
 			giy
 			删除
（de lite）		delete(int start, int end)  	根据指定的开始和结束的索引值删除对应的内容。
 				deleteCharAt(int index)			根据指定的字符删除一个字符
 				
 			
 			
 			修改    
 （rui pelei）	replace(int start, int end, String str) 根据指定的开始也结束的索引值   替代指定内容
（V wuesi）		reverse()						反转字符串的内容
 				setCharAt(int index, char ch)	根据索引值 替换单个字符
 				substring(int start, int end)	根据指定的索引值 	截取子串
    			ensureCapacity(int minimumCapacity)		指的StringBuffer内部的字符数组长度的
 			 
 			 查询 
 			 indexof(String str, int fromIndex) 		查找指定字符串    第一次出现的索引值，并且指定开始查找的位置  
 			 capacity()									查看当前字符数组的长度	
 			 charAt(int strm, int fromIndex)
 			 lastIndexOf(String str)
 			 length()			多用于遍历数组
 			 toString()									  把字符串的内容转换为 字符串 返回
 			 
 			 
 			 
 StringBuffer 与  StringBuilder 的相同之处 
  			相同：
  				两个类都是字符串缓冲流
  				两个类都是方法都一致
 			不同点：
 				StringBuffer 是线程安全的,StringBuilder是线程非安全.
 			 StringBuffer是JDK1.0出现的   StringBuilder是JDK1.5出现的。
 			 
 			 
 			 建议使用StringBuilder，操作效率高

public class Demo1 {

	public static void main(String[] args) {
		// 先使用stringbuffer无参的构造函数创建一个字符串缓冲类
		StringBuffer sb = new StringBuffer();
		// 无参默认16
/*-----------------第一部分---------------------------------------------*/
//添加	
		//sb.append("java\n"); 
		//sb.insert(2, "第二个字母");
//字符是 0 1 2 ...  （2）表示 在 第二个字符前插入 	在第二个字符添加   后面的字符   
		//sb.append(true);
		//sb.append("\n"+3.14f);
//删除	
		//sb.delete(2, 6);// 删除 [2,6]的字符
		//sb.deleteCharAt(2); //删除第二个字符
//修改
		//sb.replace( 2,4,"【替换内容】");
		//sb.reverse();  // 上下  输出的内容 都颠倒
		//sb.setCharAt(3, '白');   //根据索引值  替换内容
		
		String subString = sb.substring(2,4);
		System.out.println("子串的内容:"+subString);  
/*-------------请把第一部分都注释------------------------------------------*/
//查看	
		
		sb.append("abcjavaabc");
		int index = sb.indexOf("abc",1);  //后面那个表示索引值   即开始查询的位置   直到有符合的  就返回一个新的索引值
		System.out.println("索引值为："+index);
		
		sb.append("javajava");
		sb.append("abcjavaabc");
		System.out.println("查看字符数组的长度："+sb.capacity());
		// 若用2容器时，  默认是16  这里却是一倍的+2  不懂！
		
		sb.append("abcjavaabc");
		System.out.println("储存的字符个数"+sb.length());  		//查看容器中储存字符的个数
		System.out.println("索引值查找的字符"+sb.charAt(2));
		System.out.println("字符串缓存类的内容"+sb);
		String  content = sb.toString();
		test(content);
		
/*--------------下面保持不变----------------------------------------------*/		
		
		System.out.println(sb);

	}
	
	public static void test(String str){
		
		
		
	}

}

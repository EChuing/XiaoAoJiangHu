正则表达式:
		
		用于操作字符串 	的规则
		运用特殊符号来表示



预定义字符：
		.	任意字符
		\d 	数字：[0-9] 
		\D 	非数字： [^0-9] 
		\s 	空白字符：[ \t\n\x0B\f\r] 
		\S 	非空白字符：[^\s] 
		\w 	单词字符：[a-zA-Z_0-9] 
		\W 	非单词字符：[^\w]
 
 
  \r 回车
  \n 换行      所以要加	双斜杠

注意：任何预定义字符 没加上数量词 都只能匹配一个字符。




Greedy 数量词（要在前面加   预定义字符）
			?		一次或一次也没有			0-1
			*		零次或多次				0-n
			+		一次或多次 （最少一次）	1-n
			{n}		恰好n次					刚好固定次数
			{n,}	至少n次					>=n
			{n,m}	至少n次，但是不超过m次	[n,m]

 
 
 
 范围表示
 	注意：范围词里面不管内容有多长，没有数量词的配合 都只能匹配一个字符	
		
		[abc]	在 a  b  c 范围内 ， 只可以匹配一个
		[^abc]	除了abc 外的范围 
		[a-zA-Z]	a 到 z 或 A 到 Z，两头的字母包括在内（范围） 
		
	下面的相同
		[a-d[m-p]]	a 到 d 或 m 到 p：[a-dm-p]（并集） 
		[a-z&&[def]]	d、e 或 f（交集） 
		[a-z&&[^bc]]	a 到 z，除了 b 和 c：[ad-z]（减去） 
		[a-z&&[^m-p]]	a 到 z，而非 m 到 p：[a-lq-z]（减去）


单词边界匹配器
	$		行结尾
	\b		代表 单词的开始或结束字符，  但不匹配任何字符
 

-------------------------------------------------------------------------------------


//字符
class  Demo{
	public static void main(String[] args)        
	{
		System.out.println("任意字符："+("a".matches(".")));
		System.out.println("数字字符："+("9".matches("\\d")));
		
		// 没加数量词    如：12
		System.out.println("数字字符："+("12".matches("\\d")));
		System.out.println("\\d数字字符："+("12".matches("\\d\\d"))); // 把12 当做 		1和2 
	
		//非数字字符
		System.out.println("\\D非数字字符："+("a".matches("\\D")));
		System.out.println("\\s空白字符："+("\r".matches("\\s")));
		System.out.println("\\非空白字符："+("\n".matches("\\S")));						
		System.out.println("\\w单词字符："+("w".matches("\\w")));
		System.out.println("\\W 非单词字符："+("@".matches("\\W")));
	}
}


 // 字符 + 数量词
class  Demo{
	public static void main(String[] args)        
	{	// 判断	数字	是否出现 一次或一次都没出现				
		System.out.println("？ 一次  或  一次都没有"+("1".matches("\\d?")));
		// 判断	数字	是否出现 零次或多次
		System.out.println("* 零次或多次"+("1".matches("\\d*")));
		// 判断	数字	最少出现一次
		System.out.println("+ 至少出现一次"+("4678251".matches("\\d+")));
		// 判断	数字	是否出现 零次或多次
		System.out.println("* 零次或多次"+("123".matches("\\d?")));
		
		System.out.println("{次数} 恰好出现n此"+("123".matches("\\d{11}")));
		System.out.println("{次数,} 最少出现指定次数"+("123".matches("\\d{3,}")));					
		System.out.println("{次数1,次数2} 指定出现次数的范围"+("123".matches("\\d{3,4}")));
	
	}
}




// 限定范围
class  Demo{
	public static void main(String[] args)        
	{	
		System.out.println("a".matches("[abc]"));
		System.out.println("@".matches("[^abc]"));
		System.out.println("字符可以出现在a-z之间"+("#".matches("[a-zA-Z]")));
	}
}



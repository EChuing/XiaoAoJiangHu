
其他方法


	替换	String replace(String oldChar,String newChar)   
	切割	String[] split(String regex)

	指定 开始与结束的 索引值 取子串
			String substring(String beginIndex, int endIndex)

	String toUpperCase()   转大写
	String toLowerCase()   转小写
	String trim()		   去除空格




"==" 比较内存地址
"x1.equals（x2）" 比较 x1  x2的是内容，默认情况下比较两个对象的内存地址
				尽量保证 x1 是常量。

笔试题目：new String("abc")创建了几个对象？
两个对象，一个位于字符串常量词中，一个对象位于堆内存中





class  
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}

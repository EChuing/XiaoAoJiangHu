

单例设计模式


1.私有化构造函数
2.声明本类的的引用类型变量，并且使用该变量指向本类对象
3.提供一个公共静态的方法获取本类对象


//保证tufo在内存只有一个对象
class tofu
{	
	//私有化构造函数
	private tofu(){};

	/*声明本类的引用类型变量，并且使用该函数变量指向本类对象
		封装 且 只有一个	 */
	private static tofu s = new tofu();

	//提供一个公共静态的方法获取本类对象
	public static tofu getInstance(){
		return s;
	}
}

class  Demo1
{
	public static void main(String[] args) 
	{	tofu s1 = tofu.getInstance();
	    tofu s2 = tofu.getInstance();
		System.out.println("对么"+ (s1==s2));
	}
}

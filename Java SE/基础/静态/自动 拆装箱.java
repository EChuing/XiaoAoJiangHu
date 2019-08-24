
import java.util.ArrayList;


jdk1.5      自动装箱与自动拆箱

			java 是面向对象语言  
			任何事情都可以使用类进行描述   
			sun就使用了一些类  
			描述java中 八种基本数据类型


		基本数据类型：		包装类型：

			byte			Byte
			short			Short
			int				Integer
			long			Long
			
			float			Float
			double			Double
			
			boolean			Boolean
			
				
			char			Character
	

基本数据类型 有了对应的包装  类型的好处：
	1.字符换成 int 类型数据
	2.数字转换成对应的字符串
	3.整数 转换成对应的 进制
	4.可以吧字符串当成对应的数据  帮你转换


public class Demo{
	
	public static void main(String[] args) {
		
		String str = "12";
		
		// 字符换成 int 类型数据
		int i = Integer.parseInt(str);
		System.out.println(i+1);
		
		// 数字转换成对应的字符串
		System.out.println(Integer.toString(i));
		
		//整数 转换成对应的 进制						to bainelin siqun
		System.out.println("10的二进制："+ Integer.toBinaryString(10));
		//										tu ou tou   siqun
		System.out.println("10的八进制："+	Integer.toBinaryString(10));
		//										ha si siqun							
		System.out.println("10的十六进制："+	Integer.toHexString(10));
		
		
		//可以吧字符串当成对应的数据  帮你转换
		String data = "10";
		int a = Integer.parseInt(data,3)   ;//pasi int(传入数据，转换进制)      
	
----------------------------------------------------------------
	
集合：集合是可以存储任意	'对象数据'	的容器
		

		ArrayList list = new ArrayList();
		list.add(1);
		list.add(12);
		list.add(14);
		list.add(6);     '在jdk1.5以下会报错'  
		
jdk1.5特性 ：

			
自动装箱：	自动把java的的基本数据类型 
			转换成对象类型数据

			
			int temp = 10;   基本数据类型
			Integer b = temp; 把a存储的值赋值于 b变量
			Integer b = new Integer(temp);    			jdk 1.5 之前的写法，   
			
		
自动拆箱： 把 引用类型 的数据转换成 基本数据类型
 			


			Integer c = new	Integer(13);
 			int d = c;   jdk1.5 帮你简化了书写
 			int d = c.intVallue();   (int wailui)		jdk1.5 之前的写法
 			System.out.println(d);
			
			//引用类型的数据         cache 内部维护了一个   -127 ~ 127 的缓冲数组 
			Integer e = 128;
			Integer f = 128;
			System.out.println("同一个对象?"+ (e==f));
			/*
			Integer类内部维护来了一个缓冲数组，  
			缓冲数组[-127,127], 范围之内的数据可
			以直接获取。 范围之外的 内存地址就不
			一样了。
			*/
			
	}
	
}

------------------------------------------------------------------------------------------------


例题： 


/*
 jdk1.5新特性之-----枚举
 
 问题：某些方法所	接收的数据必须是在 固定范围之内的， 
 
解决方案： 这时候我们的解决方案就是自定义一个类,
		然后是私有化构造函数，在自定义类中创建
		本类的对象对外使用。

jdk1.5对以上问题提出了新的解决方案： 就是使用枚举类解决。

一些方法在运行时，它需要的数据不能是任意的，而必须是一定范围内的值，Java5以后可以直接使用枚举予以解决。
 	比如： 方向 , 性别 、 季节 、 星期......
 
 
 */

/*
//自定义一个性别类
class Gender{
	
	String value;
	
	public static final Gender man = new Gender("男");
	
	public static final Gender woman = new Gender("女");
	

	private Gender(String value) {
		this.value = value;
	}
}*/					
						上面的 代码可以用枚举类来简化

enum Gender{
	man("男"),woman("女");
	
	String value;
	
	private Gender(String value){
		this.value = value;
	}
}


class Person{
	
	private String name;
	
	private	Gender sex;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}		
}

public class Demo {
	
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("狗娃");
		p.setSex(Gender.woman);// Gebder.不是man就是 woman
		System.out.println("名字："+ p.getName()+" 性别："+ p.getSex().value);
		
	}
	
}

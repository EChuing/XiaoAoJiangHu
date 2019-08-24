

枚举：一些方法在运行时，它需要的'数据不能是任意的，而必须是一定范围内的值'，可以直接使用枚举予以解决。


枚举类的定义格式：
	
	enum 类名{
	man,woman //枚举值         定义了两个枚举值
	}
				
	 			
				
枚举要注意的细节：
	1. 枚举类也是一个特殊的 类。
	2. 枚举值默认的修饰符是public static final。(常量)
	3. 枚举值就是是枚举值所属的类的类型， 然后枚举值是指向了本类的对象的。
	4. 枚举类的构造方法默认的修饰符是private的。
	5. 枚举类可以定义自己的成员变量与成员函数。
	6. 枚举类可以自定义构造函数，但是构造函数的修饰符必须是private。
	7. 枚举类可以存在抽象 的方法，但是枚举值必须要实现抽象 的方法。
	8. 枚举值必须要位置枚举类 的 '第一个语句'。
	
	
	


//自定义一个枚举类
enum Sex{
		 
	//	枚举值 说白了 就是 ： public static final Sex man = new Sex();
	// 枚举值      定义类抽象方法 就要实现{}
	man("男"){

		@Override
		public void run() {
			System.out.println("男人在跑...");
		}
		
	},woman("女"){

		@Override
		public void run() {
			System.out.println("女人在跑...");
		}
		
		
	}; //枚举值
	
	String value; //成员 变量
	
	
	
	//定义构造函数     必须在枚举值传入参数
	private Sex(String  value){ //  (vao U)价值
		this.value = value;
	}
	
	//定义成员函数
	public void getValue(){
		System.out.println("value :"+ value);
	}
	//定义抽象方法
	public abstract void run();
	
}

public class Demo1 {
	
	public static void main(String[] args) {
		Sex sex = Sex.man; //获取到了枚举类的对象
		sex.value = "男";
		sex.getValue();
		sex.run();
		
	}
	
}

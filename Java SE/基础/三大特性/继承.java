继承
	
	格式： class 类名1 extends 类名2{
			}
	
	注意：
		1.父类私有对象的成员不能被继承
		2.父类构造函数不能被继承
		3.创建子类对象时，默认会先调用的无参构造函数，然后调用子类的构造函数


无参构造方法默认会自动生成  (可以不写)   若是带参方法 就一定要写出 类的方法和 super() 


--案例--
class Fu
{	String name;

	public  Fu(String name){
		this.name = name;
		System.out.println("Fu带参调用..................");
		
	}

	public Fu(){
		System.out.println("Fu无参被调用");
		
}
		//extends 继承
class Zi extends Fu{  //  子类  父类(超类 基类)
	public Zi(String name){
		super(name); 
	}
}

class Love6  // 继承注意
{
	public static void main(String[] args) 
	{	Zi b = new Zi("熊大");
		System.out.println("名字："+ b.name);
	}
}
? : 
子类的构造方法上如果没有明确的调用父类的构造方法,
默认地调用父类的不带参数的方法，

父类有定义带了参数的构造方法但是没有定义不带参数的构造方法,则系统不会默认为其创建个不带参数的构造方法
这样子类调用的时候必然就出错咯

调用时 优先调用父类的方法 后调用子类的方法




--


//普通类学生     extends  继承     ex tens
class student
{	
	String name;	

	public student(String name){
		this.name = name;		
	}
	public void study(){
		System.out.println(name+"是马克思列宁主义");
	}
}
//基础班的学生中的人
class BaseStudent extends student
{	
	public BaseStudent(String name){
		super(name);//指定调用父类构造函数
	}

	//重写
	public void study(){
		System.out.println(name+ "学习javase..");
	}
}

class WorkStudent extends student
{	//构造 函数
	public WorkStudent(String name){
		super(name);//调用父类一个参数的构造方法
	}
	//重写
	public void study(){
		super.study();
		System.out.println(name+ "学习javase+android..");
	}
}

class  Demo11
{
	public static void main(String[] args) 
	{   //普通班学生
		BaseStudent s = new BaseStudent("店小二");
		s.study();
		//就业班学生
		WorkStudent w = new WorkStudent("老板");
		w.study();
	}
}

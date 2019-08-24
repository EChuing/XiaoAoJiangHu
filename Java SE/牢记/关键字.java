
--------------------------super 关键字-------------------
super 代表父类空间的引用

      作用 ： 
			1.子父类存在同名成员时，在子类中默认是访问子类成员变量，
			  可以通过super关键字指定访问父类的成员。
			2.指定调用父类的构造方法。 ()判断有无参数
		
调用父类构造方法要注意：
			1.如果在子类的构造方法上没有指定调用父类的构造方法，
			  那么java编译器会在构造方法上面加 super(); 语句。
			2.super 调用父类，在子类构造函数中必须是第一个语句

super 必须出现在子类构造方法里


	
	this();指定调用无参的构造方法
	super();//指定调用父类无参构造方法

	1.都必须是第一条语句 且 调用其他构造方法
	2.不可以同时出现在 同个构造函数中
	3.super 存在继承关系 出现在子类构造方法里 调用父类       extends
	  this  指的都是 本类 的 成员变量
	
	String name；
	public String name(String name){   // 形参和变量名相同 就要用this 区分
	this.name = name 
	}










*/


class Fu
{   int x = 10;
    public void eat(){
		System.out.println("小偷在哪里...");
	}
}

class	Zi extends Fu 
{	int x = 20;

	public void print(){
		//this();指定调用无参的构造方法
		//super();//指定调用父类无参构造方法
		super.eat(); //函数名重复时，若在前面加super 会直接访问父类的 eat  .
		System.out.println("x = "+super.x);
	}                         
	public void eat(){
		System.out.println("警察在哪里...");
	}
}

class  Super
{
	public static void main(String[] args) 
	{
		Zi z = new	Zi();
		z.print();
	}
}



/*
------------------重载----------------------
----------------有继承关系才可以用----------
 
问题：父类方法无法满足时

方法重载： 在一个类中 存在两个会两个以上的同名函数，称作方法重载

重载要求：
		1.函数名要一致
		2.形参列表不一致(形参的个数 或 形参的类型不一致)
		3.与返回值类型无关

重写注意：
		1.方法名和形参列表必须一致。
                xxx eat(){xxx}
		2.子类的权限修饰符必须 大于等于 父类的权限修饰符
		3.返回值类型 小于等于 父类返回值
		4.子类抛出异常类型要小于等于父类抛出异常类型
			Exception(最坏) (E sa sen)
			RuntimeException(小坏) (luntai E sa sen) 
		

*/
----------------------this 关键字---------------------------------
class Fu
{	String name;
	
	public Fu(String name){
		this.name = name ;
	}

	public void eat(){
		System.out.println(name+"不知道熊大在哪里...");
	}
}

class Zi extends Fu
{	String num;
	public Zi(String name){
		super(name);
	}

	//重写父类eat方法
	public void eat(){
		System.out.println("好");
		System.out.println("好");
		System.out.println("学");
		System.out.println("习");
		System.out.println("！");
	}
}


class Chongzai
{	public static void main(String[] args)
	{
		Zi z = new Zi("熊二");
		z.eat();
	}
}

class Person{
	int id;
	String name;
	int age;
	
	//构造函数
	public Person(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//比较函数的方法
	public void compareAge(Person p2){
		if(this.age>p2.age)
		{	System.out.println(this.age+":大.");
		} else if (this.age < p2.age)
		{	System.out.println(this.age+":小.");
		} else  
		{	System.out.println(this.age+":相等.");
		}
	}
	
}

class this01{
	public static void main(String[] args){
		Person p1 = new Person(100086, "小狗", 100);	
		Person p2 = new Person(100086, "小猪", 200);
		p1.compareAge( p2);
	}
}

----------------------------------------final （fai no）-----------------------------------------
/*
	final(最终、修饰符)

	  作用：
			1.修饰一个基本类型的变量时，该变量不可以重新赋值，第一次为最终
			2.修饰一个引用型变量时，该变量不能重新指向新对象
			3.修饰一个函数式，该函数不可以被重写


常量 的一般修饰符： public static final

*/			"public static final double pi = 3.14" 
			//公开 只有一份 不能修改 

//园
class Circle
{ 
	double r;//半径

	final double pi = 3.14; //固定不变的

	//计算圆的面积
	public void getArea(){
		System.out.println("圆形的面积是："+ r*r*pi);
	}
}
class DDemo
{
	public static void main(String[] args) 
	{
		/*	final Circle  c = new Circle(4.0);
		//第二个作用
		*/	test(c);
	}

	public static void test(Circle c){
		c = new Circle(5.0); //变量重新指向了新对象
	}
}


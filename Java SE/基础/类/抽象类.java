			
/*                                                                         抽象类 abstract
问题：
	   1.动物的run方法不正确
	   2.没有强制子类一定要重写run的方法

抽象类：
		作用：强制子类方法重写
		
	注意：                    (main ？)
		1.如果一个函数没有方法主体，那么该函数必须要用abstract修饰成，抽象的函数
		2.如果一个类出现了抽象类，那么必须该类也必须 使用abstract修饰
		3.如果一个非抽象类继承了抽象类，那么必须要把抽象类的所用抽象方法全部实现
		4.抽象类可以存在非抽象方法，也可以存在抽象的方法
		5.抽象类不能创建对象。 因为抽象类存在的抽象方法的，如果能让抽象类创建的话，那么使用抽象的对象调用抽象的方法是没有任何意义的。
		6.抽象类是存在构造函数的，其结构是提供给子类创建对象的时候初始化父类的属性

抽象类注意：
       1.一个函数没有方法主体，那么该函数必须用abstract修饰， 称为抽象类
	   2.如果一个函数是抽象类，那么该类也必须用abstract修饰
	   3.如果一个非抽象类继承了抽象类，就要写出对应且不含abstract的构造方法
                  (abe sique de)

abstract不能与以下关键字组合：
		1.不以private（plai ruike）共同修饰一个方法      私有出了这个类就不可见
		2.不以static（sa ti ke）共同修饰一个方法         别人可以使用类名进行调用
		3.不以final（fai no）共同修饰一个方法            又是最终 又要重写


*/
//类名抽象化
abstract class	Animal{                           
	
	String name;
	String color;
	
	public Animal(String name, String color) 
	{	this.name = name;
		this.color = color;
	}
	//函数抽象化  且不可以有花括号（主体）
	public abstract void run();

}

//狗
class Dog extends Animal
{	public Dog(String name,String color)
	{
		super(name,color);//调用父类两个参数的的构造方法
	}
	//实现抽象化 重写方法
	public  void run(){
		System.out.println(name+"四条腿，跑的贼快！");
	}

}

//鱼 
class Fish extends Animal
{	public Fish(String name,String color)
	{
		super(name,color);
	}
	public void run(){
		System.out.println(name+"灵活的尾巴，游得贼快！");
	}
	
}

class Doow
{	public static void main(String[] args)
	{
		Dog d = new Dog("牧羊犬","黑色");
		d.run();

		Fish f = new Fish("金鱼","金黄色");
		f.run();
	}
}

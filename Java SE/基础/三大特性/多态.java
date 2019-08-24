
多态：一个对像具备多种形态。  
							两种：	父类引用类型变量	指向	子类对象			父类  a = new 子类();
									接口引用类型变量	指向	接口实现类的对象	接口 变量 = new 接口实现类的对象

多态的前提："必须存在继承 或者 实现关系

	多态作用：	
			1."提高代码的扩展性
			2.判断对象是否属于指定类别。
			3.多态中，做类型转化时都要先判断在转换。 
   
				格式：只能是 （对象  instanceof 类名 ） ture false   不然就报错
	多态注意：
			1.  多态情况下，子父类存在同名的成员变量时，访问的是父类的成员变量。
			2.  多态情况下，子父类存在同名的非静态的成员函数时，访问的是子类的成员函数。
			3.  多态情况下，子父类存在同名的静态的成员函数时，访问的是父类的成员函数。
			4.  多态情况下，不能访问子类特有的成员。

	 

	多态的应用：
			1. 多态用于形参类型的时候，可以接收更多类型的数据 。
			2. 多态用于返回值类型的时候，可以返回更多类型的数据。



总结：	多态情况下，子父类存在同名的成员时，访问的都是父类的成员，除了在同名非静态函数时才是访问子类的。
		
		编译看左边，运行不一定看右边。
		编译看左边：java编译器在编译的时候，会检查引用类型变量所属的类是否具备指定的成员，如果不具备马上编译报错。



// (Abe sique de)抽象的        (A nime)动物
abstract class Animal 
{	
	String name;
	String color = "动物色";//  颜色(ko le)

	public Animal(String name){
		this.name = name; // this 调用本函数的成员变量
	}
	public abstract void run();
}	
// 老鼠 mao si）
class  Mouse extends Animal
{	
	public Mouse(String name){
		super(name);//调用父类 一个参数的构造方法
	}
	// 给个构造方法 
	public  void run(){
		System.out.println(name+"四条腿慢慢的走！");
	} 
}
//鱼 (fyi xu)      继承 （ex tensi）
class Fish extends Animal
{
	public Fish(String name){
		super(name);//同上
	}
	//给个构造方法
	public void run(){
		System.out.println(name+"一条尾巴游呀游...");
	}
}


class Dtai
{	
	public static void main(String[] atgs)
	{	// 普通方法	
		Mouse m = new Mouse("老鼠");        //子类指向型   不能用父类以外的方法            
		m.run();
		
		//多态方法
		Animal a = new Mouse("米老鼠");     //父类指向型  可以调用父类的属性和方法  
		a.run();
	}
}

父类指向型  若子类重写了父类的方法  那么父类就会调用该方法  （动态链接）？  没验证过

//-----------------练习--------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
/*
需求1： 定义一个函数可以接收任意类型的图形对象，并且打印图形面积与周长。


    抽象类：某各类的方法不正确，要强制其重写


*/

//图形类
abstract class MyShape{
	//	 构造函数没有方法主体 需要abstract 修饰为抽象类
	//   出现类abstract 则类名也需要用 abstract 修饰         必须要别类重写方法
	public abstract void getArea();

	public abstract void getLength();	
}


			//继承
class Circle extends MyShape{
	// 常量
	public static final double PI = 3.14;

	double r;
	//构造本类方法
	public Circle(double r){
		this.r =r ;	
	}
	// 重写方法
	public  void getArea(){
		System.out.println("圆形的面积："+ PI*r*r);
	}
	//重写方法
	public  void getLength(){
		System.out.println("圆形的周长："+ 2*PI*r);
	}
}


class Rect  extends MyShape{

	int width; // 长
	int height;//高

	public Rect(int width , int height){
		this.width = width;
		this.height = height;
	}

	public  void getArea(){
		System.out.println("矩形的面积："+ width*height);
	}

	public  void getLength(){
		System.out.println("矩形的周长："+ 2*(width+height));
	}
}



class Demo12 {

	public static void main(String[] args) 
	{
		/*
		//System.out.println("Hello World!");
		Circle c = new Circle(4.0);
		print(c);

		Rect r = new Rect(3,4);
		print(r);
		*/

		MyShape m = getShape(0); //调用了使用多态的方法，定义的变量类型要与返回值类型一致。
		m.getArea();
		m.getLength();
		

	}


	//需求1： 定义一个函数可以接收任意类型的图形对象，并且打印图形面积与周长。
	public static void print(MyShape s){ // MyShpe s = new Circle(4.0);
		s.getArea();
		s.getLength();
	}


	// 需求2： 定义一个函数可以返回任意类型的图形对象。
	public static MyShape  getShape(int i){
		if (i==0){
			return new Circle(4.0);
		}else{
			return new Rect(3,4);
		}
	}
//-----------------练习--------------------------------------------------------------------
//-----------------------------------------------------------------------------------------

interface Dao  //接口的方法全部都是非静态的方法
{
	public void  add();
	public void delete();
}

//接口的实现类
class UserDao implements Dao{
	public void add(){
		System.out.println("添加员工成功！");
	}

	public void delete(){
		System.out.println("删除员工成功！");
	}
}


class  Love10
{
	public static void main(String[] args){
		//实现关系下的多态
		Dao d = new UserDao();
		d.add();
	}
}

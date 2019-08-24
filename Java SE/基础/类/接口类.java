
反编译： javap -c -l -private 类名


接口：
	注意：
		1.接口是个特殊的类
		2.接口成员变量默认的修饰符为： public static final    （成员变量都是常量）
		3.接口中的方法都是抽象的方法，默认修饰符为：public abstract（abe sique tr)
		4.接口不能创建对象
		5.接口是没有构造方法的
		6.接口是给类去实现使用的，非抽象类实现一个接口是，必须把 所有接口的方法全部实现

	格式：        （in peli mensi）
		class  类名 implements  接口名{
		}
	
	
	作用： 
		1.具有扩展功能
		2.定义约束规范
		3.程序的解耦


 常数：一声明就要定义

/*
interface A
{	//成员变量  和常量一样
	public static final int i = 10;
	
	//成员函数
	public void print();
}
（in peli mensi）
class fee2 implements A
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
*/



//普通的铅笔类
 class Pencil
 {	
	String name;

	public Pencil(String name){
		this.name = name;
	}
	
	public void write(){  //ruai te 
		System.out.println(name+"莎莎的写了起来..");
	}

 }
  
//橡皮的接口
interface Eraser   //  （int feisi）    （E leAse）
{	
	public void remove(); //(V muiF)
}
//带橡皮的铅笔     具备铅笔的所用功能 （继承铅笔） 
class PencilWithEraser extends Pencil implements Eraser 
{	public PencilWithEraser(String name){
		super(name);
	}
	public void remove(){
		System.out.println("涂改........");
	}
}

class Lvoe9
{
	public static void main(String[] args)
	{
		PencilWithEraser p = new PencilWithEraser("傻逼铅笔");
		p.write();
		p.remove();
	}
}




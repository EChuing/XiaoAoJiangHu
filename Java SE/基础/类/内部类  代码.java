
内部类： 一个定义在另外一个类的内部，那么该类就称作内部类

内部类的class文件名：外部类$内部类。   利于：便于区分class文件是属于哪个外部类
内部类的类别：
	
	成员内部类：

					方式1：在外部类 提供一个方法创建内部类的对象进行访问。

					 2：在其他类 直接 创建内部类的对象。 
						格式 ：	外部类.内部类  变量名 = new 外部类().new 内部类
							
						注意：如果是一个静态内部类，那么在其他类 创建的格式：
								外部类.内部类 变量名 = new 外部类.内部类();


		内部类引用场景：我们在描述A类事物的时候，发现描述A事物内部还存在另外一个 比较
						复杂的事物B时候， 而且这个比较复杂事物B还需要要访问A事物的属性等数据，那么这时
						候 我们就可以使用内部类描述B事物
							
						
	内部类的好处： 内部类可以直接访问外部类的所用成员 （悟空进牛魔王的肚子）
								
						注意：	1.外 内 部类 都存在同名变量时，在内部类中默认访问的是内部类的成
						员变量（就近原则）， 可以通过   外部类.this.成员变量名 访问指定变量
								2.私有的成员变量 只能在外部类提供一个方法创建内部类的对象  进行
								访问，不能再其他类创建对象了.
								3.成员内部类出现类静态的成员，那么  该类需要用staic修饰
										原因：	
		
		
		
		
		局部内部类：在一个类的 方法内部定义另一个类， 那么另一个类就是方法内部类。


//------------------------------

	1.构造代码
	2.局部代码
	3.静态代码 static
			
			构造代码
			  {
				i = 3000000000000000; 
			  }
//-----------------------------




class Outer
{
		int x = 100;

	    //成员内部类：
		class Inner
		{	
			int i; 
			public void ptint()
			{
				System.out.println("这是成员内部类");
			}
		}

		//在外部类的   方法中创建内部类的 对象， 然后调用内部 方法。
		public void instance(){
			Inner inner = new Inner();
			inner.ptint();
		}

		//局部内部类
		public void test()
		{
			class Inner
			{	
				int i = 100;
				public void print()
				{
					System.out.println("这是局部内部变量");
				}
			}
		}

}



/*class  Outer
{	
	int i ;//成员变量

	public void test()
	{
		//内部类
		class Inner
		{	
			int i; //局部变量
		}
	}
}*/
class  Love11
{
	public static void main(String[] args) 
	{	
		Outer outer = new Outer();
		outer.instance();
		System.out.println("Love11 de  ");

		Outer.Inner inner = new Outer.Inner();
		inner.print();


	}
}


//-------------------代码块-----------------------------
class Love7
{
	int id;  //编号

	String name;//名字
	
	int age;//年龄 都属于"方法之外，类之内"叫 成员位置上

	public void work(){
		System.out.println("今天是个好日子！");	
	}
	public qqwe(){ System.out.println("程序2 运行"); }
	public qqwe(int q , String w , int e){
		id =  q;
		name =  w;ds
		age = e ;

		work(); 
		// 在构造函数里加入 类的属相  便于调用时使用 
		//  不然不会显示    
		
		System.out.println("程序1 运行");	
	}
}

class Demo3
{
	public static void main(String[] args){
		//创建一个员工对象
		qqwe e1 = new qqwe(10086    , "小学生  " , 50);
		
		System.out.println("编号： " + e1.id + "名字： " + e1.name +  "年龄：" + e1.age);
	}
}
class 
{	
	public static void main()
	{
		//局部代码块 大括号位于方法之外
		{
			new......	
				System.out.println.......
		}
		//作用：缩短局部变量的生命周期 节约一点点内存
	}
		public static void main()
		{   //局部代码块
			{
				baby b1 = new baby（参数，）
                System.out.println（....）
			} //到此括号时 结束 释放内存 
			  // 现在很少人会考虑 公司有钱会帮你买
		}
}



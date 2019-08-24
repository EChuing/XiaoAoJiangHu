public : 公共的 
private: 私有的  修饰的成员变量只能在本类中进行直接访问











JAVA的特性：（面向对象的三大特性）
	封装：	将所有的成员变量 加上 private ，只提供 set() get() 供访问
		特点：
			1.提高数据的安全性
			2.操作简单
			3.隐藏代码的实现

		步骤：
			1.使用一个private修饰需要被封装的成员变量
			2.提供一个公共的方法设置或获取 该类的成员属性
				get();
				set();




	继承：	抽取事物的共性，供相同类的访问
			1.提高代码的复用性
			2.让类与类之间产生关系，提供一个特征多态的前提
			
		格式： class XX extends YY{
				   }
		注：		1.父私成员有不能被继承
				2.父构函数不能被继承  （ JVM优先调用父类 在调用子类  ）
				3.创建子类对象时，默认优调用父无参函数，后调子类函数			
		 
	
	
	
	多态：	（ 常用于框架中的抽象类与实现类 或 数据类型的装换 ）
			一个类具有多种形态
			
			1.提高代码的扩展性
			2.判断对象是否属于指定类别
			3.多态中做类型转换 都先判断，后转换  不然会报错
			
		格式： （ XX instanceof YY ） true false  
		前提： 必存在继承 或 实现关系
			父类 a = new 子类();
		  //接口 变量 = new 接口实现类的对象
			（父类的引用类型 变量指向了子类对象）
			或是接口的 引用类型变量指向了接口实现类的对象

		注意：
			1.  多态情况下，子父类存在同名的成员变量时，访问的是父类的成员变量。
			2.  多态情况下，子父类存在同名的非静态的成员函数时，访问的是子类的成员函数。
			3.  多态情况下，子父类存在同名的静态的成员函数时，访问的是父类的成员函数。
			4.  多态情况下，不能访问子类特有的成员。

		总结：多态情况下，子父类存在同名成员，访问的都是父类的成员，除同名非静函数，都访问子类的。

		编译看左边，运行不一定看右边。

		编译看左边：java编译器在编译的时候，会检查引用类型变量所属的类是否具备指定的成员，如果不具备马上编译报错。
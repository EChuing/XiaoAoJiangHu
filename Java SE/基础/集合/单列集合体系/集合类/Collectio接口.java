
 集合：存储对象数据的集合容器
 
集合比数组的优势：
	1. 集合可以存储任意类型的对象数据，数组只能存储同一种数据类型 的数据。
	2. 集合的长度是会发生变化的，数组的长度是固定的。
	

		
		(ke lashen)
-------| Collection  单例集合的跟接口。 
 细分为两种：
			 （li siti）	列表
 ----------| List  如果是实现了List接口的集合类，具备的特点： 有序，可重复。
			作用：一个接口			有序： 数据存储进去的顺序 和 输出的 数据是一致的， 允许有相同的数据	
 ----------| Set   如果是实现了Set接口的集合类，具备特点： 无序，不可重复。
			（sha te） 设置	
			

list.set(a,b);  将a b 的位置交换



Collection 接口中的方法：
	
	增加
		add			添加成功返回true，添加 失败返回false.
		addAll(Collection c)  把一个集合 的元素添加到另外一个集合中去。  
						c、b都是集合 --  c.addAll(b); --  将b添加到C中
	
	删除
		clear() 清空集合中的元素
		remove(Object o) 删除指定元素
		
		removeAll(Collection  c) 删除与c交集元素
		retainAll(Collection  c) 只保留与c交集元素
	
	查看
		size()    查看元素的个数

	
	判断
		isEmpty() 
		contains(Object o) 
		containsAll(Collection c) 
	
	迭代
		toArray()    遍历集合的元素
		iterator() （yite ruite）

	List

	Set
	
	
 
public class Demo2 {
	
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("令计划");
		c.add("徐才厚");
		c.add("周永康");
		System.out.println("添加成功吗？"+c.add("郭美美"));
		
		
		//创建集合
		Collection c2 = new ArrayList();
		c2.add("徐才厚");
		c2.add("郭美美");
		c2.add("狗娃");
	
		/*
		c.addAll(c2); // 把c2的元素的添加到c集合 中去。
		*/
		
		/*
		 删除方法:
		c.clear(); //clear()清空集合中的元素
		System.out.println("删除成功吗？"+c.remove("美美"));  // remove 指定集合中的元素删除，删除成功返回true，删除失败返回false.
		
		c.removeAll(c2); //删除c集合中与c2的交集元素。
		
		c.retainAll(c2); //保留c集合与c2的交集元素，其他的元素一并删除。
		*/
		System.out.println("查看元素个数："+c.size());
		
		System.out.println("集合的元素："+ c);
		
		
	}
	
}


-----------------------------------------------------------------------


判断
		isEmpty()				集合是否为空元素
		
		contains(Object o)		存在指定元素?
		
		containsAll(Collection c) 判断所有元素 是否相同   
								  可能要重写 equals 方法   



迭代
		toArray()    遍历集合的元素
		iterator()   返回iterator接口 实现类的对象

迭代器的作用：就是用于抓取集合中的元素。


迭代器的方法：
	hasNext()   问是否有元素可遍历。如果有元素可以遍历，返回true，否则返回false 。
 	next()    获取元素...
 	remove()  移除  迭代器最后一次返回 的元素。   没有返回就会报错



NoSuchElementException 没有元素的异常。 
出现的原因： 没有元素可以被迭代了。。。



public class llp{
	
	public static void main(String[] args) 
	{	Collection c = new ArrayList();       创建集合类的 实现接口
		c.add("令计划");
		c.add("徐才厚");
		c.add("周永康");
		System.out.println("判断集合是否为空元素"+c.isEmpty());
		
		System.out.println("判断集合是否为指定元素："+c.contains("徐才厚"));
		
		System.out.println("");
	
	
	
		System.out.println("Hello World!");
	}
}
-------------------------------------------------------------------------
class  Person
{	int id;
	String name;
	
	public Person(int id, String name){
	
		this.id=id;
		this.name=name;
	}
	
	重写 toString 更改下面输出的形式
	public String toString(){
	return "{编号："+this.id+"姓名："+this.name+"}";
	}

	public boolean equals(Object obj){
		Person p = (Person)obj;
		return this.id == p.id;

	}
	//java规范； 一般重写了equals方法  我们都会重写hashCode方法的
	public int hashCode(){
		return this.id;
	}
}




public class llp{
	
	public static void main(String[] args) {
		
		添加自定义元素
		Collection c =new ArrayList();
		c.add(new Person(110,"铁蛋"));
		c.add(new Person(119,"狗娃"));
		c.add(new Person(120,"狗省"));
		
		这里需要重写toString  不然会 只输出地址路径
		System.out.println("集合元素："+c);
		
		System.out.println("");
	
	}
	
}
----------------------------------------------------------------------

public class Demo2
{

public class void main(String[] args){
	
	Collection c = new ArrayList();
	c.add("小白");
	c.add("铁蛋");
	c.add("李白");
	c.add("东方不败");


	遍历集合的元素 
	Object[] arr = c.toArray();    //  把几何元素存放到Object 的数组中 返回
	for(int i = 0;i<arr.length ; i++){
		System.out.println(arr[i]+",");
	}



	使用iterator迭代器遍历
	Iterator it = c.iterator();   //返回一个迭代器    
/*	疑问：iterator()方法返回的是一个接口类型，为什么接口又可以调用方法可以使用呢？  
	
	iterator 实际 上返回的是iterator接口的实现类对象。
}
*/



/*
		while(it.hasNext()){ // hasNext() 问是否有元素可以遍历。
			System.out.println("元素："+ it.next()); //获取元素
		}
		
	
*/		

		it.next();
		it.next();
		it.remove();  //删除迭代器最后一次返回的元素。

		



		//清空集合 的元素
		while(it.hasNext()){
			it.next();
			it.remove();
		}
		
		System.out.println("集合的元素："+ c);
		
		
		
		
	}
	
}

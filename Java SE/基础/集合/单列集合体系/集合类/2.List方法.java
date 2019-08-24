Collection  (ke lashen)  中



List 特有方法：

特点：操作方法都有索引值， 只有List下面的集合类 才具备索引值 其他接口下面的集合类都没有索引值
	添加
		add(int index,E element)
		addAll(int index, Collection<? extends E> c)
	
	获取
		get(int index)
		indexOf(Object o)
		lastIndexOf(Object o )
		subList(int fromIndex, int toIndex)

	修改 
		set(int index, E element)  '交换位置
					a		b
	迭代
		listIterator()  List (yite ruite)



	List
		ArrayList	
		LinkedList



导包注意：集合类的所有类都在 （java.util） 包里


public class Demo{

	public static void main(String[] args){
	
		List list = new ArrayList();
		list.add("狗娃");
		list.add("狗剩");
		list.add("铁蛋");
		list.add("狗娃");
		
		/*
		//添加 1
		list.add(1,"赵本山");  // 把元素添加到索引值 位置上
		
		//添加 2
		List list2 = new ArrayList();
		list2.add("小白");
		list2.add("小黑");
		
		list.addAll(2,list2);// 把 list2的元素 添加到 list 的索引值位置上
		*/
		
		/*
		//获取的方法
		System.out.println("获取"+list.get(1));  // 根据索引值 获取集合中的元素
		//可用于遍历集合元素
		for(int i = 0 ;i<list.size();i++){
			System.out.println(list.get(i));		
		}
		*/
		/*
		System.out.println("找出指定元素第一次出现在集合中的索引值："+  list.indexOf("本山"));
		System.out.println("找出指定元素最后一次出现在集合中 的索引值："+list.lastIndexOf("狗娃"));
		List subList = list.subList(1, 4);  //指定开始 与 结束的索引值  	截取集合中的元素
		System.out.println("子集合元素是："+subList);
		*/
		/*
		//修改
		list.set(3, "李小阳");  //使指定元素替换索引值位置的  元素
		*/
	System.out.println("几何元素"+list );
	}
}


----------------------------------------------------------------------------------------------

迭代器



/*
迭代
	LIsiIterator()
	
	特有的方法有
	
	添加    (has pui li as)
		hasPrevious()  判断是否存在上一个元素
		previous()			获取上一个元素    当前指针先向上移动一个单位，然后再取出当前指针指向的元素
		(pui li as)	
		
		比较：  next();   先取出当前指针指向的元素，然后向下移动一个单位
	---------------------------------------------------	
		
		add(E e)		把当前元素插入当前指针  指向的位置  若有 next() 则指针移动到下一位    
		set(E e)		替代迭代器最后一次返回的 元素
*/
public class Demo{

	public static void main(String[] args){
	
		List list = new ArrayList();
		list.add("狗娃");
		list.add("狗剩");
		list.add("铁蛋");
		list.add("妹妹");
	
	ListIterator it = list.listIterator(); //返回的是一个List接口中特有的迭代器
	/*
	System.out.println("有上一个元素么？"+it.hasPrevious());
	System.out.println("获取上一个元素："+it.previous());  // 没有元素 会报错
	*/
	
	/*
	it.next();
	it.next();
	it.add("张三");   // next(); 会使指针移动一位
	*/
	
	it.next();
	it.next();
	it.set("张三");
	System.out.println("几何元素"+list );
	}
	
	
}





集合工具类：
	Collection  单列集合的根接口（注意区别：一个是根接口 一个是工具类）
	Collections	集合的工具类       
	（kela shen S）
-----------------------------------------------------


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


Collections 的常用方法：
	1.	对list进行二分查找：
		int binarySearch(list,key);
		int binarySearch(list,key,Comparator);
	
	2.对list集合进行排序。
		sort(list);  // 元素具备特性  会自动排序
		sort(list,comaprator);  // 自定义类型比较 要传入比较器
	
	3.对集合取最大值或者最小值。
		max(Collection)
		max(Collection,comparator)
		min(Collection)
		min(Collection,comparator)
	
	4.对list集合进行反转。
		reverse(list);  // 反转过程 不需要比较 就不用 传入comparator
	
	5.可以将不同步的集合变成同步的集合。
		Set synchronizedSet(Set<T> s)
		Map synchronizedMap(Map<K,V> m)
		List synchronizedList(List<T> list)



 // 数据具 有自然特性
public class Demo  {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
			
		list.add(1);
		list.add(10);
		list.add(2);
		list.add(6);
		list.add(8);
		//排序
		Collections.sort(list);
		System.out.println(list);
		
		//二分查找 要 先排序 在查找
		System.out.println("找的索引值是："+Collections.binarySearch(list, 2));
		System.out.println(list);
		
		//最大小值
		 System.out.println("最大值"+Collections.max(list));
		 System.out.println("最小值"+Collections.min(list));
		 System.out.println("集合元素："+list);
		
		//翻转
		Collections.reverse(list);
	
		list = (ArrayList<Integer>) Collections.synchronizedList(list);
		// 返回一个线程安全的 类型   ?
	}
}



'自定义类型数据'

class Person{
 	String name;
 	
 	int age;
 	
 	public Person(String name, int age){
 		this.name = name;
 		this.age = age;
 	}
 	public String toString(){
 	
 		return "{姓名："+this.name +"年龄："+this.age+"}";
 	}
 	
 }
// 自定义类型比较器
class AgeComparator implements Comparator<Person>{
	 public int compare(Person o1,Person o2){
	 		
	 		return o1.age - o2.age;
	 	}
}


public class Demo  {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<Person>();
	
	
		list.add(new Person("小白",7));
		list.add(new Person("小红",2));
		list.add(new Person("小光",16));
	
		
		
		Collections.sort(list,new AgeComparator());
		//二分查找 要 先排序 在查找    需要比较器
		System.out.println("找的索引值是："+Collections.binarySearch(list, new Person("小光",16),new AgeComparator()));
		System.out.println(list);
		
		//最大小值
		 System.out.println("最大值"+Collections.max(list,new AgeComparator()));
		 System.out.println("最小值"+Collections.min(list,new AgeComparator()));
		
		
	}}

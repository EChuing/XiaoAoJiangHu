
主要记住 List  的方法    

下面的  用的很少 可不记
 
 LinkedList 特有的方法：  （项目： 贪吃蛇 可用）
（linke lisiti ）		'当时为了扩展 却加多了 许多没用的方法  最后把重复的方法都加上来了（为了：有头有尾）'
	
	1：方法介绍
	            addFirst(E e)	把元素 添加到集合的首位
				addLast(E e)	把元素 添加到集合的末尾处
		
				getFirst()		获取集合中首位的 元素
				getLast()		获取集合中末尾的 元素
					
				removeFirst()	删除集合中首位的 元素 并返回
				removeLast()	删除集合中末尾的 元素 并返回
	
	
	2：数据结构
				1：栈 （1.6）  : 主要是用于实现堆栈数据结构的存储方式。
					先进后出
					
					push()		将元素插入列表开头处			//list.pubsh（"狗娃"）		
					pop()		移除首元素 并 返回集合中的第一个元素	
					（pa pou）	
				
				2：队列（双端队列1.5）： 主要是为了让你们可以使用 LinkedList 模拟队列数据结构的存储方式。
					先进先出
					offer()		把元素添加到集合的末尾处
					poll()		删除集合中的第一个元素 并 返回
					
	
	3：返回逆序的迭代器对象      
			
				descendingIterator()   返回逆序的迭代器对象
			

机试题目： 使用 LinkedList 实现堆栈的存储数据结构 （必须使用  LinkedList ）

堆栈数据 存储特点：	先进后出，后进先出		'U形瓶' 每次存放数据都是在顶部，出去的也是顶部优先
队列数据 存储特点：	先进先出，后进后出		'排队'	先来先进


------------------------------------------------------------------------------------------------------------------------
'需求:删除重复记录'

import java.util.ArrayList;
import java.util.Iterator;

class Book{
	int id;
	String name;  
	
	public Book(int id,String name){
	this.id = id;
	this.name = name;
	
	}
	
	// 	N1-重写 toString   与 equals配套
	public String toString(){
		return "{书号："+this.id+"书名："+this.name+"}";
	}
	public boolean equals(Object obj){
		Book book =(Book)obj;
		return this.id==book.id;
	}	
}


  
public class Demo{
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Book(110,"java编程思想"));
		list.add(new Book(220,"java核心技术"));
		list.add(new Book(330,"深入javaweb"));
		list.add(new Book(110,"java神书"));	
		
		ArrayList list2 = clearRepeat(list);
		System.out.println("新集合的元素是："+ list2);
	
	}
		
	public static ArrayList clearRepeat(ArrayList list){
		//创建一个新的集合
		ArrayList newList = new ArrayList();
		//获取迭代器
		Iterator it = list.iterator();
		while(it.hasNext()){
			Book book = (Book)	it.next(); 	//从旧集合中获取的元素
			if(!newList.contains(book)){   // N1:contains 比较的是内存地址  需要重写     toString();
				// 如果不包含这本书就存放在新的书籍里
				newList.add(book);
			}
		
		}
		return newList;
	}
}
---------------------------------------------------------------------------------------------------------------
//使用LinkedList模拟队列的存储方式
class TeamList{
	
	LinkedList list;
	
	public TeamList(){
		list = new LinkedList();
	}
	
	public void add(Object o){
		list.offer(o);
	}
	
	public Object remove(){
		return list.poll();
	}
	
	//获取元素个数
	public int size(){
		return list.size();
	}
	
}



public class Demo9 {
	
	public static void main(String[] args) {
		TeamList list=  new TeamList();
		list.add("李嘉诚");
		list.add("马云");
		list.add("王健林");
		
		int size = list.size();
		for(int i = 0 ; i<size ; i++){
			System.out.println(list.remove());
		}
		
		
	}
}

----------------------------------------------------------------
Collection
		|List
				|ArrayList
				|LinkedList
	'了解即可'	|Vector 	底层维护了一个  Object 类数组实现的，  与 ArrayList 是 一样的，
				(Vai kiute)	但是 Vector 是线程安全的，操作效率低
				 
		|Set

		
笔试： ArrayList 与  Vector 的区别
	相同： 底层都是使用了Object数组实现的
	
	不同：	ArrayList 	线程不同步		操作效率低  	jdk1.2出现
			Vector 		线程同步		操作效率低	jdl1.0出现    所有方法都带有 xxElement  
															(某某e liumen)

---------------------------------------------------------


需求：对下面 集合里的 年龄 排序

import java.util.LinkedList;


class Person{
	
	String name;
	
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	@Override 
	public String toString() {
		return "{ 名字："+ this.name+" 年龄："+ this.age+"}";
	}
	
}


public class Demo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Person("狗娃", 7));
		list.add(new Person("狗剩", 17));
		list.add(new Person("铁蛋", 3));
		list.add(new Person("美美", 30));
		
		//编写一个函数根据人的年龄及逆行排序存储。
			for(int i= 0 ; i<list.size() -1 ; i++){
			for(int j = i+1 ; j<list.size() ; j++){
				//符合条件交换位置
				Person p1 = (Person) list.get(i);
				Person p2 = (Person) list.get(j);
				if(p1.age>p2.age){  // 判断p1的年龄
					//交换位置
					list.set(i, p2);
					list.set(j, p1);
					
				}
			}
		}
		System.out.println(list);
		
		
		
	}
	
	
}





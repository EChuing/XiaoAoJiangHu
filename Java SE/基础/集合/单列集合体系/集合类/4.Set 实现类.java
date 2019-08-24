package cn.itcast;

import java.util.HashSet;

集合可以存储 对象  ， 任意类型的   且长度 可以任意增长
---------------------------------------------------------------------------------------


Collection
	|List
			|ArrayList
			|LinkedList
			|Vector
			
	|Set   实现了Set接口的集合类   特点无序 （添加上 不安顺序 ）不可重复
			|HashSet  底层使用哈希表来支持 ， 特点：存取 速度快       	存：根据哈希值，直接算出位置进行存放
				（哈希 shate）								取：得到哈希值，直接去哈希表查找取出
	
									
												
			|TreeSet  如果元素具备 自然排序的顺序  就会按照特性存储
				（qu shate）
				-- 下面有TreeSet方法的 讲解

	
				
	
List 和 Set 都有自己的方法 但是都一样   他们的实现类不同



HashSet：实现原理
		往HashSet添加元素（add），HashSet 调用 hashCode元素的哈希值，
		然后 哈希值的位运算 找出哈希表的 存储位置   

		1）如果算出元素存储 位置 没被存储 就会直接存储在该位置上
			'涉及哈希表的 桶式结构：  一个位置可以存放多个元素'
			
		2）如果算出改元素的存储位置存有其他元素了，
		那么就会调用该元素的equals方法 与该位置的元素
		再比较一次   	如果返回是true就 被视为重复元素
		不会被添加，如果equals 返回时false, 那么该元素就
		添加  
		
		equals 比较的是内存地址   ，所以若不想重复元素添加 需要
		重写HashCode 和 equals 方法
						



				
						add - HashSet - HashCode - equals - true 成功
														  - false 失败 





----------------------------------------------
public class Demo{
	
	public static void main(String[] args){
		HashSet set = new HashSet();
		set.add("小猪");
		set.add("小白");
		set.add("小红");
		set.add("小猪");
		System.out.println("输出："+set);
		
		// 利用不可重复的特点可以用于做 		输入密码
	}	
}

---------------------------------------------------
	（pe shan）
class Person{
	
	int id;
	
	String name;

	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	//重写 输出格式
	public String toString() {      
		return "{ 编号:"+ this.id+" 姓名："+ this.name+"}";
	}
	
	@Override
	//重写hashCode 比较的标准为 ID
	public int hashCode() {
		System.out.println("=======hashCode=====");
		return this.id;
	}
	
	
	@Override
	// 重写 equals 把比较的内存地址 改为 ID
	public boolean equals(Object obj) {
		System.out.println("======equals======");
		Person p = (Person)obj;
		return this.id==p.id;
	}
	
}

		set.add(new Peerson(100,"李白"));

public class Demo {
	
	public static void main(String[] args) {		
		HashSet set = new HashSet();
		//添加一个人  人有号码，和名字
		set.add(new Person(110,"狗娃"));		
		set.add(new Person(220,"狗剩"));
		set.add(new Person(330,"铁蛋"));
		//在现实生活中只要编号一致就为同一个人.
		System.out.println("添加成功吗？"+set.add(new Person(110,"狗娃")));
		System.out.println("集合的元素："+set);
		
	}
	
}
--------------------------------------------------------------
'疑问'
		比较：
		set.add("小白");
		set.add(new Person(110,"狗娃"));
		 同样是添加重复元素 为什么 new 的却要重写方法？
		

	
	
---------------------


treeSet添加自定义元素：

	注意：1）往TreeSet添加元素时，
			元素具备	自然排序特性，会自动按 	特性 	进行存储
			元素没有	自然排序特性，该元素的所属类必须要	实现Comparable接口，把元素的比较规则 定义在campareTo方法上
						（传入一个比较器）							（ken parui te）								（ken parui to）
		
		 2）如果比较元素时，compareTo方法返回的是0，那么该元素 被视为重复元素，不会被添加 
		 	判断的原则与 ：  TreeSet 、 HashCode 、 equals的方法 无关！
		 				有自己的 红黑树（二叉树）判断原则：  重复就不会被添加
		 
		 3）	往TreeSet添加元素时，如果元素本身没有具备自然排序的特性，也没有实现Comparable接口，那么就有在TreeSet创建的时候传入一个比较器			
		 		
		 			如何自定义比较器的格式： （自定义一个类， 实现Comparator接口就可，把元素与元素之间的比较规则定义在compare方法内即可） （ken parui te）
		 					class 类名 implements Comparator
		 					{
		 					
		 					}
-------------------------------------------------------------------------------------------------------------------			
TreeSet是可以对字符串进行排序， （字符串实现了 Comparable接口）

	字符串比较规则：
			1）可以找到对应不同的字符， 就比较 对应位置上不同的字符
			2）找不到对应 不用的字符，比较 字符串的长度
------------------------------------------------------------------------------------			
红黑树（二叉树）算法：  
			左小右大
			会自动排列树根 （n）：当n>=3、5、7、9（奇数） 会从新排列树根， 形成 左边小 右边大 （对称）

----------------------------------------------------------------------------------------


public class Demo{
	
	public static void main (String[] args){
		TreeSet tree = new TreeSet();
		tree.add(10);
		tree.add(1);
		tree.add(12);
		tree.add(7);
		tree.add(5);
		tree.add(2);  // 会自动排序
		
		tree.add('d');
		tree.add('a');
		tree.add('c');
		tree.add('b');
		
		System.out.println(tree);		
		// 字符和数字一起输出 会报错
	}
}
----------------------------------------------------

// 自带的比较器 
class  Emp implements Comparable<Emp>{
	
	int id;
	
	String name;
	
	int salary;

	public Emp(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		//	(Sda lenei)   薪水
	}
	
	@Override
	public String toString() {
		return "{ 编号："+  this.id+" 姓名："+ this.name+" 薪水："+ this.salary+"}";
	}

	//@Override //元素与元素之间的比较规则。  （kan pea to）
	// 负整数、零或正整数，根据此对象是小于、等于还是大于指定对象。 
	public int compareTo(Emp o) {
//		System.out.println(this.name+"compare"+ e.name);
		return this.salary- o.salary;
	}	
}


//// N1     实现自定义比较器 
class MyComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		return o1.id-o2.id;
	}
	
	//根据第一个参数小于、等于或大于第二个参数分别返回负整数、零或正整数。 
	/*@Override
	public int compare(Object o1, Object o2) {
		Emp e1 = (Emp) o1;
		Emp e2 = (Emp) o2;
		return e1.id - e2.id;
	}*/
	
	
}




public class Demo{
	
	public static void main(String[] args) {
		//创建一个比较器对象
		MyComparator comparator = new MyComparator();
		//创建TreeSet的时候传入比较器              N1    传入的东西写在（） 内
		TreeSet tree = new TreeSet(comparator);      


		
		tree.add(new Emp(110, "老陆", 100));
		tree.add(new Emp(113, "老钟", 200));
		tree.add(new Emp(220, "老汤", 300));
		tree.add(new Emp(120, "老蔡", 500));
		System.out.println("集合的元素："+tree);
		
	}
}

	
	
	
	
	
	
	
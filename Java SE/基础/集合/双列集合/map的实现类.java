------|Map 	
	(ma pe)
			|HashMap	底层基于哈希表实现的
			|TreeMap	TreeMap也是基于红黑树（二叉树）数据结构实现 的， 特点：会对元素的键进行排序存储。
			|Hashtable	（了解即可） 底层依赖了哈希表实现，也 HashMap ,但是 基于线程安全的   Jdk1.2
			（哈希 teibo）

-----------------------------------------------------------
| HashMap  底层也是基于哈希表实现 的。

HashMap的存储原理：
	往HashMap添加元素的时候，首先会调用键的hashCode方法得到元素 的哈希码值，然后经过运算就可以算出该
	元素在哈希表中的存储位置。 
	情况1： 如果算出的位置目前没有任何元素存储，那么该元素可以直接添加到哈希表中。   
	
	情况2：如果算出 的位置目前已经存在其他的元素，那么还会调用该元素的equals方法与这个位置上的元素进行比较
	，如果equals方法返回 的是false，那么该元素允许被存储，如果equals方法返回的是true，那么该元素被视为
	重复元素，不允存储。





class Person{
	
	int id;
	
	
	String name;


	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return  "[编号："+this.id+" 姓名："+ this.name+"]";
		
	}	
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	// 重写比较 方法
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		return this.id == p.id;   // 根据ID来比较
	}
}


public class Demo {
	
	public static void main(String[] args) {
		HashMap<Person, String> map = new HashMap<Person, String>();
		map.put(new Person(110,"狗娃"), "001");
		map.put(new Person(220,"狗剩"), "002");
		map.put(new Person(330,"铁蛋"), "003");
		map.put(new Person(110,"狗娃"), "007");  //如果出现了相同键，那么后添加的数据的值会取代之前 的值。
		System.out.println("集合的元素："+ map);
		
		
		
	}
	
}
---------------------------------------------------------

----------------| TreeMap   TreeMap也是基于红黑树（二叉树）数据结构实现 的， 特点：会对元素的键进行排序存储。

TreeMap 要注意的事项：

	1.  往TreeMap添加元素的时候，如果元素的键具备自然顺序，那么就会按照键的自然顺序特性进行排序存储。
	2.  往TreeMap添加元素的时候，如果元素的键不具备自然顺序特性， 那么键所属的类必须要实现Comparable接口，
		把键的比较规则定义在CompareTo方法上。
	
	3.	往TreeMap添加元素的时候，如果元素的键不具备自然顺序特性，而且键所属的类也没有实现Comparable接口，
		那么就必须在创建TreeMap对象的时候传入比较器。
	

----------------| Hashtable 
*/
class Emp {//implements Comparable<Emp>{
	
	String name;
	
	int salary;

	public Emp(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "[姓名："+this.name+" 薪水："+ this.salary+"]";
	}

/*
	@Override
	public int compareTo(Emp o) {
		return this.salary - o.salary;
	}*/
	
}


//自定义一个比较器
class MyComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp o1, Emp o2) {
		return o1.salary - o2.salary;
	}
	
}




public class Demo6 {
	
	public static void main(String[] args) {
	/*	TreeMap<Character, Integer> tree = new TreeMap<Character, Integer>();
		tree.put('c',10);
		tree.put('b',2);
		tree.put('a',5);
		tree.put('h',12);
		System.out.println(tree);*/
		
		//创建一个自定义比较器
		MyComparator comparator = new MyComparator();
		
		TreeMap<Emp, String> tree = new TreeMap<Emp, String>(comparator);
		tree.put(new Emp("冰冰", 2000),"001");
		tree.put(new Emp("家宝", 1000),"002");
		tree.put(new Emp("习总", 3000),"003");
		tree.put(new Emp("克强", 5000),"005");
		
		tree.put(new Emp("财厚", 5000),"008");  出现 键 重复时，键不会被更改，值 会被后者 覆盖
		System.out.println(tree);
		
		
		
		
	}

}

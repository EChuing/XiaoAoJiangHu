集合类
	单例集合类
	Collection 
		|List 有序可重复
			 ArrayList	底层Object数组   查询快	增删慢     '查询速度快（内存地址连续），增删慢（原数组复制到新数组中）
			 LinkedList	底层链表结构	  查询慢	增删块		'|  数据  |  下一个第内存地址 |'		
			 Vector		底层和 ArrayList 一样		(Vai kiute)	但是 Vector 是线程安全的，操作效率低
		|Set 无须不可重复
			 HashSet		底层用哈希表    存取速度快
			 TreeSet		二叉树

	双例集合
	Map <键,值>		
		|HashMap	底层基于哈希表实现的
		|TreeMap	TreeMap也是基于红黑树（二叉树）数据结构实现 的， 特点：会对元素的键进行排序存储。
		|Hashtable	（了解即可） 底层依赖了哈希表实现，也 HashMap ,但是 基于线程安全的   Jdk1.2
	（哈希 teibo）






Collection 单利集合基本 方法

			添加
				add
				addAll
			删除
				clear 清空集合中的元素
				remove 删除指定元素  
			查看
				size	查看元素个数
			判断
				isEmpty		集合是否为空元素
				contains	存在指定元素
				containsAll	重复元素？      需要重写 equals方法、hashCode
			迭代
				toArray		遍历集合元素
				iterator	返回iterator接口  实现类的对象



public class Demo{

	public static void main（String[] args）{
	
		Collection c1 = new ArrayList();
		c1.add("添加元素");
		

		Collection c2 = new ArrayList();
		c2.add("添加元素");
		

		c2.addAll(c1); 将c1元素添加到c2中


		c.clear();  清空集合中的元素
			


		
	}
}
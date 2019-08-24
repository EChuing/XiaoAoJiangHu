





Collection 单例集合
	|List 	有序 可重复
		|ArrayList  数组结构    查询快，增删慢
		|LinkedList 链表结构    查询慢，增删快
  了解 |Vector  	Object数组结构  线程安全的 操作效率低	
	|Set		无序 不可重复
		|HashSet	哈希表  	存取块	
			HashSet - hashCode(查哈希值,位运算) - 没有，就存储 
												  - 有，调用equals 比较	
		|TreeSet	二叉树		按元素特性会自动排列
			具备自动排序
			不，实现Comparable接口，
				元素的比较规则定义在campareTo方法上
			不具备页不实现接口，需 在TreeSet创建的时候传入一个比较器
	泛型
		|interface 接口名<声明自定义泛型>{  }
		| 泛型的上下限
	Collections 集合的工具类

Map	双列集合   <键，值>  值可以重复
		|HashMap	哈希表
			HashSet - hashCode(查哈希值,位运算) - 没有，就存储 
												  - 有，调用equals 比较	
		|TreeMap	二叉树
  了解 |Hashtable	哈希表  线程安全的








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





  Map接口的方法：
 	
 	添加：
 		put(K key, V value) 
 		putAll(Map<? extends K,? extends V> m) 
 	
	

 	删除
 		remove(Object key) 
 		clear() 

 	获取：
 		get(Object key) 
 		size() 
 	
 	判断：
 		containsKey(Object key) 
 		containsValue(Object value) 
 		isEmpty()
 		
 		
 		迭代：
 			keySet()	只返回键
 			values()	只返回值
 			entrySet()  遍历map集合
'java.util 集合类 

			|单例集合 Collection     
							|List    
								|ArrayList	
								|LinkedList
							|Set

			|双例集合 Map
							|HashMap
							|TreeMap
							|Hashtable

-----------------------------------------------------------------------					
Collection 接口中的方法；

	添加：
			add		添加成功 返回 true
			addAll	listA.addAll（listB） 将 listB 添加到 listB 中

	删除：
			clear()	清空集合中的元素
			remove()删除指定元素
			
			removeAll()	删除与索引值交集的元素
			retainAll()	只保留与索引值交集的元素

	查看：
			isEmpty()	 集合是否为空
			contains()	 是否存在索引值元素
			containsAll()判断所有元素是否相同  可能要重写equals()

	迭代：（抓取集合中的元素）
			toArray()	遍历集合元素
			iterator()	返回iterator接口实现类的对象
	
	迭代器的方法：
			hasNext()	是否有元素可以遍历  返回 true false
			next()		获取元素
			remove()	移除迭代器最后一次返回的元素 没就报错

NoSuchElementException 没有元素的异常。 
出现的原因： 没有元素可以被迭代了。。。






'单例集合：  Collection      
					

----------|List  有序，可重复       （自动排序，可以重复添加）
---------------|ArrayList	底层 Object 数组实现  ； 查询快，增删慢
						多查询时使用
---------------|LinkedList 底层 链表数据结构 实现 ；查询慢，增删快
				
						--------------------------------
						|  数据  |  下一个内存地址  |
						-------------------------------- 
---------------|Vector 和 ArrayList一样 ； 线层安全的，操作效率低
				（Vai kiute）




				List list = new ArrayList();

List 特有方法：				（ 主要 ）

		特点:都有索引值，List下面的集合类都可以用  其他下面接口的集合类没有索引值  （没总结过）

		
		添加：	add(1,"赵本山") // 把元素添加到索引值 位置上
				addAll(B,A)      //	交换A B的位置

		获取：	get（1）				// 获取索引值元素
				indexOf("A")		//索引中出现次数
				LastIndexOF（"A"）	//索引中最后一次出现
				subList（1,4）		//截取中间的元素

		修改：	
				set（1，"李阳"）		//据索引中修改 元素

	迭代：   
	listIterator ()特有方法；
		
				hasPrevious()		//是否存在上一个元素
				previous()			//获取上一个元素   没元素会报错
				' 区别： 
				'			previous	指针上移一个单位  后取出元素
				'			next		取出元素  后指针下移一个单位
							
				add()		把当前元素插入当前指针  指向的位置  若有 next() 则指针移动到下一位    
				set()		替代迭代器最后一次返回的 元素


LinkedList 方法  （ 少用，有很多都是重复的 ）
		
"都是集合中使用
		
		添加：
			addFirst（）	添加元素到首部
			addLast（）	添加元素到末尾处
		
		获取：
			getFirst（）	获取首位元素
			getLast（）	获取末尾元素

		删除：
			removeFirst（）	删除首位元素
			removeLast（）	删除末尾元素


		还有数据结构，迭代的方法  略！！！！！！！！！！！！


----------|Set 无序，不可重复  （不会自动添加，不可以重复添加）
---------------|HashSet  底层 哈希表实现 ； 存取快  
						取：根据哈希值，直接查找
---------------|TreeSet 如果元素具备 自然排序的顺序  就会按照特性存储



HashSet :实现原理
		
	往 HashSet 添加元素（add），调用 hashCode元素的哈希值，
	哈希值 位运算， 找出哈希表存储位置。
	
	1）如果算出元素存储 位置 没被存储 就会直接存储在该位置上
	
	'涉及哈希表的 桶式结构：一个位置可以存放多个元素  先进先出
						
	2）如果算出改元素的存储位置存有其他元素了，
	那么就会调用该元素的equals方法 与该位置的元素
	再比较一次   	如果返回是true就 被视为重复元素
	不会被添加，如果equals 返回时false, 那么该元素就
	添加  
	
	equals 比较的是内存地址   ，所以若不想重复元素添加 需要
	重写HashCode 和 equals 方法
	


HashSet 添加元素
	添加-位运算，算出哈希值-看是否重复元素	-无元素-存入
												-有元素-调用equals比较内存地址	-不同-存入
																					-相同-失败
	add - HashSet - HashCode - equals - true	成功
									  - false	失败 




TreeSet 添加自定义元素：

	注意：1）往TreeSet添加元素时，
			元素具备	自然排序特性，会自动按 	特性 	进行存储
			元素没有	自然排序特性，该元素的所属类必须要	实现Comparable接口，把元素的比较规则 定义在campareTo方法上
																	（看pe啊 bo）							（kan pe a to）	
		
		 2）如果比较元素时，compareTo方法返回的是0，那么该元素 被视为重复元素，不会被添加 
		 	判断的原则与 ：  TreeSet 、 HashCode 、 equals的方法 无关！
		 				有自己的 红黑树（二叉树）判断原则：  重复就不会被添加
		 
		 3）	往TreeSet添加元素时，如果元素本身没有具备自然排序的特性，也没有实现Comparable接口，那么就有在TreeSet创建的时候传入一个比较器			
		 		
		 			自定义比较器： （自定义一个类， 实现Comparator接口，比较规则定义在compare方法内即可）

					class 类名 implements Comparator
					{
					}



流程：
		添加-判断是否具备自然特性	- 存在-安特性自动存储
										- 不存在 - 实现 Comparable 接口 - 在 campareTo 方法上定义
												  - 不实现接口 - 需要在 TreeSet 创建时传入一个比较器
													

红黑树（二叉树）算法：  
			左小右大
			会自动排列树根 （n）：当n>=3、5、7、9（奇数） 会从新排列树根， 形成 左边小 右边大 （对称）


TreeSet 是可以对字符串进行排序， （字符串实现了 Comparable接口）

	字符串比较规则：
			1）可以找到对应不同的字符， 就比较 对应位置上不同的字符
			2）找不到对应 不用的字符，比较 字符串的长度





'习题：使用过三种方式遍历集合的元素

第一种:使用get方法遍历
第二种：使用迭代器正序遍历	hasNext		
第三种：使用迭代器逆序遍历	hasPrevious

------------------------------------------------------
' 数组和集合的 区别

都是容器：

数组长度是固定的，
集合长度是可变的。

数组中可以存储基本数据类型，
集合只能存储对象数组中存储数据类型是单一的   ？
集合中可以存储任意类型的对象。
------------------------------------------------------



'双例集合：  Map
					解决 键-值 类问题  （ 一对多 关系 ）
						  K     V
						老公  老婆
						钥匙   锁

Map 接口方法：
		
		Map<String,String> map = new HashMap<String,String>();
		
		添加：
			map.put("谢霆锋", "张柏芝"); //添加 键-值
			map.putAll(map2);	//把 map2 元素 添加到 map 集合中
		
		删除：
			map.remove("汪峰"));// 删除 键对应的一条数据  返回 对应的 值       因为：  键是唯一  且确定一条数据 ， 值是可以重复的
			map.clear();		//清空集合中的所有数据。

		获取
			map.get("文章")	//根据指定的键 获取对应的值
			map.size()//判断map集合键值对的个数
		
		判断
			map.containsKey("文章")	//判断map集合是否包含指定的键
			map.containsValue("张柏芝")//判断map集合是否包含指定的值
			map.isEmpty()// 注意 null=null 也是一个键值对 ，判断map集合是否包含指定的键
		
		
		迭代：
			keySet()	只返回键
			values()	只返回值
			entrySet()	遍历map集合

三种遍历方法：
	//map集合中遍历方式一： 使用keySet方法进行遍历       缺点： keySet方法只是返回了所有的键，没有值。 
	Set<String> keys = map.keySet();  //keySet() 把Map集合中的所有键都保存到一个Set类型 的集合对象中返回。
	Iterator<String> it = keys.iterator();
	while(it.hasNext()){
		String key = it.next();
		System.out.println("键："+ key+" 值："+ map.get(key));
	}
	
	
	
	//map集合的遍历方式二： 使用values方法进行 遍历。    缺点： values方法只能返回所有 的值，没有键。
	Collection<String>  c = map.values(); //values() 把所有的值存储到一个Collection集合中返回。
	Iterator<String> it = c.iterator();
	while(it.hasNext()){
		System.out.println("值："+ it.next());
	}
	*/
	
	//map集合的遍历方式三： entrySet方法遍历。
	Set<Map.Entry<String,String>>  entrys = map.entrySet(); 
	Iterator<Map.Entry<String,String>> it = entrys.iterator();
	while(it.hasNext()){
		Map.Entry<String,String> entry = it.next();
		System.out.println("键："+ entry.getKey()+" 值："+ entry.getValue());
	}

----------|Map
---------------|HashMap 底层 哈希表实现
---------------|TreeMap 底层 红黑树数据结构实现 对元素的键进行排序
---------------|Hashtable （了解） 和 HashMap 一样 ’线层安全的

      

HashMap 的存储原理：
	往HashMap添加元素的时候，首先会调用键的hashCode方法得到元素 的哈希码值，然后经过运算就可以算出该
	元素在哈希表中的存储位置。 
	情况1： 如果算出的位置目前没有任何元素存储，那么该元素可以直接添加到哈希表中。   
	
	情况2：如果算出 的位置目前已经存在其他的元素，那么还会调用该元素的equals方法与这个位置上的元素进行比较
	，如果equals方法返回 的是false，那么该元素允许被存储，如果equals方法返回的是true，那么该元素被视为
	重复元素，不允存储。


---------------双例集合工具类：：：：：：





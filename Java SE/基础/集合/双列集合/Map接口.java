
import java.util.HashMap;
import java.util.Map;



现实生活中有些数据是成对存在的
	民政局
		建 		值
		-----------
		老公  		老婆
		身份证 	人
		一把钥匙	锁

双列集合： 数据成对存在
------|Map 	实现了Map接口的集合类，存储的数据都是以  建值对的形式， 建不可重复，值可以
	(ma pe)
			|HashMap
			|TreeMap
			|Hashtable

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



public class Demo{
	public static void main(String[] args){
		Map<String,String> map = new HashMap<String,String>();
		map.put("汪峰", "章子怡");
		map.put("文章", "马伊琍");
		map.put("谢霆锋", "张柏芝");
		System.out.println("返回值："+map.put("谢霆锋", "王菲"));  //返回之前对应的值
		System.out.println("输出："+map);
	
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("习总", "彭丽媛");
		map.putAll(map2);// 把 map2 元素 添加到 map 集合中
		
		
		// 删除
		System.out.println("删除元素："+map.remove("汪峰"));// 删除 键对应的一条数据  返回 对应的 值       因为：  键是唯一  且确定一条数据 ， 值是可以重复的
		map.clear();//清空集合中的所有数据。
		
		//获取
		System.out.println("根据指定的键 获取对应的值："+map.get("文章"));//根据指定的键 获取对应的值
		System.out.println("判断map集合键值对的个数："+map.size());//判断map集合键值对的个数
		
		//判断
		System.out.println("判断map集合是否包含指定的键："+map.containsKey("文章"));//判断map集合是否包含指定的键
		System.out.println("判断map集合是否包含指定的值："+map.containsValue("张柏芝"));//判断map集合是否包含指定的值
		System.out.println("判断map集合是否为空："+map.isEmpty());// 注意 null=null 也是一个键值对 ，判断map集合是否包含指定的键
		
		System.out.println("集合元素："+map);
	}
	
	
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------

	迭代：
 			keySet()	只返回键
 			values()	只返回值
 			entrySet()  遍历map集合
 			 


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class Demo3 {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String, String>();
		//添加方法
		map.put("汪峰", "章子怡");
		map.put("文章", "马伊琍");
		map.put("谢霆锋","张柏芝");
		map.put("成龙", "林凤娇");
		/*
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
		
	}
	
	

}

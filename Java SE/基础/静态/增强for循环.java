
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.*;




(yi tebo)
Iterator   
 
 jdk1.5  出现
 
 
 
 增强for循环的作用：   
 
 		
 		简化迭代器的书写格式
		（注意： 增强for循环 底层还是使用类迭代器遍历的）
 
 增强 for循环的使用范围  ：
 	
 		如果是实现类 Iterable 接口的对象或者 是 数组对象都可以 增强for循环

 foreach  （fo yiqu）
 
 格式：		 接收的 变量名		
 		for（变量类型 变量名 ： 遍历的目标）{
 		
 		}

注意：（增强for循环）
		1.	底层使用迭代器获取的，  获取迭代器由JVM完成
			所以不可以使用集合对象对集合的元素进行修改
		2.	迭代器遍历元素 	与	增强for循环变量元素		的区别:
					用迭代器遍历元素可以 删除集合的元素
					用增强for循环遍历集合元素时	不可以使用remove方法 删除集合元素
		3.		普通for循环 没有便利的目标
		 		增强for循环一定要有便利的目标
		4.	





public class Demo{
	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); 
		


		
		
		//添加元素
		set.add("狗娃");
		set.add("狗剩");
		set.add("铁蛋");
		
		//使用迭代器 遍历Set的集合
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println("元素："+it.next());	
		//遍历集合元素
		// 使用增强for循环
		for(String item:set){
			System.out.println("元素："+item);
			//set.remove("狗剩");  // 不可以使用集合对象
		}








		int[] arr = {12,5,6,1};



		// 遍历数组
		for(int i = 0 ; i < arr.length ; i++){
			System.out.println("数组："+ arr[i]);
		}
		for(int item : arr){
			System.out.println("元素："+ item);
		}
		
		//输出5句 “Holl World”
		for(int i = 0 ; i<5 ; i++){
			System.out.println("Holl World");
		}
		//用for( : ) 不简单
		
		
		
		
		



		
		//双列集合 变 单列集合
		// Map集合没有实现Iterable接口，所以不能自己使用增强for循环， 需要借用Collection集合
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("001","张三");
		map.put("002","李四");
		map.put("003","王五");
		map.put("004","老六");
		// 转换
		Set<Map.Entry<String,String>> entrys = map.entrySet();
		for(Map.Entry<String,String> entry : entrys){
			System.out.println("键:"+entry.getKey()+"值:"+entry.getValue());
		}
		
		
	}
	
}
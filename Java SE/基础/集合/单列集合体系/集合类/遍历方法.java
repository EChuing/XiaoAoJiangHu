
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
练习：使用过三种方式遍历集合的元素
第一种:使用get方法遍历
第二种：使用迭代器正序遍历	hasNext		
第三种：使用迭代器逆序遍历	hasPrevious


迭代器：
 */

public class Demo{
	
	public static void main(String[] args){
		
		List list = new ArrayList();
		list.add("张三");
		list.add("李四");
		list.add("黄五");

		System.out.println("=====get遍历=====");
		for(int i = 0; i<list.size();i++){
			System.out.println(list.get(i)+",");
			
		}
		//指针上至下
		System.out.println("=====迭代器正序遍历=====");
		ListIterator it = list.listIterator(); 
		while(it.hasNext()){   // 判断是否可以遍历   
			
			System.out.println(it.next()+",");		// 遍历 it 数组
			
		}
		// 指针下至上
		System.out.println("=====迭代器逆序遍历=====");
		while(it.hasPrevious()){   //hasPrevious  判断是否存在上一个元素      多用在判断  （没用会报错） 
			// 在it 的基础 逆序回来  若用新的注意 指针位置
			System.out.println(it.previous()+",");
		}
	}
}


import java.util.ArrayList;
import java.util.Collections;



jdk1.5 新特性  ----  静态导入

静态导入的作用： 简化书写


格式：
	import static 包名.类名.静态的成员；


注意：
	如果 静态导入的成员与本类的成员 存在同名的情况下，
	那么默认使用本类的静态成员，如果需要指定的静态导
	入的成员，那么需要在  静态成员前面加上类名
	




<yi po>
import

静态导入

导入指定
		import static java.util.Collections.sort;
		import static java.util.Collections.binarySearch;
		import static java.util.Collections.max;
导入所有
		import static java.util.Collections.*;	
		
		
		import static java.lang.System.out;
		//输出 只用写 out.println("xxxxxxx");


public class Demo{
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(10);
		list.add(15);
		list.add(17);
		list.add(14);
		
		
		sort(list);
		// 指定导入写法
		Collections.sort(list);
		System.out.println("集合元素："+list);
		System.out.println("索引值："+binarySearch(list,14));
		
			   out.println("最大值："+max(list));
		
		
	}
	// 本类  优先调用
	public static void sort(ArrayList<Integer> list){
		System.out.println("本类的sort方法....");
			
		
	}
	
}
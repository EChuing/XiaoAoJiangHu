
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/*
注意：
 
 迭代器在变量元素的时候要注意事项： 在迭代器迭代元素 的过程中，不允许使用集合对象 改变集合中的元素 个数，如果需要添加或者删除只能使用迭代器的方法进行操作。
 
 如果使用过了集合对象改变集合中元素个数那么就会出现ConcurrentModificationException异常。	
 
 
 迭代元素 的过程中: 迭代器		创建到    使用结束的时间。
 
 ‘迭代器中改变集合 的 元素 个数 会报错  ，只可以使用迭代器的方法修改’
 */

public class Demo {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("张三");
		list.add("李四");
		list.add("王五");
		
		ListIterator it = list.listIterator();	//获取到迭代器
		/*
	 	while(it.hasNext()){
			System.out.print(it.next()+",");
			//it.add("aa"); // 元素添加到当前指针 就 先后移一位 使得输出结果 没有添加的元素
			
			/*
			//迭代器中改变集合 的 元素 个数 会报错  ，只可以使用迭代器的方法修改
			list.add("aa");  // add方法是把元素添加到集合的末尾处的。
			list.remove("张三");
			*/
		}
		*/
		
		/*
		list.add("aa");// 集合对象改变集合元素 和面不可以跟迭代语句    会报错
		//it.next();
		*/
		
		
		System.out.println("\r\n集合的元素："+ list);
	}

}

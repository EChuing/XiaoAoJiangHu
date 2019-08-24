
import java.util.Arrays;
import java.util.List;


Arrays:

	二分查找，数组需有序
		binarySearch(int[])
		binarySearch(double[])
	
	数组排序
		sort(int[])
		sort(char[])
	
	将数组变成字符串
		toString(int[])
-------------------------------------上面的前面有		
	
	
	1. 复制数组
		copyOf(boolean[] original,int newLength)
					原 数组		新 数组长度
					
	2. 复制部分数组
		copyOfRange(boolean[] original,int from, int to)
					original	原数组
					from		开始拷贝的索引值
					to			结束的索引值
					
	2. 比较两个数组的元素 	是否相同	（判断数组对应位置 的 元素 是否完全一样）
		equals(int[],int[])
		(e kous)
	
	3. 将数组变成集合
		List asList(T[])
		
		

public class Demo{
	public static void main(String[] args){
		
	
		
		Integer[] arr = {10 ,8 ,6 , 9 };
		//复制全部数组
		Integer[] arr2 = Arrays.copyOf(arr,6);// 将arr 复制到 长度为6 的 arr2 里   多出的 长度 为 null
		System.out.println("拷贝后的数组:"+Arrays.toString(arr2));
		
		// 复制部分数组  	包头	不  包尾
		Integer[] arr3 = Arrays.copyOfRange(arr, 1, 5);
		System.out.println("arr3拷贝的数组："+Arrays.toString(arr3));
		
		System.out.println("判断两个数组的元素 是否一致:"+Arrays.equals(arr, arr2));
		//依据是 数组 对应位置的  元素 是否  一致
	
		//数组变 集合
		List<Integer> list = Arrays.asList(arr); 
		System.out.println("集合的元素"+ list);
		
		//数组变 集合 toArry
	}
	
	
}

目前有数组 " int[] arr ={11,2,4,2,10,11};",

"定义一个函数清空该数组的重复元素，返回非重复的数组

分析： 
		1.确定新数组长度    原数组的长度-重复元素的个数

import java.util.*;
class  Love16
{
	public static void main(String[] args) 
	{
		int[] arr ={11,2,4,2,10,11};
		arr = clearRepeat(arr);
		System.out.println("清空 重复元素！"+Arrays.toString(arr));
	}
	public static int[] clearRepeat(int[] arr){
		//遍历
		//计算重复元素的格式
		int count = 0; //记录重复元素
		for (int i =0 ; i < arr.length-1 ; i++ )
		{	for (int j = i+1 ; j < arr.length ; j++)
			{	if (arr[i]==arr[j])
				{	count++;
					break;
				}
			}
		}
	
	
	// 新数组长度
	int newLength = arr.length - count;
	//创建新数组
	int[] newArr = new int[newLength];
	int index = 0; //新数组的索引值

	//遍历旧数组
		for(int i = 0 ; i< arr.length ; i++)
		{
		int temp = arr[i]; //就数组中的元素
		boolean flag = false;//默认不是重复元素
		//新旧数组比较
		for (int j=0;j<newArr.length ; j++)
		{	if(temp == newArr[j])
			{
				flag = true;
				break;
			}
		}
		if(flag = false ){
			newArr[index++] = temp;
		}
	}
	return newArr;
	}

}

//--------------------------------------------------------------
//--------------------------------------------------------------

11.目前有数组” int[] arr =  {11,2, 4, 2, 10, 11}，
定义一个函数清除该数组的重复元素，返回的数组存储了那些非重复的元素而且数组不准浪费长度。

分析：
	1. 确定新数组的长度。  原数组的长度-重复元素个数



import java.util.*;
class Love16 {

	public static void main(String[] args) 
	{
		int[] arr =  {11,2, 4, 2, 10, 11};
		arr = clearRepeat(arr);
		System.out.println("清除重复元素的数组："+ Arrays.toString(arr));
	}

	public static int[] clearRepeat(int[] arr){
		//先计算出重复元素的格式:
		int count = 0; //记录重复元素的个数
		for(int i = 0 ; i < arr.length-1 ; i++){
			for(int j = i+1 ; j<arr.length ; j++){
				if(arr[i]==arr[j]){
					count++;
					break;
				}
			}
		}
		
		//新数组 的长度
		int newLength = arr.length - count;
		//创建一个新的数组
		int[] newArr = new int[newLength];

		int index = 0 ; 	//新数组的索引值

		
		//遍历旧数组
		for(int i = 0  ; i< arr.length ; i++){
			int temp = arr[i];  //旧数组中的元素 
			boolean flag = false;  //默认不是重复元素
			
			
			//拿着旧数组 的元素 与新数组的每个元素比较一次。
			for(int j = 0 ; j< newArr.length ; j++){
				if(temp==newArr[j]){
					flag = true;
					break;
				}
			}
			
			if(flag == false){
				newArr[index++] = temp;
			}
		}
		
		return newArr;
	}
	
}
//-----------------------------------------------------------------
//------------------------------------------------------------------

   接收int[] arr = {0, 0, 12, 1, 0, 4, 6, 0} 
   然后新建一个数组 把0 除去。

   "统计零的个数 重新排列不含零的数组


import java.util.*;
class  Love3
{
	public static void main(String[] args) 
	{
		int[] arr = {0, 0, 12, 1, 0, 4, 6, 0};
		//clearZero(arr);
		arr = clearZero(arr);
		System.out.println("数组元素："+ Arrays.toString(arr));
	}

	public static int[] clearZero(int[] arr){
		//统计0的个数
		int count = 0; //定义一个变量统计0的个数
		for(int i = 0; i<arr.length; i++){
			if(arr[i]==0){//判断数组=0  不能是 i 。
			   count++;
			}
		}
		System.out.println("零的个数是："+ count);
	   //创建一个新的数组
	   int[] newArr = new int[arr.length-count];


	   int index = 0; //新数组存储的索引值
	   //把非零数据存入数组中
	   for(int i = 0; i<arr.length; i++){
		   if(arr[i]!=0){
			   newArr[index] = arr[i];
			   index++;//确保新索引值可以自动滚动
		   }
	   }return newArr;
	}
}

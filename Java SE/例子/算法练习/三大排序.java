
//--------------------------巩-固----------------------------


//------------------直接排序发----------最大的放在前面----------------


class  lianxi
{
	public static void main(String[] args) 
	{
		int[] arr = {10, 7, 55, 2, 30, 14, 28, 6};
		Thing(arr);
	}
	//数组 选择排序排序 
	public static void Thing(int[] arr){
		// 把最大的放在最前面
		for(int i = 0; i<arr.length-1;i++){
			for(int j = i+1; j<arr.length; j++){
				if (arr[i] < arr[j])
				{	int max = arr[j];
				    arr[j] = arr[i];
					arr[i] = max;
				}
			}
		}	for (int i = 0;i<arr.length ;i++ )
			{	System.out.println("arr数组："+ arr[i]);	
			}
			
	}
}
//-----------------------冒泡排序法------最小的放在前面------------------------

 
class lianxi
{	public static void main(String[] args)
	{  
		int arr[] = {10, 7, 55, 2, 30, 14, 28, 6};
		Thing(arr);
	}
		//数组 冒泡排序
	public static void Thing(int[] arr){
		for (int i = 0;i<arr.length-1 ;i++ ){	
			for (int j = i+1;j<arr.length ;j++ ){	
				if ( arr[i]>arr[j] ){	
					int min = arr[j];
					arr[j] = arr[i];
					arr[i] = min;
				}
			}
		}	 
		for (int z = 0; z<arr.length ; z++ )
		{	System.out.println("数组："+ arr[z]);
		}
	}
	
}

//------------------------二分查找--------------------------------------------
 
//   --------------------- 有序数组  ， 索引值 ---------------------------------
class  lianxi {
	
	 public static void main(String[] args){

	 	int arr[] = {1，3,5,7,9,11,13,15};  //一定是有序
	 	int dofors = Thing(arr, 28);
	 	System.out.println("元素所在的索引值是："+ dofors); //? 为什么会显示6 在哪里统计了
	 }
	 	
		// 用 需查找的值 与 数组中间值 比较 
	 public static int Thing(int arr[], int APP){	
		int max = arr.length-1;
 		int min = 0;
 		
 		while ( max>=min ){	   // 注意这里一定要 》=
 			int i = (max + min)>>>1;//>> 右位移一位（除以2）   >>> 无符号
 			int mid=arr[i];
			
			if (APP > mid){
 				min = i + 1;
 			}else if(APP < mid){
 				max = i - 1;
 			}else{	//APP = arr[mid]
 				return i;//  因为： 最后的返回值为索引值
			}
 		}
 		return -1;
	}

}
//-----------------------------------------------------------------------------
class  Hole
{  public static void main(String[] args)
   {  
      int[] arc = {15, 19, 7, 5, 2, 0, 1, 3, 14 };     
      int max = diaoYong(arc);
      System.out.println("最大值："+ max );
   }    
   public static int diaoYong(int[] arc)
   {
      int max = arc[0];
      for(int i=0; i<arc.length; i++)
      {  if(arc[i]>max)
         {  max = arc[i];
         } 
      }
      return max; 
   }//System.out.println("最大值："+ max );  函数在return 时就结束 强行输出会报错
}   
顺序查找 （线性查找）  特点：效率低
	从 查找表的最后一个元素 逐个查找 
 



二分查找 （折半查找） 特点：查找速度快，平均性能好
	
	注：给定的表格 要有序的   date是查找的值
	
	static int funBinSearch(int[] array, int date){
	
		int min = 0;
		int max = array.length - 1;

		while(min <= max){
			//中间值
			int mid = (min + max)>>>2; // >>>无符号 二进制右移一位 （除以2）
			
			if(data < array[mid]){//比中间值 小了
				max = mid ;
			}else if(data > array[mid]){
				min = mid ; 
			}else{  //data == array[mid]
				return mid ; 
			}
		}
		return -1;  // max<min   没有找到
	}

//--------------------------��-��----------------------------


//------------------ֱ������----------���ķ���ǰ��----------------


class  lianxi
{
	public static void main(String[] args) 
	{
		int[] arr = {10, 7, 55, 2, 30, 14, 28, 6};
		Thing(arr);
	}
	//���� ѡ���������� 
	public static void Thing(int[] arr){
		// �����ķ�����ǰ��
		for(int i = 0; i<arr.length-1;i++){
			for(int j = i+1; j<arr.length; j++){
				if (arr[i] < arr[j])
				{	int max = arr[j];
				    arr[j] = arr[i];
					arr[i] = max;
				}
			}
		}	for (int i = 0;i<arr.length ;i++ )
			{	System.out.println("arr���飺"+ arr[i]);	
			}
			
	}
}
//-----------------------ð������------��С�ķ���ǰ��------------------------

 
class lianxi
{	public static void main(String[] args)
	{  
		int arr[] = {10, 7, 55, 2, 30, 14, 28, 6};
		Thing(arr);
	}
		//���� ð������
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
		{	System.out.println("���飺"+ arr[z]);
		}
	}
	
}

//------------------------���ֲ���--------------------------------------------
 
//   --------------------- ��������  �� ����ֵ ---------------------------------
class  lianxi {
	
	 public static void main(String[] args){

	 	int arr[] = {1��3,5,7,9,11,13,15};  //һ��������
	 	int dofors = Thing(arr, 28);
	 	System.out.println("Ԫ�����ڵ�����ֵ�ǣ�"+ dofors); //? Ϊʲô����ʾ6 ������ͳ����
	 }
	 	
		// �� ����ҵ�ֵ �� �����м�ֵ �Ƚ� 
	 public static int Thing(int arr[], int APP){	
		int max = arr.length-1;
 		int min = 0;
 		
 		while ( max>=min ){	   // ע������һ��Ҫ ��=
 			int i = (max + min)>>>1;//>> ��λ��һλ������2��   >>> �޷���
 			int mid=arr[i];
			
			if (APP > mid){
 				min = i + 1;
 			}else if(APP < mid){
 				max = i - 1;
 			}else{	//APP = arr[mid]
 				return i;//  ��Ϊ�� ���ķ���ֵΪ����ֵ
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
      System.out.println("���ֵ��"+ max );
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
   }//System.out.println("���ֵ��"+ max );  ������return ʱ�ͽ��� ǿ������ᱨ��
}   
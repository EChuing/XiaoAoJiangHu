
Ŀǰ������ " int[] arr ={11,2,4,2,10,11};",

"����һ��������ո�������ظ�Ԫ�أ����ط��ظ�������

������ 
		1.ȷ�������鳤��    ԭ����ĳ���-�ظ�Ԫ�صĸ���

import java.util.*;
class  Love16
{
	public static void main(String[] args) 
	{
		int[] arr ={11,2,4,2,10,11};
		arr = clearRepeat(arr);
		System.out.println("��� �ظ�Ԫ�أ�"+Arrays.toString(arr));
	}
	public static int[] clearRepeat(int[] arr){
		//����
		//�����ظ�Ԫ�صĸ�ʽ
		int count = 0; //��¼�ظ�Ԫ��
		for (int i =0 ; i < arr.length-1 ; i++ )
		{	for (int j = i+1 ; j < arr.length ; j++)
			{	if (arr[i]==arr[j])
				{	count++;
					break;
				}
			}
		}
	
	
	// �����鳤��
	int newLength = arr.length - count;
	//����������
	int[] newArr = new int[newLength];
	int index = 0; //�����������ֵ

	//����������
		for(int i = 0 ; i< arr.length ; i++)
		{
		int temp = arr[i]; //�������е�Ԫ��
		boolean flag = false;//Ĭ�ϲ����ظ�Ԫ��
		//�¾�����Ƚ�
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

11.Ŀǰ�����顱 int[] arr =  {11,2, 4, 2, 10, 11}��
����һ�����������������ظ�Ԫ�أ����ص�����洢����Щ���ظ���Ԫ�ض������鲻׼�˷ѳ��ȡ�

������
	1. ȷ��������ĳ��ȡ�  ԭ����ĳ���-�ظ�Ԫ�ظ���



import java.util.*;
class Love16 {

	public static void main(String[] args) 
	{
		int[] arr =  {11,2, 4, 2, 10, 11};
		arr = clearRepeat(arr);
		System.out.println("����ظ�Ԫ�ص����飺"+ Arrays.toString(arr));
	}

	public static int[] clearRepeat(int[] arr){
		//�ȼ�����ظ�Ԫ�صĸ�ʽ:
		int count = 0; //��¼�ظ�Ԫ�صĸ���
		for(int i = 0 ; i < arr.length-1 ; i++){
			for(int j = i+1 ; j<arr.length ; j++){
				if(arr[i]==arr[j]){
					count++;
					break;
				}
			}
		}
		
		//������ �ĳ���
		int newLength = arr.length - count;
		//����һ���µ�����
		int[] newArr = new int[newLength];

		int index = 0 ; 	//�����������ֵ

		
		//����������
		for(int i = 0  ; i< arr.length ; i++){
			int temp = arr[i];  //�������е�Ԫ�� 
			boolean flag = false;  //Ĭ�ϲ����ظ�Ԫ��
			
			
			//���ž����� ��Ԫ�� ���������ÿ��Ԫ�رȽ�һ�Ρ�
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

   ����int[] arr = {0, 0, 12, 1, 0, 4, 6, 0} 
   Ȼ���½�һ������ ��0 ��ȥ��

   "ͳ����ĸ��� �������в����������


import java.util.*;
class  Love3
{
	public static void main(String[] args) 
	{
		int[] arr = {0, 0, 12, 1, 0, 4, 6, 0};
		//clearZero(arr);
		arr = clearZero(arr);
		System.out.println("����Ԫ�أ�"+ Arrays.toString(arr));
	}

	public static int[] clearZero(int[] arr){
		//ͳ��0�ĸ���
		int count = 0; //����һ������ͳ��0�ĸ���
		for(int i = 0; i<arr.length; i++){
			if(arr[i]==0){//�ж�����=0  ������ i ��
			   count++;
			}
		}
		System.out.println("��ĸ����ǣ�"+ count);
	   //����һ���µ�����
	   int[] newArr = new int[arr.length-count];


	   int index = 0; //������洢������ֵ
	   //�ѷ������ݴ���������
	   for(int i = 0; i<arr.length; i++){
		   if(arr[i]!=0){
			   newArr[index] = arr[i];
			   index++;//ȷ��������ֵ�����Զ�����
		   }
	   }return newArr;
	}
}

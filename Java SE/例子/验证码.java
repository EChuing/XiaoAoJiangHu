//��д��֤��


package cn.itcast;

import java.util.Random;
												//		just friends?

public class Love6 {
	public static void main(String[] args){
			char[] arr={'a','b','c','d','e','f','g'};      //(beU  de)
			StringBuilder sb = new StringBuilder();   // �ַ�������
			Random random = new Random();   //���������

			//��Ҫ�ĸ��������ͨ�������ȡ�ַ������е��ַ�
			
			for(int i =0;i<4;i++){
				int index = Random.nextInt(arr.length);  
				//������� arr�� ������
				sb.append(arr[index]);
				
			}
			System.out.println("��֤�룺"+sb);
	}
}


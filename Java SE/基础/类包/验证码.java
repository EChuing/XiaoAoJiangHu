package cn.itcast;

import java.util.Random;
												//		just friends?

public class Love6 {
	public static void main(String[] args){
			char[] arr={'a','b','c','d','e','f','g'};      //(beU  de)
			StringBuilder sb = new StringBuilder();   // �ַ�������  ���������� �Ͳ������� �𻺳�
			Random random = new Random();   //���������      (wen de)

			//��Ҫ�ĸ��������ͨ�������ȡ�ַ������е��ַ�
			
			for(int i =0;i<4;i++){
				int index = Random.nextInt(arr.length); // Random�� ������arr��Ԫ�أ� �У��������һ���� 
			
				sb.append(arr[index]);//append   ʹ  ����������� ����������sb������
				
			}
			System.out.println("��֤�룺"+sb);
	}
}

���������飨��֪��,��������Զ����ɣ�,����������������С��
			arr     Random               StringBuilder        
 
ѭ������ ��ȡ�����������ַ�
i<4				index   Random.nextInt����     arr.length

ƴ���ַ��� sb��
sb.append(arr[index]);
	
 
������

��չ��


append(boolean b)   ���������������  ���ݵ������� �γ��µ��ַ���

nextInt( n )������һ�����ڵ���0С��n���������  Random �ķ���

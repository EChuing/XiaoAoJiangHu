
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
��ϰ��ʹ�ù����ַ�ʽ�������ϵ�Ԫ��
��һ��:ʹ��get��������
�ڶ��֣�ʹ�õ������������	hasNext		
�����֣�ʹ�õ������������	hasPrevious


��������
 */

public class Demo{
	
	public static void main(String[] args){
		
		List list = new ArrayList();
		list.add("����");
		list.add("����");
		list.add("����");

		System.out.println("=====get����=====");
		for(int i = 0; i<list.size();i++){
			System.out.println(list.get(i)+",");
			
		}
		//ָ��������
		System.out.println("=====�������������=====");
		ListIterator it = list.listIterator(); 
		while(it.hasNext()){   // �ж��Ƿ���Ա���   
			
			System.out.println(it.next()+",");		// ���� it ����
			
		}
		// ָ��������
		System.out.println("=====�������������=====");
		while(it.hasPrevious()){   //hasPrevious  �ж��Ƿ������һ��Ԫ��      �������ж�  ��û�ûᱨ�� 
			// ��it �Ļ��� �������  �����µ�ע�� ָ��λ��
			System.out.println(it.previous()+",");
		}
	}
}


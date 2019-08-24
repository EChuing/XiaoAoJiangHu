
��Ҫ��ס List  �ķ���    

�����  �õĺ��� �ɲ���
 
 LinkedList ���еķ�����  ����Ŀ�� ̰���� ���ã�
��linke lisiti ��		'��ʱΪ����չ ȴ�Ӷ��� ���û�õķ���  �����ظ��ķ������������ˣ�Ϊ�ˣ���ͷ��β��'
	
	1����������
	            addFirst(E e)	��Ԫ�� ��ӵ����ϵ���λ
				addLast(E e)	��Ԫ�� ��ӵ����ϵ�ĩβ��
		
				getFirst()		��ȡ��������λ�� Ԫ��
				getLast()		��ȡ������ĩβ�� Ԫ��
					
				removeFirst()	ɾ����������λ�� Ԫ�� ������
				removeLast()	ɾ��������ĩβ�� Ԫ�� ������
	
	
	2�����ݽṹ
				1��ջ ��1.6��  : ��Ҫ������ʵ�ֶ�ջ���ݽṹ�Ĵ洢��ʽ��
					�Ƚ����
					
					push()		��Ԫ�ز����б�ͷ��			//list.pubsh��"����"��		
					pop()		�Ƴ���Ԫ�� �� ���ؼ����еĵ�һ��Ԫ��	
					��pa pou��	
				
				2�����У�˫�˶���1.5���� ��Ҫ��Ϊ�������ǿ���ʹ�� LinkedList ģ��������ݽṹ�Ĵ洢��ʽ��
					�Ƚ��ȳ�
					offer()		��Ԫ����ӵ����ϵ�ĩβ��
					poll()		ɾ�������еĵ�һ��Ԫ�� �� ����
					
	
	3����������ĵ���������      
			
				descendingIterator()   ��������ĵ���������
			

������Ŀ�� ʹ�� LinkedList ʵ�ֶ�ջ�Ĵ洢���ݽṹ ������ʹ��  LinkedList ��

��ջ���� �洢�ص㣺	�Ƚ����������ȳ�		'U��ƿ' ÿ�δ�����ݶ����ڶ�������ȥ��Ҳ�Ƕ�������
�������� �洢�ص㣺	�Ƚ��ȳ���������		'�Ŷ�'	�����Ƚ�


------------------------------------------------------------------------------------------------------------------------
'����:ɾ���ظ���¼'

import java.util.ArrayList;
import java.util.Iterator;

class Book{
	int id;
	String name;  
	
	public Book(int id,String name){
	this.id = id;
	this.name = name;
	
	}
	
	// 	N1-��д toString   �� equals����
	public String toString(){
		return "{��ţ�"+this.id+"������"+this.name+"}";
	}
	public boolean equals(Object obj){
		Book book =(Book)obj;
		return this.id==book.id;
	}	
}


  
public class Demo{
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Book(110,"java���˼��"));
		list.add(new Book(220,"java���ļ���"));
		list.add(new Book(330,"����javaweb"));
		list.add(new Book(110,"java����"));	
		
		ArrayList list2 = clearRepeat(list);
		System.out.println("�¼��ϵ�Ԫ���ǣ�"+ list2);
	
	}
		
	public static ArrayList clearRepeat(ArrayList list){
		//����һ���µļ���
		ArrayList newList = new ArrayList();
		//��ȡ������
		Iterator it = list.iterator();
		while(it.hasNext()){
			Book book = (Book)	it.next(); 	//�Ӿɼ����л�ȡ��Ԫ��
			if(!newList.contains(book)){   // N1:contains �Ƚϵ����ڴ��ַ  ��Ҫ��д     toString();
				// ����������Ȿ��ʹ�����µ��鼮��
				newList.add(book);
			}
		
		}
		return newList;
	}
}
---------------------------------------------------------------------------------------------------------------
//ʹ��LinkedListģ����еĴ洢��ʽ
class TeamList{
	
	LinkedList list;
	
	public TeamList(){
		list = new LinkedList();
	}
	
	public void add(Object o){
		list.offer(o);
	}
	
	public Object remove(){
		return list.poll();
	}
	
	//��ȡԪ�ظ���
	public int size(){
		return list.size();
	}
	
}



public class Demo9 {
	
	public static void main(String[] args) {
		TeamList list=  new TeamList();
		list.add("��γ�");
		list.add("����");
		list.add("������");
		
		int size = list.size();
		for(int i = 0 ; i<size ; i++){
			System.out.println(list.remove());
		}
		
		
	}
}

----------------------------------------------------------------
Collection
		|List
				|ArrayList
				|LinkedList
	'�˽⼴��'	|Vector 	�ײ�ά����һ��  Object ������ʵ�ֵģ�  �� ArrayList �� һ���ģ�
				(Vai kiute)	���� Vector ���̰߳�ȫ�ģ�����Ч�ʵ�
				 
		|Set

		
���ԣ� ArrayList ��  Vector ������
	��ͬ�� �ײ㶼��ʹ����Object����ʵ�ֵ�
	
	��ͬ��	ArrayList 	�̲߳�ͬ��		����Ч�ʵ�  	jdk1.2����
			Vector 		�߳�ͬ��		����Ч�ʵ�	jdl1.0����    ���з��������� xxElement  
															(ĳĳe liumen)

---------------------------------------------------------


���󣺶����� ������� ���� ����

import java.util.LinkedList;


class Person{
	
	String name;
	
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	@Override 
	public String toString() {
		return "{ ���֣�"+ this.name+" ���䣺"+ this.age+"}";
	}
	
}


public class Demo {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Person("����", 7));
		list.add(new Person("��ʣ", 17));
		list.add(new Person("����", 3));
		list.add(new Person("����", 30));
		
		//��дһ�����������˵����估��������洢��
			for(int i= 0 ; i<list.size() -1 ; i++){
			for(int j = i+1 ; j<list.size() ; j++){
				//������������λ��
				Person p1 = (Person) list.get(i);
				Person p2 = (Person) list.get(j);
				if(p1.age>p2.age){  // �ж�p1������
					//����λ��
					list.set(i, p2);
					list.set(j, p1);
					
				}
			}
		}
		System.out.println(list);
		
		
		
	}
	
	
}





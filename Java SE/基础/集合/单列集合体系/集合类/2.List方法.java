Collection  (ke lashen)  ��



List ���з�����

�ص㣺����������������ֵ�� ֻ��List����ļ����� �ž߱�����ֵ �����ӿ�����ļ����඼û������ֵ
	���
		add(int index,E element)
		addAll(int index, Collection<? extends E> c)
	
	��ȡ
		get(int index)
		indexOf(Object o)
		lastIndexOf(Object o )
		subList(int fromIndex, int toIndex)

	�޸� 
		set(int index, E element)  '����λ��
					a		b
	����
		listIterator()  List (yite ruite)



	List
		ArrayList	
		LinkedList



����ע�⣺������������඼�� ��java.util�� ����


public class Demo{

	public static void main(String[] args){
	
		List list = new ArrayList();
		list.add("����");
		list.add("��ʣ");
		list.add("����");
		list.add("����");
		
		/*
		//��� 1
		list.add(1,"�Ա�ɽ");  // ��Ԫ����ӵ�����ֵ λ����
		
		//��� 2
		List list2 = new ArrayList();
		list2.add("С��");
		list2.add("С��");
		
		list.addAll(2,list2);// �� list2��Ԫ�� ��ӵ� list ������ֵλ����
		*/
		
		/*
		//��ȡ�ķ���
		System.out.println("��ȡ"+list.get(1));  // ��������ֵ ��ȡ�����е�Ԫ��
		//�����ڱ�������Ԫ��
		for(int i = 0 ;i<list.size();i++){
			System.out.println(list.get(i));		
		}
		*/
		/*
		System.out.println("�ҳ�ָ��Ԫ�ص�һ�γ����ڼ����е�����ֵ��"+  list.indexOf("��ɽ"));
		System.out.println("�ҳ�ָ��Ԫ�����һ�γ����ڼ����� ������ֵ��"+list.lastIndexOf("����"));
		List subList = list.subList(1, 4);  //ָ����ʼ �� ����������ֵ  	��ȡ�����е�Ԫ��
		System.out.println("�Ӽ���Ԫ���ǣ�"+subList);
		*/
		/*
		//�޸�
		list.set(3, "��С��");  //ʹָ��Ԫ���滻����ֵλ�õ�  Ԫ��
		*/
	System.out.println("����Ԫ��"+list );
	}
}


----------------------------------------------------------------------------------------------

������



/*
����
	LIsiIterator()
	
	���еķ�����
	
	���    (has pui li as)
		hasPrevious()  �ж��Ƿ������һ��Ԫ��
		previous()			��ȡ��һ��Ԫ��    ��ǰָ���������ƶ�һ����λ��Ȼ����ȡ����ǰָ��ָ���Ԫ��
		(pui li as)	
		
		�Ƚϣ�  next();   ��ȡ����ǰָ��ָ���Ԫ�أ�Ȼ�������ƶ�һ����λ
	---------------------------------------------------	
		
		add(E e)		�ѵ�ǰԪ�ز��뵱ǰָ��  ָ���λ��  ���� next() ��ָ���ƶ�����һλ    
		set(E e)		������������һ�η��ص� Ԫ��
*/
public class Demo{

	public static void main(String[] args){
	
		List list = new ArrayList();
		list.add("����");
		list.add("��ʣ");
		list.add("����");
		list.add("����");
	
	ListIterator it = list.listIterator(); //���ص���һ��List�ӿ������еĵ�����
	/*
	System.out.println("����һ��Ԫ��ô��"+it.hasPrevious());
	System.out.println("��ȡ��һ��Ԫ�أ�"+it.previous());  // û��Ԫ�� �ᱨ��
	*/
	
	/*
	it.next();
	it.next();
	it.add("����");   // next(); ��ʹָ���ƶ�һλ
	*/
	
	it.next();
	it.next();
	it.set("����");
	System.out.println("����Ԫ��"+list );
	}
	
	
}





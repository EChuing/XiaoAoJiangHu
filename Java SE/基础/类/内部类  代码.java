
�ڲ��ࣺ һ������������һ������ڲ�����ô����ͳ����ڲ���

�ڲ����class�ļ������ⲿ��$�ڲ��ࡣ   ���ڣ���������class�ļ��������ĸ��ⲿ��
�ڲ�������
	
	��Ա�ڲ��ࣺ

					��ʽ1�����ⲿ�� �ṩһ�����������ڲ���Ķ�����з��ʡ�

					 2���������� ֱ�� �����ڲ���Ķ��� 
						��ʽ ��	�ⲿ��.�ڲ���  ������ = new �ⲿ��().new �ڲ���
							
						ע�⣺�����һ����̬�ڲ��࣬��ô�������� �����ĸ�ʽ��
								�ⲿ��.�ڲ��� ������ = new �ⲿ��.�ڲ���();


		�ڲ������ó���������������A�������ʱ�򣬷�������A�����ڲ�����������һ�� �Ƚ�
						���ӵ�����Bʱ�� ��������Ƚϸ�������B����ҪҪ����A��������Ե����ݣ���ô��ʱ
						�� ���ǾͿ���ʹ���ڲ�������B����
							
						
	�ڲ���ĺô��� �ڲ������ֱ�ӷ����ⲿ������ó�Ա ����ս�ţħ���Ķ��ӣ�
								
						ע�⣺	1.�� �� ���� ������ͬ������ʱ�����ڲ�����Ĭ�Ϸ��ʵ����ڲ���ĳ�
						Ա�������ͽ�ԭ�򣩣� ����ͨ��   �ⲿ��.this.��Ա������ ����ָ������
								2.˽�еĳ�Ա���� ֻ�����ⲿ���ṩһ�����������ڲ���Ķ���  ����
								���ʣ������������ഴ��������.
								3.��Ա�ڲ�������ྲ̬�ĳ�Ա����ô  ������Ҫ��staic����
										ԭ��	
		
		
		
		
		�ֲ��ڲ��ࣺ��һ����� �����ڲ�������һ���࣬ ��ô��һ������Ƿ����ڲ��ࡣ


//------------------------------

	1.�������
	2.�ֲ�����
	3.��̬���� static
			
			�������
			  {
				i = 3000000000000000; 
			  }
//-----------------------------




class Outer
{
		int x = 100;

	    //��Ա�ڲ��ࣺ
		class Inner
		{	
			int i; 
			public void ptint()
			{
				System.out.println("���ǳ�Ա�ڲ���");
			}
		}

		//���ⲿ���   �����д����ڲ���� ���� Ȼ������ڲ� ������
		public void instance(){
			Inner inner = new Inner();
			inner.ptint();
		}

		//�ֲ��ڲ���
		public void test()
		{
			class Inner
			{	
				int i = 100;
				public void print()
				{
					System.out.println("���Ǿֲ��ڲ�����");
				}
			}
		}

}



/*class  Outer
{	
	int i ;//��Ա����

	public void test()
	{
		//�ڲ���
		class Inner
		{	
			int i; //�ֲ�����
		}
	}
}*/
class  Love11
{
	public static void main(String[] args) 
	{	
		Outer outer = new Outer();
		outer.instance();
		System.out.println("Love11 de  ");

		Outer.Inner inner = new Outer.Inner();
		inner.print();


	}
}


//-------------------�����-----------------------------
class Love7
{
	int id;  //���

	String name;//����
	
	int age;//���� ������"����֮�⣬��֮��"�� ��Աλ����

	public void work(){
		System.out.println("�����Ǹ������ӣ�");	
	}
	public qqwe(){ System.out.println("����2 ����"); }
	public qqwe(int q , String w , int e){
		id =  q;
		name =  w;ds
		age = e ;

		work(); 
		// �ڹ��캯������� �������  ���ڵ���ʱʹ�� 
		//  ��Ȼ������ʾ    
		
		System.out.println("����1 ����");	
	}
}

class Demo3
{
	public static void main(String[] args){
		//����һ��Ա������
		qqwe e1 = new qqwe(10086    , "Сѧ��  " , 50);
		
		System.out.println("��ţ� " + e1.id + "���֣� " + e1.name +  "���䣺" + e1.age);
	}
}
class 
{	
	public static void main()
	{
		//�ֲ������ ������λ�ڷ���֮��
		{
			new......	
				System.out.println.......
		}
		//���ã����ֲ̾��������������� ��Լһ����ڴ�
	}
		public static void main()
		{   //�ֲ������
			{
				baby b1 = new baby����������
                System.out.println��....��
			} //��������ʱ ���� �ͷ��ڴ� 
			  // ���ں����˻ῼ�� ��˾��Ǯ�������
		}
}



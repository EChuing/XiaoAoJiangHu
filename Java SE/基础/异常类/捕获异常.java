
--------------------------����ʽ�� ������------------------------------
class Love12 
{
	public static void main(String[] args) 
	{
		div(4,0);
	}

	public static void div(int a, int b , int[] arr){
		int c = 0;
		// Exception �� ArithmeticException �� NullPointerException �� ����
		try{
		int c = a/b; //jvm��⵽������������ᴴ��һ���쳣
		System.out.println("���鳤�ȣ�"+arr.length);
		} catch(Exception e)   // �����˶�̬ Exception = new NullPointerException();
			System.out.println("����ҽԺ�����ȴ�����ˮ �������ǵ��....")��
				
		}catch( ArithmeticException e){//"�������ָ���쳣"
			//�����쳣�Ĵ���
			System.out.println("�쳣������...");
			System.out.println("toString��"+e.toString());
	
		}catch �� NullPointerException e��{   // ���ڴ����ָ��
			System.out.println("�����˿�ָ���쳣...��");
			
		}
		System.out.println("c="+c);
	} 
}
		Error��β:			����
		( e a )
		Exception��β��:	�쳣
		��esha shen)
������Ϣ��ͨ���� printStackTrace ��ӡ������
				 ��printsida qunsi��
-------------------------------------------------------
Exception in thread "main" java.lang.ArithmeticException: / by zero
        at Love12.div(Love12.java:9)
        at Love12.main(Love12.java:5)
-------------------------------------------------------
jvm�����е�a/b�������ʱ�򣬷���bΪ�㣬����Ϊ 0 �����������ڲ������������
jvmһ�����֣��ͻ����ϴ� ��printStackTrace�ķ���������




java�����쳣ʱ ����ĳ���Ͳ�������


�쳣�Ĵ���
		��һ�֣� ������      ���� ��ץ
					
						��ʽ�� try{ ���ܷ������쳣���� 
							}catch{ �����쳣������ ������}{
							 (kA H)���쳣�Ĵ���...
						}	
				���ʣ�
						1.�쳣�Ĵ���о�ûʲô���ã���Ϊ�����һ�仰����
										
								����������תҳ�� ���� ��� ά��ҳ��+

						2.�Ժ󲶻��� ��ʱ�� ֱ�� Exception ���ɣ�
				
								��ʵ�����У���ͬ���쳣 �����в�ͬ�Ĵ���ʽ��Ҫ����
				������ע�⣺
						1.���try���д���������쳣�����˴������ôtry-cath������������������ִ�С�
						2.	try{}���г����쳣�� ִֻ�� catch{} �Ĵ��롣
							try{}���г��������� ִֻ�� try{} �Ĵ��롣
						3.һ��try����� �����cath�� �� ��������쳣���͡�	
						4.һ��try����Բ�������쳣�����ͣ���������쳣������Ǵ�С������в��񣬷�����뱨��
				



		�ڶ��֣� �׳�����--������ ҩ�겻�Ҳ��յ� ����       �������ã� �׳���������
							�� throw  throws ��
				
				�׳�����ע�⣺
						1.���һ�������ڲ��׳�����ʱ�쳣 ���� �� ��ô��Ҫ�ڷ����������׳���
						2.���������һ�������׳��쳣 �ķ�������ô�����߱���Ҫ�����쳣
						3.���һ�������ڲ��׳���һ���쳣������ô throw ������Ĵ��붼�������ִ���ˡ�
						4.һ������������ throws ��su lou���ؼ��֣��ⷽ�� ��ִֹͣ��
						

			throw �� throws �ؼ��֣�
						throw  �����ڷ����ڲ����׳�һ���쳣����

						throws	�����ڷ��������ϣ������׳��쳣������
								�� �����������  �����׳�  �������͵� �쳣								
				���ʣ�
						��ʱʹ���׳�������ʱʹ�ò�����	��
							�����Ҫ֪ͨ�����ߣ����������ˣ����׳�����
						 	�������ֱ�����û��򽻵�������Ҫ������	web��ת�Ѻ�ҳ�档	 "�쳣�������׸��û�"		
-----------------------����ʽ�� �׳�����-------------------------------				

class Love12 
{
	public static void main(String[] args)  
	{	
	
		div(4,0); // ���б��� �� throw new Exception();  ����
	}
									// �ڷ�����ʲô�׳�	
	public static void div(int a, int b)throws Exception { 
		if(b == 0){
			throw new Exception();  // �׳�һ���쳣����
		}
		int c = a/b;
		System.out.println("c="+c);
	}
}

---------------------------��ʽ  �����  �Լ�����-----------------------------

class Love12 
{
	public static void main(String[] args)     
	{	
		try{
			div(4,0); // ���б��� �� throw new Exception();  ����
		}catch(Exception e){   
			System.out.println("�������쳣....");
			e. printStackTace();
							 }
		}
									// �ڷ�����ʲô�׳�	
	public static void div(int a, int b)throws Exception { 
		if(b == 0){
			throw new Exception();  // �׳�һ���쳣����
		}
		int c = a/b;
		System.out.println("c="+c);
	}
}
---------------------------��ʽ  �׸�jvm���� -------------------------------
class Love12 
{															 // ���ζ��������������				
	public static void main(String[] args) throws  Exception,NullPointerException//��2�Ÿ��쳣 �׳� ��jvm�����     
	{	
			div(4,0); // 2�ţ����б��� �� throw new Exception();  ����
	}
									// �ڷ�����ʲô�׳�	
	public static void div(int a, int b)throws Exception { 
		if(b == 0){
			throw new Exception();  // 1�ţ��׳�һ���쳣����  ��2��
		}
		int c = a/b;
		System.out.println("c="+c);
	}
}
 jvm�����׳��쳣�Ĵ���ʽ�� ֱ�Ӵ�ӡ�쳣�� ջ��Ϣ
-----------'�߳�

����=����    ���̸���ռ�Ļ���

���⣺windows �ųƶ������Ĳ���ϵͳ����ôWindows��ͬʱ���жԸ����ó���
  				��ۣ�   �ǵ�
				΢�ۣ� 	����
					
				����cpu��һ��ʱ��ִֻ��һ������
				cpu�����л�����  ��  ���Ǹо����� 



�̣߳� �߳���һ�������� ��������ִ��  ���ǽ�����һ��ִ��·��
	
���̣߳� һ������ ִ�ж���߳�ͬʱִ��	
			'cpu����Դ����'
    	
		�κ�һ��java������ jvm�����е�ʱ�� �ᴴ��һ��main�߳�ִ��  main���������д��롣
    
    	
    	
һ��javaӦ�ó�������ִ�ж��ٷ��̣߳�
		�����������̣߳� һ����main���߳� 	����main����ִ��
					һ��������������   	��������

���̵߳ĺô���
		1.�����һ��������ͬʱִ�ж�����������
		2.�����Դ��������


	      �׶ˣ�	 
		 1.����cpu�ĸ���
	     2.������һ���������̵߳�ִ�и���
    	 3.�����̰߳�ȫ
    	 4.��������������
	           
	    
�������߳�	//�Զ����߳�
		
		���贫��ֵ
		����һ;			   (si vade)
			1.�Զ���һ����̳�Thread�ࡣ
			
			2.��дThread��ķ�����	
					���ʣ�Ϊ����д�� 
							ÿ���̶߳����Լ�������
							jvm�������̵߳�����������        
							main�����е����д���
					
							���Զ����̵߳�������� ��д��run������  
							�Զ����̸߳���run�ķ���
			
			 3. main �д���Thread��������󣬲��ҵ���start���������̡߳�
			 				һ���߳�һ����������ô�߳̾ͻ�ִ��run�����еĴ��룬 
			 				run����������ֱ�ӵ��ã� ���þ͵�����ͨ���� �� û�����߳�
			
					
		����Ҫ����ֵ��			
		��������				(rua nebou) ������
			1.�Զ���һ����ʵ�� Runnable ��Runnable��

			2.ʵ�� Runnable �ӿڵķ��������Զ����̵߳����� ������run������

			3.���� Runnable ��Ķ��� 
			
			4.���� Thread �����  �� Runnable ��Ϊʵ�δ���
												     		�������� Thread �� Runnable target , String name��
			5.���� Thread ���� �� start ����  ����һ���߳�				Runnable�Ķ���һ�����Զ����һ��

				
				���⣺
					1.Runnable ʵ����Ķ����� �̶߳���ô��
						��:  Runnable ʵ����Ķ��� ������һ���̶߳���, ֻ������ʵ����Runnable�ӿڵķ�������
							  ֻ�� Thread ������ Thread ������ �����̶߳���

					2.ΪʲôҪ�� Thread ��ʵ���������Ϊʵ�δ��ݸ�Thread�����أ� ��ʲô���ã�
						��	  ���þ��ǰ�Runnableʵ��������run������Ϊ�̵߳� �������ȥִ�С�

			��ǰ�̣߳� Thread.currentThread()



��һ��(1)
----------------------------------------------------------------------
							//		just friends?

public class love extends Thread{

	public void run() {
		for(int i =0;i<100;i++){
			System.out.println("�Զ����߳�"+i);
			
		}
	}

	public static void main(String[] args){	
		love L = new love();   //���� ���෽��
		L.start();  //����������� ��start ����   �� �������߳�
		for(int i =0;i<100;i++){
			System.out.println("���߳�"+i);
		
		}
	}
}	
(2)
--------------------------------------------------------------------------------------------------------------------


package cn.itcast;

/*
	ģ��Q�������Ƶ.

*/

class TalkThread extends Thread{
		public void run(){
			while(true){
				System.out.println("���..........");				
			}	
		}
}

class VideoThread extends Thread{
	public void run(){
		while(true){
			System.out.println("��Ƶ����...");
		}		
	}	
}

public class love{
	public static void main(String[] args){
		TalkThread talkThread = new TalkThread();
		talkThread.start();
		VideoThread videoThread = new VideoThread();
		videoThread.start();
	}
}

������(1)
----------------------------------------------------------------------------

				  (in pemen s) ����
public class Demo3 implements Runnable{
	
	public void run(){
		for(int i=0 ; i<100; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}					   /*    ��ǰ�߳�              */
	}

	public static void main(String[] args){
		//���� Runnableʵ�������
		Demo3 d = new Demo3();          ---- d ����Runnableʵ�������
		//����Thread��Ķ��󣬰� Runnable��Ϊʵ���������Ϊʵ�δ���
		Thread thread = new Thread(d,"����");            �������� Thread �� Runnable target , String name��
		//����trhead�����start����   �����̣߳�
		thread.start();

		for(int i=0 ; i<100; i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}

(2)
---------------------------------------------------------------------------------------------------------------------

class SaleTicket implements Runnable
{
	int num = 50 ;// Ʊ��

	public void run(){
		while(true){
			synchronized("��"){
				if(num>0){	
					System.out.println(Thread.currentThread().getName()+"�۳���"+num+"��Ʊ��");
					num--;
				}else{
					System.out.println("�ۿգ�..");
					break;
				}
			}
		}
	}
}	

public class Demo3
{
	public static void main(String[] args){
		
		SaleTicket s = new SaleTicket();   
		//SaleTicket ��� int = 50  ֻ��һ��  ʹ��ǰ�治�ü� start
		
		
		Thread t1 = new Thread(s,"111��");
		Thread t2 = new Thread(s,"222��");
		Thread t3 = new Thread(s,"333��");
		t1.start();
		t2.start();
		t3.start();
	
	}
}






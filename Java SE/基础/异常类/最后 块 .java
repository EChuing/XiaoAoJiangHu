
finally ��(fai ne li)
		ʹ��ǰ�������try��
		�κ�ʱ�򶼻�ִ�� ֻ��jvm�˳�ʱ��ִֹͣ��
		��������Դ�ͷŵĹ��������Ա�֤��Դ���κ�ʱ�򶼿��Ա��ͷ�

������ϣ�
	1.�������쳣Ҫ������û����Դ���ͷ�
			
		try{
			���ܷ����쳣�Ĵ���
		}catch ��������쳣���� ��������{
				�����쳣		
		}
		
	2.���쳣Ҫ����Ҫ��Դ�ͷ�

		try{
			���ܷ����쳣�Ĵ���
		}catch ��������쳣���� ��������{
				�����쳣		
		}finally{
				�ͷ���Դ�Ĵ��룻		
		}

	3.�ڲ��׳���������ʱ�쳣����Ҫ��Դ�ͷ�  �� ���� ��

		try{
			���ܷ����쳣�Ĵ���
		}finally{
				�ͷ���Դ�Ĵ��룻

		����ʱ�쳣��һ��Ҫ���� ����ʱ�쳣���Բ��ô���


--------------------------finally ��  ʹ��-----------------------------------

class Love001 
{
	public static void main(String[] args) 
	{
		div(4,0);
	}
	public static void div(int a,int b){
		try{
			if(b==0){
				System.exit(0);//�˳�jvm
			}	
			int c = a/b;
			System.out.println("c="+c);
		
		}catch(Exception e){
			System.out.println("�����˳���Ϊ0���쳣...");
			throw e;	
		}finally{
			System.out.println("finally��������...");
		}
	}

}
--------------------- finally ���ͷ���Դ -------------------


import java.io.*;
class Love001
{	
	public static void main(String[] args)
	{	
		FileReader fileReader = null;
		try
		{	//��Ŀ���ļ�
			File file = new File("f://a.txt");				// �ļ������ﻹ��֪��
			//�����������ļ�������ͨ��
			fileReader = new FileReader(file);
			//��ȡ�ļ�
			char[] buf = new char[1024];
			int length = 0;
			length = fileReader.read(buf);
			System.out.println("��ȡ�������ݣ�"+ new String(buf,0,length));
		catch(IOException e){
			System.out.println("��ȡ��Դ�ļ�ʧ��");
		}finally
		 {	
			try{
				//�ر���Դ
				fileReader.close();
				System.out.println("�ͷ���Դ�ļ��ɹ�....");
			catch{IOException e}{
				System.out.println("�ͷ���Դ�ļ��ɹ�....");
			}
		 }
	}
}
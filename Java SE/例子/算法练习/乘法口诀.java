//-------------------------��д�˷��ھ�-----------------------------

class Demo001
{	public static void main(String[]  agse)
	{
		innt(9);  // �˷��ı���
		System.out.println("����");
	}
	//����
	public static void innt(int toou)
	{
		for (int i = 1 ; i<=toou ; i++ )
		{	for ( int j = 1; j<=i ; j++ )
				{	//System.out.println(j+"*"+i+"="+j*i+"\t");          ���� println �� print   ��� ln ȴ�Դ�����
				    System.out.print(i+"*"+j+"="+i*j+"\t");
				}//����
		        System.out.println();
		}
	}
}

/*	
	//����2�� ����һ��������ӡһ���˷�������Ҫ�����κ����ݡ� 
	public static void  innt(int run){
		for(int i = 1 ; i<= run ; i++){
			for (int j = 1 ;j<=i  ;j++ ){
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			//����
			System.out.println();
		}
	}
}
*/

ģ��ģʽ�� ĳ������Ĳ�����Щ�¹̶��ģ���Щʱ�ᷢ����
			���ģ���ô��ʱ�����ǿ���Ϊ���������ṩһ��
			ģ����룬�Ӷ����Ч�ʡ�

���� ��дһ�������������ʱ�� ��ģ�� 
		
		���裺
				1.��д����� �����������е� һ���Ľ������
				2.�������룬�ѻᷢ���仯�Ĵ����ȡ���� 
				  ������һ��������  �ɳ���ķ���
				3.ʹ�� final ��ֹ���� ��д���ģ�� 

--------------------------------------------------------------
class  MyRuntime
{
	public void getTime()
	{
		long startTime = System.currentTimeMillis();  // ��¼��ʼ��ʱ��
		for(int i = 0; i<100 ; i++){
			System.out.println("i="+i);
		}
	
		long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(endTime-startTime)); //��¼������ʱ��
	}
}

class Love15
{
	public static void main(String[] args){
		MyRuntime time = new MyRuntime();
		time.getTime();
	}
}


-----------------------��ȡ ��ͬ����------------------------------------

abstract class  MyRuntime   // ģ��
{
	public final void getTime()
	{
		long startTime = System.currentTimeMillis();  // ��¼��ʼ��ʱ��
		code();	
		long endTime = System.currentTimeMillis();
		System.out.println("����ʱ�䣺"+(endTime-startTime)); //��¼������ʱ��
	}
	public abstract void code();
}

class Love15 extends MyRuntime
{
	public static void main(String[] args){
		Love15 d = new Love15();
		d.getTime();

	}
	
	// ��Ҫ��code��ģ�� ��Ҫ
	public void code(){
		int i = 0;
		while(i<100){
			System.out.println("i="+i);
			i++;
		}
	}
}

�Զ����쳣��

���� ����QQû�����磬 �������������ʾ�����б�

//����һ��û�����ߵ��쳣
class NoIpException extends Exception{
	
	public NoIpException(String message){
			super(message);//���� Execption һ�������Ĺ��캯����
	}
	
	
}


class Love13
{
	public static void main(String[] args) 
	{	
		String ip = "192.168.10.100";
	//	ip = null;
		try{
			QQ(ip);
		}catch(NoIpException e){
			e.printStackTrace();
			System.out.println(" ���� ����������... ");
		}
	}
 
	public static void QQ(String ip)throws NoIpException{
		
		if(ip==null){
			throw new NoIpException("û������...");
		}
		System.out.println("������ʾ�����б�..");
	}
}

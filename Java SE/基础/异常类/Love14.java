/*
���� ģ����ȥ��ľͰ���������Ǯ������10�飬��ô���׳�һ��û��Ǯ���쳣����
		���������Ǯ����ô��Ϳ���ȥ�Է���
*/
//ûǮ���쳣
class NoMoneyException extends Exception{
	public NoMoneyException(String message){
	super (message);
	}
}

class  Love14
{
	public static void main(String[] args) 
	{	
		try{
		eat(1);
		}catch (NoMoneyException e){                   // �����濪ʼд �Լ��Ĵ���ʽ
			e.printStackTrace(); //��ӡ�쳣��Ϣ
			System.out.println("����ɨһ���µĵ�");
		} 
		System.out.println("û�г����쳣...");
	}
	public static void eat(int money)throws NoMoneyException{        throw-throws �������쳣���׳��� �ǵ���������д throws 
		if(money<10){												 try-catch ������ܳ�����쳣�� catch д����ʽ
			throw new NoMoneyException("С�����ҳ԰�����...");
		}
		System.out.println("�� ���ڳԷ�...");
	}

}



�������ģʽ


1.˽�л����캯��
2.��������ĵ��������ͱ���������ʹ�øñ���ָ�������
3.�ṩһ��������̬�ķ�����ȡ�������


//��֤tufo���ڴ�ֻ��һ������
class tofu
{	
	//˽�л����캯��
	private tofu(){};

	/*����������������ͱ���������ʹ�øú�������ָ�������
		��װ �� ֻ��һ��	 */
	private static tofu s = new tofu();

	//�ṩһ��������̬�ķ�����ȡ�������
	public static tofu getInstance(){
		return s;
	}
}

class  Demo1
{
	public static void main(String[] args) 
	{	tofu s1 = tofu.getInstance();
	    tofu s2 = tofu.getInstance();
		System.out.println("��ô"+ (s1==s2));
	}
}

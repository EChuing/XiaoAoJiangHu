class  Baby
{ 
	int id; //���֤
	String name ;//����
    public Baby(int i, String j){
		id = i;
		name = j;
		System.out.println("����1���гɹ�");
	}

	public Baby(){System.out.println("����2���гɹ�");}
	public void cry(){
		System.out.println("�����ϹϵĿ���.");
	}
}
class Love5  // ���캯��
{
	public static void main(String[] args){
		//����һ������
		Baby b1 = new Baby(110, "����");
		System.out.println("���:"+ b1.id +     "����:"+ b1.name);

		//�ڻ�
		Baby b2 = new Baby();
		b2.id = 112;
		System.out.println("��ţ�"+ b2.id +"����"+ b2.name);
	}
}
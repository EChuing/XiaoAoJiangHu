
�����룺 javap -c -l -private ����


�ӿڣ�
	ע�⣺
		1.�ӿ��Ǹ��������
		2.�ӿڳ�Ա����Ĭ�ϵ����η�Ϊ�� public static final    ����Ա�������ǳ�����
		3.�ӿ��еķ������ǳ���ķ�����Ĭ�����η�Ϊ��public abstract��abe sique tr)
		4.�ӿڲ��ܴ�������
		5.�ӿ���û�й��췽����
		6.�ӿ��Ǹ���ȥʵ��ʹ�õģ��ǳ�����ʵ��һ���ӿ��ǣ������ ���нӿڵķ���ȫ��ʵ��

	��ʽ��        ��in peli mensi��
		class  ���� implements  �ӿ���{
		}
	
	
	���ã� 
		1.������չ����
		2.����Լ���淶
		3.����Ľ���


 ������һ������Ҫ����

/*
interface A
{	//��Ա����  �ͳ���һ��
	public static final int i = 10;
	
	//��Ա����
	public void print();
}
��in peli mensi��
class fee2 implements A
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
*/



//��ͨ��Ǧ����
 class Pencil
 {	
	String name;

	public Pencil(String name){
		this.name = name;
	}
	
	public void write(){  //ruai te 
		System.out.println(name+"ɯɯ��д������..");
	}

 }
  
//��Ƥ�Ľӿ�
interface Eraser   //  ��int feisi��    ��E leAse��
{	
	public void remove(); //(V muiF)
}
//����Ƥ��Ǧ��     �߱�Ǧ�ʵ����ù��� ���̳�Ǧ�ʣ� 
class PencilWithEraser extends Pencil implements Eraser 
{	public PencilWithEraser(String name){
		super(name);
	}
	public void remove(){
		System.out.println("Ϳ��........");
	}
}

class Lvoe9
{
	public static void main(String[] args)
	{
		PencilWithEraser p = new PencilWithEraser("ɵ��Ǧ��");
		p.write();
		p.remove();
	}
}




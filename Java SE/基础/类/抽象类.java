			
/*                                                                         ������ abstract
���⣺
	   1.�����run��������ȷ
	   2.û��ǿ������һ��Ҫ��дrun�ķ���

�����ࣺ
		���ã�ǿ�����෽����д
		
	ע�⣺                    (main ��)
		1.���һ������û�з������壬��ô�ú�������Ҫ��abstract���γɣ�����ĺ���
		2.���һ��������˳����࣬��ô�������Ҳ���� ʹ��abstract����
		3.���һ���ǳ�����̳��˳����࣬��ô����Ҫ�ѳ���������ó��󷽷�ȫ��ʵ��
		4.��������Դ��ڷǳ��󷽷���Ҳ���Դ��ڳ���ķ���
		5.�����಻�ܴ������� ��Ϊ��������ڵĳ��󷽷��ģ�������ó����ഴ���Ļ�����ôʹ�ó���Ķ�����ó���ķ�����û���κ�����ġ�
		6.�������Ǵ��ڹ��캯���ģ���ṹ���ṩ�����ഴ�������ʱ���ʼ�����������

������ע�⣺
       1.һ������û�з������壬��ô�ú���������abstract���Σ� ��Ϊ������
	   2.���һ�������ǳ����࣬��ô����Ҳ������abstract����
	   3.���һ���ǳ�����̳��˳����࣬��Ҫд����Ӧ�Ҳ���abstract�Ĺ��췽��
                  (abe sique de)

abstract���������¹ؼ�����ϣ�
		1.����private��plai ruike����ͬ����һ������      ˽�г��������Ͳ��ɼ�
		2.����static��sa ti ke����ͬ����һ������         ���˿���ʹ���������е���
		3.����final��fai no����ͬ����һ������            �������� ��Ҫ��д


*/
//��������
abstract class	Animal{                           
	
	String name;
	String color;
	
	public Animal(String name, String color) 
	{	this.name = name;
		this.color = color;
	}
	//��������  �Ҳ������л����ţ����壩
	public abstract void run();

}

//��
class Dog extends Animal
{	public Dog(String name,String color)
	{
		super(name,color);//���ø������������ĵĹ��췽��
	}
	//ʵ�ֳ��� ��д����
	public  void run(){
		System.out.println(name+"�����ȣ��ܵ����죡");
	}

}

//�� 
class Fish extends Animal
{	public Fish(String name,String color)
	{
		super(name,color);
	}
	public void run(){
		System.out.println(name+"����β�ͣ��ε����죡");
	}
	
}

class Doow
{	public static void main(String[] args)
	{
		Dog d = new Dog("����Ȯ","��ɫ");
		d.run();

		Fish f = new Fish("����","���ɫ");
		f.run();
	}
}

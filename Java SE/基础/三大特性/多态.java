
��̬��һ������߱�������̬��  
							���֣�	�����������ͱ���	ָ��	�������			����  a = new ����();
									�ӿ��������ͱ���	ָ��	�ӿ�ʵ����Ķ���	�ӿ� ���� = new �ӿ�ʵ����Ķ���

��̬��ǰ�᣺"������ڼ̳� ���� ʵ�ֹ�ϵ

	��̬���ã�	
			1."��ߴ������չ��
			2.�ж϶����Ƿ�����ָ�����
			3.��̬�У�������ת��ʱ��Ҫ���ж���ת���� 
   
				��ʽ��ֻ���� ������  instanceof ���� �� ture false   ��Ȼ�ͱ���
	��̬ע�⣺
			1.  ��̬����£��Ӹ������ͬ���ĳ�Ա����ʱ�����ʵ��Ǹ���ĳ�Ա������
			2.  ��̬����£��Ӹ������ͬ���ķǾ�̬�ĳ�Ա����ʱ�����ʵ�������ĳ�Ա������
			3.  ��̬����£��Ӹ������ͬ���ľ�̬�ĳ�Ա����ʱ�����ʵ��Ǹ���ĳ�Ա������
			4.  ��̬����£����ܷ����������еĳ�Ա��

	 

	��̬��Ӧ�ã�
			1. ��̬�����β����͵�ʱ�򣬿��Խ��ո������͵����� ��
			2. ��̬���ڷ���ֵ���͵�ʱ�򣬿��Է��ظ������͵����ݡ�



�ܽ᣺	��̬����£��Ӹ������ͬ���ĳ�Աʱ�����ʵĶ��Ǹ���ĳ�Ա��������ͬ���Ǿ�̬����ʱ���Ƿ�������ġ�
		
		���뿴��ߣ����в�һ�����ұߡ�
		���뿴��ߣ�java�������ڱ����ʱ�򣬻����������ͱ������������Ƿ�߱�ָ���ĳ�Ա��������߱����ϱ��뱨��



// (Abe sique de)�����        (A nime)����
abstract class Animal 
{	
	String name;
	String color = "����ɫ";//  ��ɫ(ko le)

	public Animal(String name){
		this.name = name; // this ���ñ������ĳ�Ա����
	}
	public abstract void run();
}	
// ���� mao si��
class  Mouse extends Animal
{	
	public Mouse(String name){
		super(name);//���ø��� һ�������Ĺ��췽��
	}
	// �������췽�� 
	public  void run(){
		System.out.println(name+"�������������ߣ�");
	} 
}
//�� (fyi xu)      �̳� ��ex tensi��
class Fish extends Animal
{
	public Fish(String name){
		super(name);//ͬ��
	}
	//�������췽��
	public void run(){
		System.out.println(name+"һ��β����ѽ��...");
	}
}


class Dtai
{	
	public static void main(String[] atgs)
	{	// ��ͨ����	
		Mouse m = new Mouse("����");        //����ָ����   �����ø�������ķ���            
		m.run();
		
		//��̬����
		Animal a = new Mouse("������");     //����ָ����  ���Ե��ø�������Ժͷ���  
		a.run();
	}
}

����ָ����  ��������д�˸���ķ���  ��ô����ͻ���ø÷���  ����̬���ӣ���  û��֤��

//-----------------��ϰ--------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
/*
����1�� ����һ���������Խ����������͵�ͼ�ζ��󣬲��Ҵ�ӡͼ��������ܳ���


    �����ࣺĳ����ķ�������ȷ��Ҫǿ������д


*/

//ͼ����
abstract class MyShape{
	//	 ���캯��û�з������� ��Ҫabstract ����Ϊ������
	//   ������abstract ������Ҳ��Ҫ�� abstract ����         ����Ҫ������д����
	public abstract void getArea();

	public abstract void getLength();	
}


			//�̳�
class Circle extends MyShape{
	// ����
	public static final double PI = 3.14;

	double r;
	//���챾�෽��
	public Circle(double r){
		this.r =r ;	
	}
	// ��д����
	public  void getArea(){
		System.out.println("Բ�ε������"+ PI*r*r);
	}
	//��д����
	public  void getLength(){
		System.out.println("Բ�ε��ܳ���"+ 2*PI*r);
	}
}


class Rect  extends MyShape{

	int width; // ��
	int height;//��

	public Rect(int width , int height){
		this.width = width;
		this.height = height;
	}

	public  void getArea(){
		System.out.println("���ε������"+ width*height);
	}

	public  void getLength(){
		System.out.println("���ε��ܳ���"+ 2*(width+height));
	}
}



class Demo12 {

	public static void main(String[] args) 
	{
		/*
		//System.out.println("Hello World!");
		Circle c = new Circle(4.0);
		print(c);

		Rect r = new Rect(3,4);
		print(r);
		*/

		MyShape m = getShape(0); //������ʹ�ö�̬�ķ���������ı�������Ҫ�뷵��ֵ����һ�¡�
		m.getArea();
		m.getLength();
		

	}


	//����1�� ����һ���������Խ����������͵�ͼ�ζ��󣬲��Ҵ�ӡͼ��������ܳ���
	public static void print(MyShape s){ // MyShpe s = new Circle(4.0);
		s.getArea();
		s.getLength();
	}


	// ����2�� ����һ���������Է����������͵�ͼ�ζ���
	public static MyShape  getShape(int i){
		if (i==0){
			return new Circle(4.0);
		}else{
			return new Rect(3,4);
		}
	}
//-----------------��ϰ--------------------------------------------------------------------
//-----------------------------------------------------------------------------------------

interface Dao  //�ӿڵķ���ȫ�����ǷǾ�̬�ķ���
{
	public void  add();
	public void delete();
}

//�ӿڵ�ʵ����
class UserDao implements Dao{
	public void add(){
		System.out.println("���Ա���ɹ���");
	}

	public void delete(){
		System.out.println("ɾ��Ա���ɹ���");
	}
}


class  Love10
{
	public static void main(String[] args){
		//ʵ�ֹ�ϵ�µĶ�̬
		Dao d = new UserDao();
		d.add();
	}
}

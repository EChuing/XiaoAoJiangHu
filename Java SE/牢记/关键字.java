
--------------------------super �ؼ���-------------------
super ������ռ������

      ���� �� 
			1.�Ӹ������ͬ����Աʱ����������Ĭ���Ƿ��������Ա������
			  ����ͨ��super�ؼ���ָ�����ʸ���ĳ�Ա��
			2.ָ�����ø���Ĺ��췽���� ()�ж����޲���
		
���ø��๹�췽��Ҫע�⣺
			1.���������Ĺ��췽����û��ָ�����ø���Ĺ��췽����
			  ��ôjava���������ڹ��췽������� super(); ��䡣
			2.super ���ø��࣬�����๹�캯���б����ǵ�һ�����

super ������������๹�췽����


	
	this();ָ�������޲εĹ��췽��
	super();//ָ�����ø����޲ι��췽��

	1.�������ǵ�һ����� �� �����������췽��
	2.������ͬʱ������ ͬ�����캯����
	3.super ���ڼ̳й�ϵ ���������๹�췽���� ���ø���       extends
	  this  ָ�Ķ��� ���� �� ��Ա����
	
	String name��
	public String name(String name){   // �βκͱ�������ͬ ��Ҫ��this ����
	this.name = name 
	}










*/


class Fu
{   int x = 10;
    public void eat(){
		System.out.println("С͵������...");
	}
}

class	Zi extends Fu 
{	int x = 20;

	public void print(){
		//this();ָ�������޲εĹ��췽��
		//super();//ָ�����ø����޲ι��췽��
		super.eat(); //�������ظ�ʱ������ǰ���super ��ֱ�ӷ��ʸ���� eat  .
		System.out.println("x = "+super.x);
	}                         
	public void eat(){
		System.out.println("����������...");
	}
}

class  Super
{
	public static void main(String[] args) 
	{
		Zi z = new	Zi();
		z.print();
	}
}



/*
------------------����----------------------
----------------�м̳й�ϵ�ſ�����----------
 
���⣺���෽���޷�����ʱ

�������أ� ��һ������ �����������������ϵ�ͬ��������������������

����Ҫ��
		1.������Ҫһ��
		2.�β��б�һ��(�βεĸ��� �� �βε����Ͳ�һ��)
		3.�뷵��ֵ�����޹�

��дע�⣺
		1.���������β��б����һ�¡�
                xxx eat(){xxx}
		2.�����Ȩ�����η����� ���ڵ��� �����Ȩ�����η�
		3.����ֵ���� С�ڵ��� ���෵��ֵ
		4.�����׳��쳣����ҪС�ڵ��ڸ����׳��쳣����
			Exception(�) (E sa sen)
			RuntimeException(С��) (luntai E sa sen) 
		

*/
----------------------this �ؼ���---------------------------------
class Fu
{	String name;
	
	public Fu(String name){
		this.name = name ;
	}

	public void eat(){
		System.out.println(name+"��֪���ܴ�������...");
	}
}

class Zi extends Fu
{	String num;
	public Zi(String name){
		super(name);
	}

	//��д����eat����
	public void eat(){
		System.out.println("��");
		System.out.println("��");
		System.out.println("ѧ");
		System.out.println("ϰ");
		System.out.println("��");
	}
}


class Chongzai
{	public static void main(String[] args)
	{
		Zi z = new Zi("�ܶ�");
		z.eat();
	}
}

class Person{
	int id;
	String name;
	int age;
	
	//���캯��
	public Person(int id, String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	//�ȽϺ����ķ���
	public void compareAge(Person p2){
		if(this.age>p2.age)
		{	System.out.println(this.age+":��.");
		} else if (this.age < p2.age)
		{	System.out.println(this.age+":С.");
		} else  
		{	System.out.println(this.age+":���.");
		}
	}
	
}

class this01{
	public static void main(String[] args){
		Person p1 = new Person(100086, "С��", 100);	
		Person p2 = new Person(100086, "С��", 200);
		p1.compareAge( p2);
	}
}

----------------------------------------final ��fai no��-----------------------------------------
/*
	final(���ա����η�)

	  ���ã�
			1.����һ���������͵ı���ʱ���ñ������������¸�ֵ����һ��Ϊ����
			2.����һ�������ͱ���ʱ���ñ�����������ָ���¶���
			3.����һ������ʽ���ú��������Ա���д


���� ��һ�����η��� public static final

*/			"public static final double pi = 3.14" 
			//���� ֻ��һ�� �����޸� 

//԰
class Circle
{ 
	double r;//�뾶

	final double pi = 3.14; //�̶������

	//����Բ�����
	public void getArea(){
		System.out.println("Բ�ε�����ǣ�"+ r*r*pi);
	}
}
class DDemo
{
	public static void main(String[] args) 
	{
		/*	final Circle  c = new Circle(4.0);
		//�ڶ�������
		*/	test(c);
	}

	public static void test(Circle c){
		c = new Circle(5.0); //��������ָ�����¶���
	}
}


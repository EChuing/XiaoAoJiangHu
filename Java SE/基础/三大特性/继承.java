�̳�
	
	��ʽ�� class ����1 extends ����2{
			}
	
	ע�⣺
		1.����˽�ж���ĳ�Ա���ܱ��̳�
		2.���๹�캯�����ܱ��̳�
		3.�����������ʱ��Ĭ�ϻ��ȵ��õ��޲ι��캯����Ȼ���������Ĺ��캯��


�޲ι��췽��Ĭ�ϻ��Զ�����  (���Բ�д)   ���Ǵ��η��� ��һ��Ҫд�� ��ķ����� super() 


--����--
class Fu
{	String name;

	public  Fu(String name){
		this.name = name;
		System.out.println("Fu���ε���..................");
		
	}

	public Fu(){
		System.out.println("Fu�޲α�����");
		
}
		//extends �̳�
class Zi extends Fu{  //  ����  ����(���� ����)
	public Zi(String name){
		super(name); 
	}
}

class Love6  // �̳�ע��
{
	public static void main(String[] args) 
	{	Zi b = new Zi("�ܴ�");
		System.out.println("���֣�"+ b.name);
	}
}
? : 
����Ĺ��췽�������û����ȷ�ĵ��ø���Ĺ��췽��,
Ĭ�ϵص��ø���Ĳ��������ķ�����

�����ж�����˲����Ĺ��췽������û�ж��岻�������Ĺ��췽��,��ϵͳ����Ĭ��Ϊ�䴴�������������Ĺ��췽��
����������õ�ʱ���Ȼ�ͳ���

����ʱ ���ȵ��ø���ķ��� ���������ķ���




--


//��ͨ��ѧ��     extends  �̳�     ex tens
class student
{	
	String name;	

	public student(String name){
		this.name = name;		
	}
	public void study(){
		System.out.println(name+"�����˼��������");
	}
}
//�������ѧ���е���
class BaseStudent extends student
{	
	public BaseStudent(String name){
		super(name);//ָ�����ø��๹�캯��
	}

	//��д
	public void study(){
		System.out.println(name+ "ѧϰjavase..");
	}
}

class WorkStudent extends student
{	//���� ����
	public WorkStudent(String name){
		super(name);//���ø���һ�������Ĺ��췽��
	}
	//��д
	public void study(){
		super.study();
		System.out.println(name+ "ѧϰjavase+android..");
	}
}

class  Demo11
{
	public static void main(String[] args) 
	{   //��ͨ��ѧ��
		BaseStudent s = new BaseStudent("��С��");
		s.study();
		//��ҵ��ѧ��
		WorkStudent w = new WorkStudent("�ϰ�");
		w.study();
	}
}




class Love1
{     public static void main(String[] args){
          Car c = new Car();
		  //��������������ֵ
		  c.name = "��������";
		  c.color = "�ٻ�";
		  c.wheel = 4;

		  for(int i = 0; i<7;i++){
		      c.run();
		  }c.wheel = 3;
		   c.run();

		   //�����޳�������
		CarFactory f = new CarFactory();
		//���޳�����������ֵ
		f.name = "��Ⱥ���޳���";
		f.address = "��̩��ҵ�㳡һ¥";
		f.tel = "020-1234567";

		//�����޳����޳�
		f.repair(c);//0x98
		//
		c.run();}
		
			 

}
//����
class Car
{
	//����Ĺ�������
	String name; //����
    String color; //��ɫ
	int wheel; //������

	//����Ĺ�����Ϊʹ�ú�������
	public void run(){
	  if(wheel>=4){
	     System.out.println(name+ color+ "�����ӵĳ� �ɿ����������");
		 }else{
		  System.out.println("���"+ name+ "���������ӣ������ȥ�޳���");
		 }      
	}
}
//����
class CarFactory
{    String name;//����
     String address;//��ַ
	 String tel;    //�绰

     //�޳�������Ϊ
     public void repair(Car c){
	   if(c.wheel>=4){
		   System.out.println("��ĳ������˺ܾò��޺ã���Ҫ������ˮ�� ");
	   }else{
	       c.wheel=4;
		   System.out.println("�Ѿ��޺��ˣ���Ǯ����");
		   System.out.println("�в��а��� Ҫ�����˿�� ");
	   }
	 }
}

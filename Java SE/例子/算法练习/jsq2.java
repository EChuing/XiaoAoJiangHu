import java.util.*;
class Calculator
{	//System.out.println("������2������");


		Scanner scanner = new Scanner(System.in);
                int moore =scanner.nextInt();
                char moo = scanner.nexchar();

	private int num1 = moore ;   
	private int num2 = moore ;


        //System.out.println("������Ҫ���㷽��");
	private char option = moo ;

	//�ṩ�����ķ�������ֵ....
	public void initCalculator(int n1, int n2, char a){
		num1 = n1;
		num2 = n2;
		if(a== '+'|| a== '-'||a == '*'||a == '/'){
			option = a;
			}else{
				option = '+';
			}
		}
	// ���㹦��
	public void calculate(){
		switch(option = moo){
			case '+':
				System.out.println("�ӷ�,����ǣ�"+ (num1+num2));break;
			case '-':
				System.out.println("����,����ǣ�"+ (num1-num2));break;
			case '*':
				System.out.println("�˷�,����ǣ�"+ (num1*num2));break;
			case '/':
				System.out.println("����,����ǣ�"+ (num1/num2));break;
		}
	} 
}


class jsq2 
{
	public static void main(String[] args) 
	{	//����һ������������
		Calculator c = new Calculator();



		//��������ֵ
		c.initCalculator();
		//���ü������Ĺ���
		c.calculate();
		//System.out.println("�������н���������");
	}
}

import java.util.*;
class Calculator
{	//System.out.println("请输入2个数字");


		Scanner scanner = new Scanner(System.in);
                int moore =scanner.nextInt();
                char moo = scanner.nexchar();

	private int num1 = moore ;   
	private int num2 = moore ;


        //System.out.println("请输入要计算方法");
	private char option = moo ;

	//提供公共的方法属性值....
	public void initCalculator(int n1, int n2, char a){
		num1 = n1;
		num2 = n2;
		if(a== '+'|| a== '-'||a == '*'||a == '/'){
			option = a;
			}else{
				option = '+';
			}
		}
	// 计算功能
	public void calculate(){
		switch(option = moo){
			case '+':
				System.out.println("加法,结果是："+ (num1+num2));break;
			case '-':
				System.out.println("减法,结果是："+ (num1-num2));break;
			case '*':
				System.out.println("乘法,结果是："+ (num1*num2));break;
			case '/':
				System.out.println("除法,结果是："+ (num1/num2));break;
		}
	} 
}


class jsq2 
{
	public static void main(String[] args) 
	{	//创建一个计算器对象
		Calculator c = new Calculator();



		//设置属性值
		c.initCalculator();
		//调用计算器的功能
		c.calculate();
		//System.out.println("程序运行结束！！！");
	}
}

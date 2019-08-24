// 静态 与 非静态 之间的调用


非静态可以调用静态函数 

一般情况下 静态不能调用静态函数 
却可以用新建类方法来实现 静态调用非静态方法   如下：
class  Demo
{
	public static void main(String[] args) 
	{	
		int a=56,b=69,c;

		//静态调用非静态
		Demo D = new Demo();
		c = D.XJ(a,b);
		//c = (new Demo()).XJ(a,b);   一句话表示

		System.out.print(c);
	}
	public int XJ(int x,int y){
	return x-y;
	}
}

-------------------------------------------------------------

class  Demo
{
	public static void main(String[] args) 
	{	
		int a=56,b=69,c;

		//同为静态可以相互调用
		c = XJ(a,b);


		System.out.print(c);
	}
	public static int XJ(int x,int y){
	return x-y;
	}
}


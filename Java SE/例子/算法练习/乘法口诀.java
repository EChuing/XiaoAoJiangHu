//-------------------------编写乘法口诀-----------------------------

class Demo001
{	public static void main(String[]  agse)
	{
		innt(9);  // 乘法的倍数
		System.out.println("结束");
	}
	//方法
	public static void innt(int toou)
	{
		for (int i = 1 ; i<=toou ; i++ )
		{	for ( int j = 1; j<=i ; j++ )
				{	//System.out.println(j+"*"+i+"="+j*i+"\t");          区别 println 和 print   多个 ln 却自带换行
				    System.out.print(i+"*"+j+"="+i*j+"\t");
				}//换行
		        System.out.println();
		}
	}
}

/*	
	//需求2： 定义一个函数打印一个乘法表，不需要返回任何数据。 
	public static void  innt(int run){
		for(int i = 1 ; i<= run ; i++){
			for (int j = 1 ;j<=i  ;j++ ){
				System.out.print(i+"*"+j+"="+i*j+"\t");
			}
			//换行
			System.out.println();
		}
	}
}
*/
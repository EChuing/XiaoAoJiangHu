package name;




public class name{
	public static void main(String[] args) {
		int i = 1 ; 
		int j = i++ ;  //  j = 1 ; i = 2
		if((i==(++i))&&((i++)==j)){
			i +=j;
		}
		
		System.out.println(i);  //i = 3
	}
}


int 类型 最大值为 2147483647     最小值为 -2147483648
					2147483647+2=  -2147483647


	%  ：  除法取余数
	0/10   等于0 不报错
	10/0   除于0 的都会报错



	switch 适用的数据类型： byte \ char \ short \ int \ String
						\ 还有 枚举类型
						
					

//季节枚举类

enum Season{
	spring, summer, autumn , winter
	//春    	夏		秋		冬
	
}

public class Demo{
	
	public static void main(String[] args){
		Season season = Season.winter;
		switch(season){   //判断的时候就确定 类别
		// 注意：case后面 
		case spring:
			System.out.println("春...");
			break;
		// 只要写枚举值 不用写是属于那个类的       Season.summer
		case summer:
			System.out.println("夏...");
			break;
		case autumn:
			System.out.println("秋...");
			break;
		case winter:
			System.out.println("冬...");
			break;
			
			
		}
		
		
	}
}
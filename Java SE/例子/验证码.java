//编写验证码


package cn.itcast;

import java.util.Random;
												//		just friends?

public class Love6 {
	public static void main(String[] args){
			char[] arr={'a','b','c','d','e','f','g'};      //(beU  de)
			StringBuilder sb = new StringBuilder();   // 字符缓冲器
			Random random = new Random();   //产生随机数

			//需要四个随机数，通过随机获取字符数组中的字符
			
			for(int i =0;i<4;i++){
				int index = Random.nextInt(arr.length);  
				//随机产生 arr中 的数字
				sb.append(arr[index]);
				
			}
			System.out.println("验证码："+sb);
	}
}


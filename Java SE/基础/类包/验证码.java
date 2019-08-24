package cn.itcast;

import java.util.Random;
												//		just friends?

public class Love6 {
	public static void main(String[] args){
			char[] arr={'a','b','c','d','e','f','g'};      //(beU  de)
			StringBuilder sb = new StringBuilder();   // 字符缓冲器  容器填满是 就不断扩大 起缓冲
			Random random = new Random();   //产生随机数      (wen de)

			//需要四个随机数，通过随机获取字符数组中的字符
			
			for(int i =0;i<4;i++){
				int index = Random.nextInt(arr.length); // Random在 （遍历arr的元素） 中，随机产生一个数 
			
				sb.append(arr[index]);//append   使  随机产的数字 连接起来到sb容器中
				
			}
			System.out.println("验证码："+sb);
	}
}

建立：数组（已知）,随机数（自动生成）,存放容器（可随意大小）
			arr     Random               StringBuilder        
 
循环控制 获取数组里的随机字符
i<4				index   Random.nextInt（）     arr.length

拼接字符到 sb中
sb.append(arr[index]);
	
 
输出结果

扩展：


append(boolean b)   可以添加任意类型  数据到容器中 形成新的字符串

nextInt( n )将返回一个大于等于0小于n的随机数。  Random 的方法

package cn.itcast;


键盘输入 求闰年，100以内
---------------------------------------------------

import java.util.Scanner;
public class Demo {
    public static void main(String args[]) {
        int num = 0;        
        Scanner scanner = new Scanner(System.in);
		int scan = scanner.nextInt(); 
        for(int i=scan;i<=scan+100;i++){
            // 可以被4整除，不被100整除    或者     可以被400整除的是闰年
            if((i%4==0&&i%100!=0)){ //  10%3 = 1  取余数
        		num++;
                if(num%2==0){
                    System.out.print(i+" ");
                }else{
                    System.out.print(i+" ");
                }
            }
        }
    }
}
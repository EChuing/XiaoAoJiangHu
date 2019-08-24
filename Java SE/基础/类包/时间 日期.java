package cn.itcast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


日期类    	Date				(deite)
		Calendar
		
		
日期格式化类
		SinpleDateFormat   	(sinde deite feme) 
		
		作用：
			可以把  日期	转换为指定格式的字符串   	format()
			可以把  一个字符串	转化为对应的日期	parse()
		
		默认格式: SimpleDateFormat	dateFormat	= new SimpleDateFormat("输出格式");



public class Love4 {
	
	public static void main(String[] args) throws ParseException {
	/*
	Date date = new Date();							//获取当前系统时间
	System.out.println("年份"+date.getYear());
	*/
	/*
	Calendar calendar = Calendar.getInstance();             	// 获取当前时间
	System.out.print(calendar.get(Calendar.YEAR)+"年");		 	//年
	System.out.print((calendar.get(Calendar.MONTH)+1)+"月");   	//月份必须要+1  
	System.out.print(calendar.get(Calendar.DATE)+"日");			//日
	System.out.print(calendar.get(Calendar.HOUR_OF_DAY)+"时");	//时
	System.out.print(calendar.get(Calendar.MINUTE)+"分");		//分
	System.out.println(calendar.get(Calendar.SECOND)+"秒");		//秒
	*/
	
	
	//显示当前系统时间    ：  2014年12月26日xx时xx分xx秒
	/*		默认
	Date date = new Date();//获取当前系统日期
	SimpleDateFormat	dateFormat	= new SimpleDateFormat();
	String time = dateFormat.format(date);
	System.out.println("当前的系统时间："+time);
	// 默认格式为        	          当前的系统时间：16-5-20 下午9:29
	*/
	 //   	重写 
	Date date = new Date();										
	SimpleDateFormat	dateFormat	= new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");// 重写 指定格式
	String time = dateFormat.format(date);
	System.out.println("当前的系统时间："+time);
	

	
	String birthday = "2000年12月26日  11:29:08";//注意格式  少个空格都不可以
	Date date2 = dateFormat.parse(birthday);  //注意： 指定的字符串格式必须要与   SimpleDateFormat   的模式要一致。
	System.out.println(date2);
	
	
	Date date21 =new Date();
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
	String time2 =dateFormat.format(date21);
	String time21=dateFormat.format(date);
	System.out.println("当前的系统时间："+time);
	String birthday1= "2000年12月26日  11:28:08";
	Date date22=dateFormat.parse(birthday1);
	System.out.println(date22);

}
	
	
}

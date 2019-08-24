
package cn.itcast;
/*


int index = path.lastIndexOf("\\");   //  以 "\\" 截取
char[] arr = str.toCharArray(); // 将字符串转换为数组

System 系统
object 对象


*/
public class Love2 
{
	
	public static void main(String[] args) 
	{	
		//问题一
		String str = " 传智  播客    ";
		System.out.println(myTrim(str));
		//问题二
		str = "F:\\Tufo\\Love10.java";
		getFileName(str);
		//问题三
		str = "新中国号！";
		System.out.println("反转后的字符串："+reverse(str));
		//问题四
		str = "abcjavajavaphpjava";  //java 出现的次数
		System.out.println("java出现的次数："+str.indexOf("java"));
		getCount(str,"java");
	}
	
	//统计子串出现的 次数
	public static void getCount(String str,String target)
	{
		int count = 0;//记录出现的次数
		int fromIndex = 0;//记录从哪个索引值开寻找目标子串
		while((fromIndex = str.indexOf(target,fromIndex))!=-1)
		{	
			//如果indeof返回的不是-1，你那么就是已经找到了目标元素
			count++;
			fromIndex = fromIndex+target.length();
		}
		System.out.println("出现的次数："+count);
	}
	
	
	//反转 字符         reverse
	public static String reverse(String str)
	{
		char[] arr = str.toCharArray(); // 将字符串转换为数组
		for(int startIndex = 0, endIndex = arr.length-1;startIndex<endIndex; startIndex++,endIndex--)
		{//       头      				尾	
			char temp = arr[startIndex];
			arr[startIndex]= arr[endIndex];
			arr[endIndex] = temp;
		}	
		//使用字符数组构建字一个符串
		return new 	String(arr);
	}
	
	
	//需求二： 获取上传文件名 "F:\\Tufo\\Love10.java"
	public static void getFileName(String path){
		int index = path.lastIndexOf("\\");   //  以 "\\" 截取
		String fileName = path.substring(index+1); // 指定 结束的索引值
		System.out.println("文件名:"+fileName);
	}
	
	
	//需求1：  实现自己的trim的方法
	public static String myTrim(String str){
		//先转换成字符 数组
		char[] arr = str.toCharArray();
		//定义变量 记录开始与结束 的索引值
		int startIndex = 0;
		int endIndex = arr.length-1;
		//确定开始的索引值
		while(true)
		{
			if(arr[startIndex]==' '){
				startIndex++;
			}else{
				break;
			}
		}
		//确定结尾的索引值
		while(true)
		{
			if(arr[endIndex]==' '){
				endIndex--;
			}else{
				break;
			}
		}
		//截取子串返回
		return str.substring(startIndex,endIndex+1); 
	}	

}

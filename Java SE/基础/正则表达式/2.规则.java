
正则表达式 
主要用于操作字符串 的规则， 正则表达式对字符串的操作主要有以下几种：



匹配:
		matches（）;



切割：
		split();
	
	内容需要被复用 就要被分组   	
	
	分组的目的： 提高正则的复用性



替换 	
	(replaceAll)(String regex, String replacement));
	
	repalceTest()

查找：需要使用 Pattern

		指定为 字符串的正则表达式必须 首先被编译为此类的实例。 然后， 
		可将得到的正则对象匹配的任意的字符串用于创建 Matcher 对象，
		依照正则表达式，该对象可与任意字符序列匹配，   执行匹配所涉
		及的所有状态都 驻留在匹配去中 ，所以多个匹配可以共享同一模式。
		 
			 例如：
   
				   Pattern p = Pattern.compile("a*b");
				   Matcher m = p.matcher("aaaab");
				   boolean b = m.matches();

			查找需要使用到的对象：
					Pattern (正则对象类) 	
					Matcher(匹配器对象)

			匹配要使用到的方法：
					find()	通知匹配器去匹配字符串，  查找符合规则的字符串        找得到就返回 ture 没救 fales
					group()	获取符合规则的子串
			"注意:一定要 先用 find 匹配 ，再用 group 获取"
				

边界匹配符：
		\b：代表 单词的开始或结束字符，  但不匹配任何字符 
		



//匹配
public class Demo{
	public static void main(String[] args){
	//matchesPhone("13538060336");
	//matchesTel("020-38325125");
		testPlit1();
		testPlit2();
	
	}
	
	
	//需求 ：匹配手机号   :只能是1 开头  ，的二位  3 5 4 7 8 .     长度11位
	public static void matchesPhone(String phone) {
		String reg = "1[34578]\\d{9}";
		System.out.println(phone.matches("1[34578]\\d{9}")?"合法手机号":"非法手机号");
		
	}
	//匹配固定电话  区号 + 主机号		区号：首位是0     长度3-4位 主机号：首位非0  长度7-8
	public static void matchesTel(String tel) {
		System.out.println(tel.matches("0\\d{2,3}-[1-9]\\d{6,7}")?"合法电话":"非法电话");
	
	}
	//按照空格切割
	public static void testPlit1() {
		String str = "明       天     放 假";
		String[] datas = str.split(" +");
		System.out.println("数组元素" + Arrays.toString(datas));
	}
	//根据重叠从进行切割    (重复区域删除)
	public static void testPlit2() {
		String str = "大家家家明天天天玩的的的开心"; // 大 明 玩 开心
		String[] datas = str.split("(.)\\1+");  //():分组   \1：第一个分组
		System.out.println("数组元素" + Arrays.toString(datas));
	}



}




//替换
class Demo{
	
	public static void main(String[] args) {
		System.out.println("");
		repalceAll();
		repalceTest2();
	}
	
	//替换
	public static void repalceAll(){
		String str= "电话：13538000362";
		String reg = "1[34578]\\d{9}";
		str = str.replaceAll(reg,"****");
		System.out.println("替换后："+str);
		
		
	}
	//替换   删除多余的重复字符
	public static void repalceTest2(){
		String str= "我我我瑶瑶学学嘻嘻嘻嘻嘻";
		str = str.replaceAll("(.)\\1+","$1");  // $引用组号
		System.out.println(str);
	}
	
	
}


//查找

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Demo{
	
	public static void main(String[] args) {
		//找出三个字母组成的单词
		String content = "da jia de jia qi wang bi liao hai kai xin ma";
		String reg = "\\b[a-zA-Z]{3}\\b";   // 
		//先把字符串的正则编译成Pattern 对象
		Pattern p = Pattern.compile(reg);
		//使用正则对象匹配字符串     会产生一个Matcher 对象
		Matcher m = p.matcher(content);
		/*
		System.out.println("又符合规则的字符串么？"+m.find());
		System.out.println("获取的结果:"+m.group()); // 只有一个  想要所有 循环要用
		*/

		//利用循环吧符合的 都获取出来
		while(m.find()){
			System.out.println(m.group());
		}
		
		
	}

}
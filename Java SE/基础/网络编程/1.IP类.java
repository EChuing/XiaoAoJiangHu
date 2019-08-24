
网络编程： 
		1.解决计算机与计算机（手机、平板..）之间的数据传输问题！
		2.不需要基于html网页就可以达到数据之间的传输。 如：QQ feiQ 微信..

网页编程：在html页面的基础上，进行数据的交互。如：珍爱网 、OA（办公自动化）、高考办公系统....


JAVA方向：
			web：可以不用学网络编程
			android： 网络编程常用
		
		
网络通讯三要素：
	IP
	端口号：用于表明该消息是给 那个应用程序处理的。只不过是一个标识符（门牌号）
	协议：用于规定路由器 加密 和 解码

IP地址：本质是 由32位的二进制数据组成的数据，为了方便 把32 位变为 4 份（8位/分）

 IP地址 = 网络号 + 主机号
 
 
IP分类：
 		A 一个网络号+三个主机号	2^24	政府
 		B 两个网络号+两个主机号	2^16	事业单位（教育网  银行）
 		C 三个网络号+一个主机号	2^8		私人
		
InetAddress(IP类)   in tene jue s

常用方法：
	getLocalHost()		获取本机IP地址对象
	getByName()			根据一个 IP字符串（地址） 或 一个主机名 ，生成一个IP对象

	getHostAddress()	返回一个IP地址的字符串表示形式
	getHostName()		返回计算机的主机名
	
	
	
					


public class Demo{							// 防止 本机没装网卡而获取不到IP地址
	public static void main(String[] args) throws UnknownHostException {
	
	  	//获取本机IP地址对象   (e jue s)   (lougou ho sit)
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("IP地址："+address.getHostAddress());
		System.out.println("IP地址："+address.getHostName());
		
	
		//根据别人的机器获取IP地址
		//可以根据一个IP地址的字符串形式 或 一个主机名 生成一个IP地址对象
	//	InetAddress address = InetAddress.getByName("IP字符串 或 主机名"); //建议不使用主机名
	
	
		InetAddress[] arr = InetAddress.getAllByName("www.baidu.com");// 写：IP地址 主机名  域名
		System.out.println("IP地址："+arr.length);
		
	}
	
}

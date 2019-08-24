
自定义异常类

需求： 描述QQ没有网络， 有网络就正常显示好友列表

//定义一个没有网线的异常
class NoIpException extends Exception{
	
	public NoIpException(String message){
			super(message);//调用 Execption 一个参数的构造函数。
	}
	
	
}


class Love13
{
	public static void main(String[] args) 
	{	
		String ip = "192.168.10.100";
	//	ip = null;
		try{
			QQ(ip);
		}catch(NoIpException e){
			e.printStackTrace();
			System.out.println(" 捕获 连接网线中... ");
		}
	}
 
	public static void QQ(String ip)throws NoIpException{
		
		if(ip==null){
			throw new NoIpException("没有网络...");
		}
		System.out.println("正常显示好友列表..");
	}
}

/*
需求： 模拟你去吃木桶饭，如果带钱少于了10块，那么久抛出一个没带钱的异常对象。
		如果带够了钱，那么你就可以去吃饭。
*/
//没钱的异常
class NoMoneyException extends Exception{
	public NoMoneyException(String message){
	super (message);
	}
}

class  Love14
{
	public static void main(String[] args) 
	{	
		try{
		eat(1);
		}catch (NoMoneyException e){                   // 这里面开始写 自己的处理方式
			e.printStackTrace(); //打印异常信息
			System.out.println("给我扫一个月的地");
		} 
		System.out.println("没有出现异常...");
	}
	public static void eat(int money)throws NoMoneyException{        throw-throws ：遇到异常，抛出给 记得在声明出写 throws 
		if(money<10){												 try-catch 捕获可能出错的异常， catch 写处理方式
			throw new NoMoneyException("小贼，敢吃霸王餐...");
		}
		System.out.println("乐 正在吃饭...");
	}

}

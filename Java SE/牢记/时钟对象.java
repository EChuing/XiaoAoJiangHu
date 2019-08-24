/* 四种对象  练习 

对象 = 属性 + 功能

*/ 
== Display ==
package clock;

public class Display
{
	private int value = 0 ; 
	private int limit = 0 ;

	public Display(int limit){
		this.limit=limit;
	}

				//（in kui si ）增加
	public void increase（）{
		value++;
		if(value == limit){
			value =0 ;
		}
	}                 
	
	public int getValue(){
		int i;
		return value;
	}
	public static void main(String[] args){
		Display d = new Disp(24);
		for(::){
			d.increase();
			System.out.println(d.getValue());
		}
	}

}  




== Clock ==
package clock;

public class Clock{
	private Display hour = new Display(24);
	private Display minute = new Display(60);

	public void start(){
		while(true){
			if(minute.getValue() == 0){
				hour.increase();
			}
			System.out.println("%02d:%02d\n",hour.getValue(),minute.getValuer());
		}
	}
	
	public static void main(String[] args){
		Clock clock = new Clock();
		clock.start();
	}

}

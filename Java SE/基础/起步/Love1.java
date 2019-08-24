


class Love1
{     public static void main(String[] args){
          Car c = new Car();
		  //给车对象赋予属性值
		  c.name = "兰博基尼";
		  c.color = "橘黄";
		  c.wheel = 4;

		  for(int i = 0; i<7;i++){
		      c.run();
		  }c.wheel = 3;
		   c.run();

		   //创建修车厂对象
		CarFactory f = new CarFactory();
		//给修车厂赋予属性值
		f.name = "集群宝修车厂";
		f.address = "韵泰商业广场一楼";
		f.tel = "020-1234567";

		//调用修车的修车
		f.repair(c);//0x98
		//
		c.run();}
		
			 

}
//车类
class Car
{
	//事物的公共属性
	String name; //名字
    String color; //颜色
	int wheel; //轮字数

	//事物的公共行为使用函数描述
	public void run(){
	  if(wheel>=4){
	     System.out.println(name+ color+ "个轮子的车 飞快的跑了起来");
		 }else{
		  System.out.println("你的"+ name+ "不够个轮子，快点送去修车厂");
		 }      
	}
}
//修理厂
class CarFactory
{    String name;//名字
     String address;//地址
	 String tel;    //电话

     //修车公共行为
     public void repair(Car c){
	   if(c.wheel>=4){
		   System.out.println("你的车我修了很久才修好，我要加收油水。 ");
	   }else{
	       c.wheel=4;
		   System.out.println("已经修好了，给钱！！");
		   System.out.println("行不行啊， 要不就退款吧 ");
	   }
	 }
}

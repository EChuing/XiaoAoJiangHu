class  Baby
{ 
	int id; //身份证
	String name ;//名字
    public Baby(int i, String j){
		id = i;
		name = j;
		System.out.println("程序1运行成功");
	}

	public Baby(){System.out.println("程序2运行成功");}
	public void cry(){
		System.out.println("宝宝瓜瓜的哭了.");
	}
}
class Love5  // 构造函数
{
	public static void main(String[] args){
		//创建一个对象
		Baby b1 = new Baby(110, "条子");
		System.out.println("编号:"+ b1.id +     "姓名:"+ b1.name);

		//黑户
		Baby b2 = new Baby();
		b2.id = 112;
		System.out.println("编号："+ b2.id +"姓名"+ b2.name);
	}
}
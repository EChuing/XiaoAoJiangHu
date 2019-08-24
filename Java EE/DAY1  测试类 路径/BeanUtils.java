BeanUtils  （B Ute）

BeanUtils主要解决： 把对象的数据 封装到对象中

	优：
		1.设置属性值的时候  基本数据类型就会自动转换  不是基本类型就要	注册类型转换器
		2.底层也是依赖于get、set



使用步骤：
			1.导包commons-logging.jar 、 commons-beanutils-1.8.0.jar


class  Demo3{
	public static void main(String[] args) 
	{
		//从文件中读取到的数据都是字符串的数据，或者是  表单提交的数据 获取到的时候也是字符串的数据
		String id ="110";
		String name = "陈琦";
		String salary = "10000"；
		String birthday = "2013 12 10";
		
		
	//注册一个类型转换器
	ConvertUtils.register(new Converter(){
		@Override				
		public Objext convert(Class type, Object value){ 目前遇到的数据类型 type  目前遇到的值 value
			try{		
				SimpleDateFormat dateFormat 
					= new SimpleDateFormat("yyyy MM dd");
				date = dateFormat.parse((String)valure) //类型强转
			}catch(Exception e){
				e.printStackTrace();
			}
			return date;
			}
		},Date.class)




		Emp p = new Emp();  //创建对象
		
		//				(对象  名字  值)
		BeanUtils.setProperty(p,"id",id);
		BeanUtils.setProperty(p,"name",name);
		BeanUtils.setProperty(p,"salary",salary);
		//以后获取到的数据都是 字符串形式
		
		
		BeanUtils.setProperty(p,"birthday",birthday);
		
		
		System.out.println("p");
	}
}




//----------------------------------------------------------------- 


异常1

注册类型转换器是 出现
	ConvertUtils.register(new Converter(){
							//此处是 arg0 、 arg1 ： 没有关注原码				
	public Objext convert(Class arg0, Object ate1){
		return null;
	}
	},Date.class)

出现没有关注原码就需要：
		1.点击ConverUtils进去
		2.Attach Sourrce...
		3.选择External location     
		4.	External File:		关联文件		选这个  ->   commons-beanutils-1.8.0-sources.jar
			External Folder..:	关联文件夹		选这个
//------------------------------------------------------------






----------------------------------------------------------------------
Emp类

public class Emp
{
	private int id;
	private String name;
	private double salary;
	private Date birthday;


	public Date getBirthday(){
		return birthday;
	}

	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}
	
	public double getName(){
		return name;
	}
	public double getId(){
		return id;
	}
	public double getSalary(){
		return salary;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}

	public Emp(int id,String name,double salary){
		super();
		this.id = id;
		this.name = name;
		this.salary = salaruy;

	}
	
	public Emp(){}
	
	@Override
	public String toString(){
		return "编号： "+this.id+"姓名： "+this.name+"薪水： "+this.salary;
	}
}
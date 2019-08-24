以后我们开发框架的时候 ， 我们经常需要把一些数据封装到对象中的。


需求：编写一个工厂方法根据配置文件的内容， 工厂方法返回对应的对象，并且对象要有对应属性


-----------------------------------------------------------------------
-- 运用反射来实现   ？

public class Demo
{
	public static void main(String[] args)throws Exception {
		Person p = (Person) getInstance();
		System.out.println(p);
	}
	
	//根据配置文件的内容产生生产对象的对象 并且把对象的属性值封装到对象中。
	public static Object getInstance(){
		BufferedReader bufferdReader = new  BufferedReader("obj.txt");
		String className = bufferedReader.readLine();//将配置文件获取到完整的类名。
		Class clazz = Class.forName(className);
		Constructor constructor = clazz.getConstructor(null);
		//创建对象
		constructor.newInstance(null);
		Object o = constructor.newInstance(null)
	
		//读取属性值
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			String[] datas = line.split("=");  //切割对象
			//通过属性名获取到对应的Field对象。
			Field field = clazz.getDeclaredField(datas[0]);//getDeclaredField() 防止私有		
		if(field.getType()==int.class){
			field.set(o,Integer.parseInt(datas[1]));
		}else{
			field.set(o,datas[1]);
		}
		return 0;
	}
}

-----------------------------------------------------------------------
-- 内省   -> 一个变态的反射

主要解决的问题： 把对象的属性数据封装到对象中


public class Demo2{

	public static void main(String[] args){
		//Introspector 内省类   获取所有属性            
													(类名)		
		BeanInfo beanInfo = Introspector.getBeanInfo(Person.class); get bin info
		//通过BeanInfo获取所有的属性描述器
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
	   (pe loufe dikuapen te)
		 
		for(propertyDescriptor p : descriptors){
			System.out.println(p.getReadMethod());//get方法
		}
		// 最后输出 所有get方法的属性描述！！
	}



	@Test
	public static void testProperty(){
		Person p = new Person();
		//属性描述器								//（那个属性  那个类）					
		PropertyDescroptor descroptor = new PropertyDescroptor("id",Person.class);
		//获取属性对应的get或者是set方法中的属性了
		Method m = descriptor.getWriteMethod();					//获取属性的set方法
		//执行该方法设置属性
		m.invoke(p,110);   
							/*验证：设置结果
							
							System.out.println(p);
							或者

							Method readMethod = descroptor.getReadMethod();  // 获取属性的get方法
							System.out.println(readMethod.invoke(p,null));
							*/		
	}
}


















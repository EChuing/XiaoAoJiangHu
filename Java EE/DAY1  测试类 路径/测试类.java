junit导包：
	将junit导入 lib文件夹里 -> Build Path -> Add to Build Path   
	就会自动引入 引用架包里



junit使用注意：
	1.使用junit测试一个方法时，在junit窗口上显示绿条那么表示正确
											   显示红条表示异常不通过			
	2.右键方法名、类名、包名、工程名运行junit分别测试对应中的Test方法，工程对应所有的Test方法
	3.@Tese 测试 不能是static修饰 ， 不能带有形参
	4.测试一个方法时候，需 准备测试的环境或清的理环境  那么可以用：
				准备  清理  
				@Before  @After  每个测试的时候都会调用一次
必须是static	@BeforeClass @AfterClass 多个测试 只会调用一次
		

junit使用规范：
	1.测试一个类 ： 类被测试类名 + Test
	2.测试一个方法 ： test + 被测试的方法名


Test （ta site）  测试


public class Demo1{
	
//正规的写法 ， 现实开发中不会这样写
	
	@Test   // 方法名上加@..注解     ->右键方法名 Run As  -> JUnit Test
	public void testGetMax(){
		int a = 3;
		int b = 5;
		int max = a>b?a:b;
		return max;
	
	}
}

public class Demo2{
	/*
	@BeforClass  
	@AfterClass
	这两个需要 static 才能使用
	*/
	//准备测试环境
	@Before
	@BeforClass  
	public  static void beforeRead(){
		System.out.println("准备测试环境成功....");
	}
	
	//读取文件数据
	@Tese
	public void readFile() Throws IOException{
		FileInputStream file = new FileInputStream("F:\\a.txt");
		System.out.println("内容："+content);
	}

	//清理测试环境的方法
	@After
	@AfterClass   
	public static void  afterRead(){
		System.out.prinltn("清理测试环境.....");
	}

}
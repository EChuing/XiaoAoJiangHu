需求分析
	功能分析：
			1.添加联系人
			2.修改联系人
			3.删除联系人
			4.查询联系人
	功能流转
	美工设计

需求设计
	设计实体（抽象实体）
			class Contact{
				private String id ;
				private String name ; 
				private String gender ;  ( juan de )  性别
				private int  age ; 
				private String phone ;
				private String email ;  
				private String qq ;		
			}
	设计数据库
		contact （con tex）
			<contctList>
				<contact id="1">
					<name>张三</name>
					<gender>男</gender>
					<age>20</age>
					<phone>13433334444</phone>
					<email>zs@qq.com</email>
					<qq>43222222</qq>
				</contact>
			</contctList>
	设计涉及的接口
		DAO接口（数据访问对象）：实体对象的CRUO方法
		原则：通常 一个实体对象对应一个DAO接口和一个DAO实现类
		interface ContactDao{
			public void addContact(Contact contact);   //添加联系人
			public void updateContact(Contact contact);//修改联系人
			public void deleteContact(String id);//删除联系人
			public void List<Contact> findALL();//查询所有联系人
			public Contact findByld(String id); //根据编号查询联系人
		}
	设计项目结构
		项目名称： contactSys_web
		目录结构：
			|- contactSys_web
				|-src							(an teti )实体
					|-gz.itcast.contactSys_web.entity : 存放实体对象
					|-gz.itcast.contactSys_web.dao : 存放dao的接口
					|-gz.itcast.contactSys_web.dao.impl: 存放dao的实现类
					|-gz.itcast.contactSys_web.servlet: 存放servlet的类
					|-gz.itcast.contactSys_web.test: 存放单元测试类
					|-gz.itcast.contactSys_web.util: 存放工具类
					|-gz.itcast.contactSys_web.exception: 存放自定义异常类
				|-WebRoot
					|-html文件
					|-images：目录。存放图片资源
					|-css：目录。存放css资源
					|-js：目录。存放js资源
							
编码实现
	开发顺序：
	设计数据库-> 实体 -> DAO接口，DAO实现-> Servlet+html页面

功能测试（测试攻城狮）	

性能测试（测试攻城狮）

部署上线（实施攻城狮） 

维护阶段（实施攻城狮）





软件设计原则： 开闭原则
				对修改关闭   
				对扩展开放





'综合案例       注册登录、增删改查---contact_xxxx
	需求分析
		登录、注册、注销
		登录成功
			显示所有员工
	设计						---技术骨干的工作
		数据库设计
			admin，存放所有的登录用户
			employee，存放所有员工信息
		系统设计
			1.系统结构
				分层：基于mvc模式的分层
			2.项目用到的公共组件、类



cn.itcast
	|dao	数据库访问层，接口设计
		|impl	数据库访问接口层实现
	|entity	实体类设计  （id user pass）
	|exception	异常存放包（自定义异常类）
	|service	业务逻辑层（调用方法之类的）
		|impl	业务逻辑层实现（登录 注册）
	|servlet	控制层 （了解web.xml）
	|utils	抽取共同代码块




'综合案例    分页查询功能---Demo2         由下至上 （先设置好数据库）
	0.环境的准备
		a）引入jar文件 and 配置文件
				 i.  数据库驱动包
				ii.  C3P0连接池.jar and  配置文件
			   iii.  DBUtils组件：
		b）公共类： JdbcUtil.java
	1.先设计:PageBean.java     -- 工具类
	2.Dao接口的设计/实现：  2 个方法
	3.Service/servlet
	4.JSP


	分页功能：
			-- 分页查询   ( 理解当前页 )
			-- limit    一参：  查询的其实行（从0开始）
			-- limit    二参：  显示出来的行数

			-- 每页显示4条

			-- 第一页    0 是起始行（不显示）   
			SELECT * FROM demo LIMIT 0 , 4
			-- 第二页
			SELECT * FROM demo LIMIT 4 , 4
			-- 第三页 
			SELECT * FROM demo LIMIT 8 , 4 



'综合案例        ---登录后的功能
	登陆权限判断
		登陆， 提交到登陆Servlet处理其业务！
		-登陆成功, 跳转到首页，显示欢迎信息 + 列表信息
		-登陆失败，跳转到登陆！

	要求：
		只有登陆后，才可以访问首页, 显示列表
		如果没有登陆，直接访问首页列表，要跳转到登陆!

		实现思路：
			|Login.jsp   登陆页面
			|List.jsp     列表显示
			|LoginServlet.java   登陆处理servlet
			|IndexServlet.java   首页列表查询Servlet
			|LoginFilter.java     登陆验证过滤器

	表格
		admin存储登陆用户, 登陆用
		employee 存储员工信息，列表显示用！
		)



	'实现步骤：
			建库、建表、建项目、引入jar文件 及配置文件
			entity   ‘"-- 有2个实体类  一个实体类对应着 一张表
				Admin.java
				Employee.java
			Dao
				AdminDao
				EmployeeDao
			Servcie
			Servlet
			Jsp

http://localhost:8080/emp_sys/login.jsp   可以直接访问
http://localhost:8080/emp_sys/login      可以直接访问
http://localhost:8080/emp_sys/index   不能直接访问
http://localhost:8080/emp_sys/list.jsp   不能直接访问







"综合项目 (点餐王)    
	
	
	时间：（若一个月完成）
	需求分析：  （  占 1/3 的时间）
				《需求分析说明书.doc》
	设计数据库
	编码   （5天左右）数据库出来就可以编写代码

	
	项目开发生命周期
		软件项目开发模式
			|螺旋式开发    一层一层（低成本）
				适用于项目前期部分需求不确定的情况，
				对每一个模块一个个开发：分析、设计、编码、测试、上线

				好处：降低软件项目的风险 （做出的产品要尽量满足客户的需求）
			
			|瀑布式开发		一条直线 （成本高）
				先进行所有模块的需求分析，当分析结束后，才进入项目，
				即：设计、编码、测试、上线

				有点：更容易进行项目把控，即项目质量控制
				用于超大型，对项目需求非常高   模块有问题就可以对模块进行修改   例如：涉及国家安全，飞机等


	'1.需求分析：
		软件工程师：了解需求的途径？
			1.需求文档
			2.项目小组 
					开发经理 - 技术
					项目经理 - 需求（项目的把控）
					需求分析师 - 也是分析   （ 一般没有这一层 ）
			3.项目系统模型的原型   （ 美工设计师 ）
			（4.客户） - 大牛公司才有





	'2.数据库设计

	-- 创建数据库
		CREATE	DATABASE hotel CHARACTER SET utf8;

		USE hotel;

	-- 1 餐桌表		
		CREATE TABLE dinnerTable(
		id INT PRIMARY KEY AUTO_INCREMENT,   	-- 餐桌主键
		tableName VARCHAR(20),			-- 餐桌名
		tableStatus    INT DEFAULT 0,    	-- 餐桌状态   0 ：空闲   1：预定
		orderDate DATETIME			-- 预定时间
		);


	-- 2.菜类表		
		CREATE TABLE foodType(  -- pai meru ke ,odou in pemen
		id INT PRIMARY KEY AUTO_INCREMENT,    	-- 类别主键
		typeName VARCHAR(20)			-- 类别名称	
		);


	-- 3.菜品种表	
		CREATE TABLE food(
		id INT PRIMARY KEY AUTO_INCREMENT,	-- 主键
		foodName VARCHAR(20),			-- 菜名单
		foodType_id INT, 			-- 所属菜系
		price DOUBLE,				-- 价格
		mprice DOUBLE,				-- 会员价格
		remark VARCHAR(200),			-- 简介
		img VARCHAR(100)			-- 图片	
		);
 

	-- 4.订单表		（订单基本信息）
		CREATE TABLE orders(
		id INT PRIMARY KEY AUTO_INCREMENT,		-- 主键
		table_id INT,				-- 外键：餐桌编号
		orderDate DATETIME,			-- 下单日期
		totalPrice DOUBLE,			-- 总金额
		orderStatus INT DEFAULT 0		-- 订单状态 0：未结 1：已结账
		);

	-- 5.订单明细表	（主要是菜的品种）
		CREATE	TABLE orderDetail(
		id INT PRIMARY KEY AUTO_INCREMENT,	-- 主键
		orderId INT,				-- 外键：引入订单表的主键
		food_id INT,				-- 外键：应用菜单信息的主键
		foodCount INT 				-- 菜的数量		
		);

	
		'数据约束----------
		-- 添加菜品与菜类别的关系
			ALTER TABLE food ADD CONSTRAINT fk_food_foodType_id FOREIGN KEY (foodType_id) REFERENCES foodType(id);
		-- 订单表：与餐桌的关系
			ALTER	TABLE food ADD CONSTRAINT fk_food_doodType_id FOREIGN KEY (foodType_id) REFERENCES foodType(id);
		-- 订单明细：与订单表的关系
			ALTER TABLE orderDetail ADD CONSTRAINT orderDetail_order_id FOREIGN KEY(orderId) REFERENCES orders(id);
		-- 订单明细：与菜单信息的关系
			ALTER TABLE orderDetail ADD CONSTRAINT orderDetail_food_id FOREIGN KEY(food_id) REFERENCES food(id);


	'3.系统设计
		1.修改美工提供的页面
				html  ->  jsp
		2.开源组件 及 jar 包				（注意架包版本一致）
				数据库驱动包		1个
				C3P0连接池包		2个
				DbUtils组件			1个
				BeanUtils			2个
				FileUtile 组件		2个		（Servlet前加载图片）
		3.配置
				C3P0
		4.分层
				Entity/Service/Servlet/dao








'案例 【软件项目声明周期】


	1. 需求分析
		系统概述：
			企业人事管理系统！
			要求对员工信息进行维护;  
			后台系统先登陆，才能操作员工： 添加/修改/删除
			没有登陆，只能查看列表，不能操作！

		功能分类:
			【管理员模块:】
				 注册/登陆
			【员工模块】
				1) 添加一个员工, 指定添加的部门
				2) 对指定的员工信息修改
				3) 删除选择员工
				4)列表展示

	2. 设计
		2.1 系统设计
			【系统架构师/技术经理】
			主要做下面的事情,
				1) 搭建系统框架结构 (基于mvc结构应用)
				2) 确定项目的关键点/难点
				3) 确定引用组件、公用类的版本
					Struts2.3 
					Hibernate3.6
					Spring3.2
		2.2 数据库设计
			管理员表： t_admin
			员工表：   t_employee
			部门：     t_dept

3.代码
	编码顺序
		1) 设计数据库:  hib_demo 
			   建表： t_admin/t_employee/t_dept
			2) 建立web项目、引入jar文件、准备环境
				…..

			3) 设计javvabean、写映射
				Admin.java   封装管理员
				Employee.java  员工
				Dept.java      部门

				Admin.hbm.xml
				Employee.hbm.xml
				Dept.hbm.xml
			4) Dao设计接口
				IAdminDao.java    管理员模块
					void  save(Admin admin);
					Admin findByAdmin(Admin  admin);
				IDeptDao.java      部门模块
					List<Dept> getAll();   
					Dept  findById(int  id);
				IEmployeeDao.java   员工模块
					Void  save(Employee  emp);
					Void  update(Employee  emp);
					Void  delete(int id);
					Employee  findById(int id);
					List<Employee> getAll();
					List<Employee> getAll(String  employeeName);
			5) Dao接口实现

			6)Service接口设计
				IAdminService.java    管理员模块
					void  register(Admin admin);
					Admin  login(Admin  admin);
			7)Service接口实现
			8) Action实现
				EmployeeAction.java   员工模块
				AdminAction.java		管理员模块
			9)jsp页面
				Index.jsp/list.jsp  首页列表
				http://localhost:8080/项目    首页列表

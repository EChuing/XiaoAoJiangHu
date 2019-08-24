数据约束
	对用户表操作进行约束

固定在 ENUM
	gender enum('男','女') not null;




	在 name 列后面添加 gender 枚举类型 默认为 女
	ALTER TABLE practice ADD COLUMN gender ENUM('男','女')DEFAULT'女' NOT NULL AFTER name

1.1
默认值  (DEFAULT)
		创建一张带有默认值的 表
		CREATE TABLE student (
				id INT,
				NAME VARCHAR (20),
				address VARCHAR (20) DEFAULT '广州天河'
		) -- 默认值 
	
		插入数据
		insert into student(id,name) values(1,'张三');
		查看结果	
		SELECT * FROM student;        
		
		作用：自动添加 默认值， 若查入NULL 默认字段允许为空


1.2 
非空 (NOT NULL)
	CREATE TABLE feikong (
				id INT,
				NAME VARCHAR (20),
				address VARCHAR (20) NOT NULL)  -- 非空
		
		插入空字符
		INSERT INTO student(id,NAME) VALUES(1,'');
		在cmd 中 报错  工具中可以绕过 	

		作用：非空字段必须赋值 不能插入 NULL 

1.3
唯一 （UNIQUE）  
	CREATE TABLE weiyi (
				id INT UNIQUE,  -- 唯一
				NAME VARCHAR (20)
				)
		
		作用：不可以有重复字符 可以插入null  也可以插入对个null
				

1.4
主键  primary key       （非空+唯一）
		CREATE TABLE zhujian (
				id INT  PRIMARY KEY -- 主键,
				NAME VARCHAR (20),
				address VARCHAR (20) )

		注意： 一表一主键，标记每条记录的唯一性
				主键不要包含业务含义 通常选择 ID 作为

1.5
自增长	（AUTO_INCREMENT）
	
	CREATE TABLE zz (
				id INT  PRIMARY KEY   AUTO_INCREMENT,-- 主键 自增长  
				NAME VARCHAR (20),
				address VARCHAR (20) )
	
	自增长字段可以不赋值，自动递增
	insert into zz(name) varchar('张三');
	

	删除所有数据
		delete  from zz		不可以删除约束
		truncate table zz	可以删除约束

1.6 
外键	约束两种表的数据 
'  CONSTRAINT emloyee_dept_fk FOREIGN KEY (deptId) REFERENCES dept(id)  ' 
	
'	出现两种情况：
		解决数据冗余高的问题， 独立出一张表
		例如 ： 部门表 和 员工表
'	出现问题：
		再插入员工表数据的时候，员工表的部门ID字段可以随便插入 
		使用外键约束，可以控制
	
CREATE TABLE employee(
	id INT PRIMARY KEY,
	empName VARCHAR(20),
	deptName VARCHAR(20)   -- 部门名称
	)
	
	INSERT INTO employee VALUES(1,'张三','软件开发部');
	INSERT INTO employee VALUES(2,'李四','软件开发部');
	INSERT INTO employee VALUES(3,'王五','应用维护部');
	
'	添加员工   存在部门名称的冗余高    如 软件部门   字符越多 冗余就越高
	INSERT INTO employee VALUES(4,'陈六','软件开发部')
	
	------------------------------------------
	DROP TABLE employee;


'	解决   独立设计一张表  独立起来    
'	添加部门表       (主表)
	CREATE TABLE dept(
		id INT PRIMARY KEY,
		deptName VARCHAR(20)
		)
'		修改员工表    (副表)
	CREATE TABLE employee(
		id INT PRIMARY KEY,
		empName VARCHAR(20),
		deptId INT -- 把部门名称改为部门ID
	)	
		
		INSERT INTO dept ( id,deptNAME) VALUES (1,'软件开发部');
		INSERT INTO dept ( id,deptNAME) VALUES (2,'秘书部');	
		INSERT INTO dept ( id,deptNAME) VALUES (3,'应用维护部');
		
		INSERT INTO employee VALUES(1,'张三',1); --  对应上面的 数组  变为一个数字  减少了冗余
		INSERT INTO employee VALUES(2,'李四',1);
		INSERT INTO employee VALUES(3,'王五',3);	
		
'		问题 插入一个 不存在的 的数据
	INSERT INTO employee VALUES(4,'陈六',4);
'		解决 这时该使用外键	对部门ID使用
'		修改员工表
	CREATE TABLE employee(
		id INT PRIMARY KEY,
		empName VARCHAR(20),
		deptId INT, -- 把部门名称改为部门ID
		-- 声明一个外键约束
"		CONSTRAINT emloyee_dept_fk FOREIGN KEY (deptId) REFERENCES dept(id)  --------外键约束-------------------------
	) 	-- 名字		外键名称      关键字	外键	参考   （参考字段）			
	
	
	
'	当有了外键的约束： 
'			添加数据的顺序： 先添加主表  再添加附表数据
			INSERT INTO dept ( id,deptNAME) VALUES (1,'软件开发部');
			INSERT INTO employee VALUES(1,'张三',1);
		
'			修改数据的顺序： 先修改副表  再修改主表
			UPDATE employee SET deptId=2 wheere id=4;
			UPDATE dept SET id=4 WHERE id=3;
		
'			删除数据; 先副表，再主 
			DELETE FROM employee WHERE deptId=2;
			DELETE FROM dept WHERE id=2;
	
	
	SELECT * FROM dept;
	SELECT * FROM employee;


1.7
级联操作  (on  update   cascade)

问题：当有了外键的约束时，必须先修改或删除所有关联的数据，才能修改或删除主表！


作用： 不收外键约束 直接操作

'级联修改：on update cascade

'级联删除：on delete cascade 


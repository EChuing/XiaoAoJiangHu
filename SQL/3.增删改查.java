USE llp;     选择一张表

SHOW	TABLES;


查看所有表
		SHOW TABLES;


建表
		CREATE TABLE student(
		s_id INT primary key auto_increment,                             PRIMARY KEY   AUTO_INCREMENT
		s_name VARCHAR(20),
		s_gender VARCHAR(20),
		s_age INT
		)；

		DESC student;    查看



增加数据

   添加列：
	  添加到首位
	  alter table student add column age varchar(20) not null first;

	  指定位置添加   age 到 XXX 后面
	  ALTER TABLE student ADD COLUMN age VARCHAR(20) not null AFTER XXX
      
	  添加到末尾
	  alter table student add column age varchar(20) not null;



	添加行：

		(in set )
		INSERT INTO student VALUES(8,'鹿小晗','女',21,18,78,NULL);
	                  插入

		插入所有字段 依次按顺序  不可少或多 字段

		插入部分字段

		INSERT INTO student(s_id,s_name) VALUES(2,'李四');
		将后面的数据指定插入 s_id ，s_name 中         


--------insert into  (in se ,  intui)




----------------------------------------------------------------------------------



删除数据 


删除所有数据
		DELETE FROM student

带条件的删除
		DELETE FROM student WHERE s_id=1;

		另一种删除  删除表里的所有数据
		TRUNCATE TABLE student;


-----------------------------------------------------------------
-- delete from;													|
--																|		
-- 		可以待条件删除										|
-- 		可以删除表的数据，不可以删除标的约束				|		
-- 		删除数据可以回滚 （事务）临时删除						|
--																|
-- truncate table												|
--	创 kea														|
-- 		不可以带条件删除										|
-- 		可以删除表的数据和约束   约束：自增长之类的			|
-- 		不可以回滚												|
-----------------------------------------------------------------

			
			
---------------------------------------------------------------------------------------------
修改数据


	alter table	 student  add   column   sgender  varchar（2）
	修改   表      表名   添加  字段		字段名	类型 （长度）
	alter table  student   drop  column   sgender ;
						   删除	  字段		名称
	
	'注意： 被修改名称的列里 有数据  则不能更改为不同的数据类型
		alter table student modify column remark varchar(100);     用于修改数据类型
						   修改   字段		名称       值
		alter table student change column aaa   bbb   varchar(10);
						 修改字段名称  改前  改后	
	
	alter table student rename to llp	;   //rename to		（V nin te）		重名名为									
								修改表 的名字

drop table 表名；  （zuapu tei bo） 删除指定表

注意： column 可以不写


distinct		(dis dink) :不同的


修改所有数据  
		UPDATE student SET s_gender='女';
		e dei
带条件修改
		UPDATE student SET s_id=2 WHERE address='五五开';
	                               这里指定条件   				
修改多个字段
		UPDATE student SET S_gender='男',s_age=30 WHERE s_id=1; 
		             一个SET 多个值用 , 隔开

			

------------------------------------------------------------------------------------------------
			
			
			
			查询数据

查询库里的所有表
		 show databases;
查询(表里的)所有数据
		SELECT * FROM student;
查询（表格的）指定列
		SELECT s_id,s_name,s_gender FROM student;
查询时 指定别名
		SELECT s_id AS '编号',s_name AS '姓名' FROM student AS s;
		 as + 别名    表格 标头命名
		 用于多表查询



-查询时添加常量列
		需求：查询student表 添加一个班级列，内容为“Java就业班”
		SELECT s_id ,s_name,s_age,'Java就业班'AS '年级' FROM student AS s;

查询时合并列
		需求：查询每个学生的servlet和jsp的总成绩
		SELECT s_id,s_name,(servlet+jsp)AS'总分' FROM student;
		显示：id，name，相加的总和。
		注意：只可以合并 数值类型 的字段


'查询时去除重复记录 (DISTINCT)          (dis dink) :不同的
		需求： 查询学生的性别
		SELECT DISTINCT s_gender FROM student;
		另一种语法
		SELECT DISTINCT(s_gender)FROM student;	
		查询学生所在的地区

		SELECT DISTINCT address FROM student;
条件查询 （where）

	逻辑条件： and（与） or（或）
		需求：查询id为2，且姓名为五五开的学生
		SELECT * FROM student WHERE s_id=2 AND s_name='五五开';
		需求：查询id为2，或姓名为嫦娥的学生
		SELECT * FROM student WHERE s_id=2 OR s_name='嫦娥';

	比较的条件： >， <， >=， <=，==，<>(不等于)，
		需求：查询servlet成绩大于70分的学生
		SELECT * FROM student WHERE servlet>70;
---------------------------------------------------------------------------------------------------------------------------
	判断条件（null 空字符串）：is null，   is not null,  =''(等于空字符串),  <>''（不等于空字符串）
		需求：查询地址为空的学生（空字符 或 空 地址）
		null：	没有值 	判断多用：	is null， is not null, 
		空字符串：	 有值	判断多用：	=''    ， <>''
		SELECT * FROM student WHERE address IS NULL OR address='';

	模糊条件； like
		 % ：表示任意字符
			需求：查询姓‘小’的学生
			SELECT * FROM student WHERE s_name LIKE '小%';
	
		查询姓 '鹿'，且姓名 只有两个字 的学生
			SELECT * FROM student WHERE s_name LIKE '鹿_';
		‘	鹿 _ _ ’ 一个下划线表示查找 姓什么 且 多少个字数。

聚合查询（使用聚合函数的查询）
	
	常用的聚合函数： sum()求和  avg()平均  max()最大值  min()最小值  count()统计总和
		
		需求： 查询学生的servlet的总成绩 (sum() :求和函数)
			SELECT SUM(servlet) AS 'servlet的总成绩' FROM student;
		
		需求： 查询学生的servlet的平均分
			SELECT AVG(servlet) AS 'servlet的平均分' FROM student;
		
		需求: 查询当前servlet最高分
			SELECT MAX(servlet) AS '最高分' FROM student;
		
		需求： 查询最低分
			SELECT MIN(servlet) AS '最低分' FROM student;
		
		需求： 统计当前有多少学生(count(字段))
			SELECT COUNT(*) FROM student;
			SELECT COUNT(s_id) FROM student;
		
		注意：count（）函数统计的数量不包含null的数据
		使用count统计表的记录数，要使用不包含null值的字段
			SELECT COUNT(s_age) FROM student;     //选择大家共有的值 统计



分页查询limit 
					         "n-1"
	起始行 n 从0开始

	分页：当前页  每页显示多少条
	分页查询当前页的数据的sql: SELECT * FROM student LIMIT (当前页-1)*每页显示多少条,每页显示多少条;
		
		需求：共30条数据，分页查询，每页十条记录
		
		第一页	select * from student limit 0,10		(查询定标条数-1，每页显示的条数) 
		第二页	select * from student limit 9,10
		第三页	select * from student limit 29,10


查询排序（order by ）
	语法 ：order by 字段 asc/desc
	asc: 顺序，正序。	数值：递增，字母：自然顺序（a-z）
	desc: 倒序，反序。	数值：递减，字母：自然反序(z-a)

	默认情况下，按照插入记录顺序排序
	SELECT * FROM student;

		需求： 按照id顺序排序
		SELECT * FROM student ORDER BY id ASC;
		SELECT * FROM student ORDER BY id; -- 默认正序
	
		SELECT * FROM student ORDER BY id DESC;-- 反序

		注意：多个排序条件
		需求： 按照servlet正序，按照jsp的倒序
		SELECT * FROM student ORDER BY servlet ASC,jsp DESC;



分组查询(group by)
		需求： 查询男女的人数
		预期结果：
		男   3
		女   2

	 1) 把学生按照性别分组(GROUP BY gender)
	 2) 统计每组的人数(COUNT(*))
	SELECT gender,COUNT(*) FROM student GROUP BY gender;
	先给性别分，在统计人数



分组查询后筛选									where：条件查询
		需求： 查询总人数大于2的性别						group by:分组查询
		1) 查询男女的人数									having：筛选	
		2)筛选出人数大于2的记录(having)
		注意： 分组之前条件使用where关键字，分组之前条件使用having关键字

		SELECT s_gender,COUNT(*) FROM student WHERE GROUP BY gender HAVING COUNT(*)>2;

导入：

create table student(
	id int,
	name varchar(20),
	chinese float,
	english float,
	math float
);

insert into student(id,name,chinese,english,math) values(1,'张小明',89,78,90);
insert into student(id,name,chinese,english,math) values(2,'李进',67,53,95);
insert into student(id,name,chinese,english,math) values(3,'王五',87,78,77);
insert into student(id,name,chinese,english,math) values(4,'李一',88,98,92);
insert into student(id,name,chinese,english,math) values(5,'李来财',82,84,67);
insert into student(id,name,chinese,english,math) values(6,'张进宝',55,85,45);
insert into student(id,name,chinese,english,math) values(7,'黄蓉',75,65,30);







题目：

1.创建一个员工表
	字段     属性
	id        整形(int)
	name     字符串(varchar)（长度为20）
	gender    字符串（长度为2）
	birthday  日期型(date)
	email	   字符串（长度为10）
	remark     字符串（长度为50）

2.修改表练习

	对象为表格
			在员工表基础上增加age列
			修改email列长度为50     '名称列中有数据改不了变类型
			删除remark列
			列名name修改为username

3.在员工表上练习数据的增删改操作

	
------------------------------------------------------------------
在员工表基础上增加age列
		ALTER TABLE studen ADD sge VARCHAR(2);


-- 查询所有的学生
SELECT * FROM student;																	select  查询

-- 查询表中所有学生的姓名和对应的英语成绩。
SELECT NAME,english FROM student;

-- 过滤表中英语成绩的重复数据
SELECT DISTINCT(english) FROM student ;																		distinct  唯一

-- 使用别名表示学生分数
SELECT chinese AS yuwen,english AS yingyu,math AS shuxue FROM student;

-- 查询姓名为李一的学生成绩
SELECT * FROM student WHERE NAME='李一';                                                            where   附加条件

-- 查询英语成绩大于等于90分的同学
SELECT * FROM student WHERE english>90;

-- 查询总分大于200分的所有同学
SELECT * ,(chinese+english+math) AS '总成绩' FROM student WHERE (chinese+english+math)>200;

-- 查询所有姓李的学生英语成绩。
SELECT * FROM student WHERE NAME LIKE '李%';                                                         like       所有

-- 查询英语>80或者总分>200的同学
SELECT * FROM student WHERE english>80 OR (chinese+english+math)>200;											or 或

-- 统计每个学生的总分。
SELECT * ,(chinese+english+math) AS '总成绩' FROM student;										

-- 在所有学生总分数上加10分特长分。
SELECT * ,(chinese+english+math) AS '总成绩', (chinese+english+math)+10 AS 
'特长分' FROM student;






 
	
	
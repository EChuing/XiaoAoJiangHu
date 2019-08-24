

三大范式

	1.每个字段必须是不可分割的独立单元
				猪刚烈（八戒）  
	
	2.		1 的基础上	每张表只表达一个意思

	3.		2 的基础上 每张表除主键外  其他字段只和 主键有决定关系



java 基本数据类型  八
					 整数类型 byte short int long
					 字符类型 char
					 浮点类型 float 单 double  双 高精度使用
					 布尔类型 boolean 真假
JS   基本数据类型 五
					字符串 String 数学类型 number
					布尔 boolean 
					特殊 null Undefined



--------------数据库

show databases ;
create database day15
show create database day15
alter database day defult character set gbk
drop 
use day15



show tables;
create table haha{
id varchaar;
}
desc daty15

select * from day





create table day{
id int primary auto_increment,
name varchar,
	gender varchar,
	age char
};
添加
	列
	alter table student add coulumn age varchar not null first;
	alter table student add coulumn age varchar not null after xxx；
												not null ;    
												
	行
	insert into student values(8,'李白',21,7,null);
	insert into student(id,name) values(11,'李白');

删除
	所有
	delete from student
	带条件 删表所有
	truncate table  student;

修改
	表结构
	alter table student add column age varchar(21); 添加字段
	alter table student change drop column age ;删除字段
	
	alter table student modify age varchar;   修改数据类型
	alter table student change column aa bb varchar(2); 修改字段

	alter table student rename to    day15;  修改表的名称

	表内容
	updata student SET gender='女'；  所有的gender
	updata student SET name='五五开' where id=2; 附带条件
	updata student SET gender='女',age=12 where id=3  修改对个值

查询
	select * from student;
	AS '别名'
	select (gender+age)AS '女朋友'
	select DISTINCT gender='女' from student ;  去重复
		或者 distinct（gender）          两种表示方式

	where 附带条件  or或 and与
	>     <     >=     <=     ==    <>(不等于)
	判断空字符：  null 、is null 、is not null 、 ='' 、 <>''

	模糊添加 like     %任意字符  _字数    例： like '小%' 、 like ’白_ _‘ 
	
	聚合 sun avg平均 max min count(计数和)

	分页 limit 开始查询的条数-1 , 每页显示的条数

	查询排序（order by  asc/desc） asc顺, desc倒, 默认是asc可以不写

	分组 group by   常与count配合使用  可能会有地啊筛选having



约束      对用户表操作的约束
	alter table student add colum gender ENUM('男','女') defautlt'女' not null after name；

	默认值 default 非空 not null 唯一 unique  
	主键 primary key 自增auto_increment

	外键
	constraint  外键名 foreign key 主表ID references 副表ID ;
	（ken si锥）

级联
	修改 on update cascade
	删除 on delete cascade


关联
	交叉查询 会产生笛卡尔积
		select    A_name,B_name    from    A1,B2;
	内连接查询
		select A_name,B_name
		from A1,B1
		where A1.A_name=B1.B_name  两表连接条件
	
		另一种语法
		select Aid,Bid
		from A1
		inner join B1
		on A1.Aid=B1.Bid
	外连接  左右
		select d.dname,e.ename
		from dname         输出的结果 定左右
		LEFT OUTER JOIN
		ON d.id=e.id
	自动连接

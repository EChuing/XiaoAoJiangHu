库---------------------------------------------------------------------------------
创建数据库 mysql		create database mysql
查询所有数据库			show databases;
查询指定数据库			show credate database mysql
进入指定数据库			use mysql

表---------------------------------------------------------------------------------

查询所有的表		select * from student
					 ________________________________________________
					|______|__行__|________|________|_______|________|
					|__列__|______|________|________|_______|________|
					|______|______|__内容_|________|_______|________|
					|______|______|________|________|_______|________|
					|______|______|________|________|_______|________|
					|______|______|________|________|_______|________|
		
		修改表的名称	 alter table student rename to XXX
			

		列：		
			添加
				alter table student add  id int not null   first			首位
				alter table         add         not null   after   XXX		之后
																		默认是最后
			修改
				
				alter table student modify name varchar(100);	修改数据类型
																修改名字和数据	
			删除
				alter table         drop column XXX;
									
				alter tablee		change name name1 varchar(100);
		行：		
				insert into student(id,name) values(6,'李泡泡');
				insert into                  values(    );


		内容：
				
				update student set name='xixi' where id=2;




----------

show database ;
create database day15
show create database day15;
drop day15
use day15;
show tables

create table mysql(
id int ;
name varchar(20);
gender varchar(20);
age varchar(2)
);

插入列
alter table student add sid int not null first;
alter table student add sid ssid not null after;
alter table studnet add ss int not null;

插入行
insert into student(name,age) values('xx',2);

删除
delete from student;
delter from student where id=1;

修改
	alter table student modify column  name varchar(100);   数据类型的修改
	alter table stuudent chenge column name  name1 varchar(20);数据类型名称
	
	update student set name='李白';							修改所有值
	update student set age=21，address="上海" where id=2;	修改多个值

查询
	show databases;
	select * from student;
	select id,name,address from studnet;
	select name as '名字' from studnet;
	select id,name,age,'日本鬼子' as '总分' from studnent;
'	select distinct adrress from studnet;		去除重复	
	select * from student where address is null or address='';
	
	


查询指定表内容
select * from student ;










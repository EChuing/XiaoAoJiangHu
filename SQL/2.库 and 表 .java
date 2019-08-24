-----------------------数据库----------------------------


show databases;    				查看数据库   多个S

create  database  day15 ；  		创建day15的数据库 

show create database day15;  	查看创建day15的数据库
( o te )			(de fo t) (ka te)
alter database day15 default character set gbk;
修改  数据库    day15   默认 字符 集      形式

drop database day15；  			删除 day15的数据库

use 数据库名；					选择指定数据库

选择一张表后才可以进行下面操作



show tables;		查看所有表					多个S
create table student(s_id int,s_name varchar(20));   建表格式
desc 表名;    		查看表


查看所有数据库							show databases；
查看指定数据库的     储存类型		show create database 表名;
产看数据库的所有表格					show tables;
查看表格的            储存类型		desc 表名；	    
查询表格所有数据						SELECT * FROM 表名;

create  (kui ate)     实现
desc     (dA si)
drop	(zua pu)		滴




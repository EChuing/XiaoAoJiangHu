
数据库优化方面的经验?

1."用PreparedStatement （Peta Sidi们）
		性能会比 Statement 高：
一个sql 发给服务器去执行，

	涉及步骤：
			语法检查、语义分析、 编译、缓存
	“inert into user values(1,1,1)”-二进制
	“inert into user values(2,2,2)”-二进制
	“inert into user values(?,?,?)”-二进制


2.'减少外键约束 （影响插入和删除）

	前提：保证数据的完整性，再设计时就除去外键（例如：免检产品）

	（对于hibernate来说，就应该有一个变化：empleyee->Deptment对象，现在设计时就成了employeedeptid）
		例子:	根据扫描的原理，下面的子查询语句要比第二条关联查询的效率高：
			select e.name,e.salary where e.managerid=(select id from employee where name='zxx');

			select e.name,e.salary,m.name,m.salary from employees e,employees m where
			e.managerid = m.id and m.name='zxx';

			注： 允许适当的冗余，例如 ： 主题帖的回复数量和最后回复时间 、 姓名和密码
											    	

3."sql语句全部大写，
	
	特别是  列名和表名、sql命令的缓存功能

	数据库执行的时候都会转换为 "大写" ,
	sql语句发给服务器语法检查和编译成为内部指令缓存和执行指令。
	根据缓存的特点，不要拼凑条件，而是用?和PreparedStatment



	例： 4航班 3个城市

		m*n
			select * from flight,city where flight.startcityid=city.cityid and city.name='beijing';

		m + n
			select * from flight where startcityid = (select cityid from city where cityname='beijing');

			select flight.id,'beijing',flight.flightTime from flight where startcityid = (select cityid from city where cityname='beijing')

4."索引对查询性能的改进也是值得关注的。





关于如何检验性能的问题
	
	借助性能检测工具  sql server profiler
	（处在sql安装文件--性能工具--sql server profiler）







为什么要优化：
     随着实际项目的启动，数据库经过一段时间的运行，最初的数据库设置，会与实际数据库运行性能会有一些差异，这时我们         就需要做一个优化调整。

数据库优化这个课题较大，可分为四大类：
       》主机性能
       》内存使用性能
       》网络传输性能
       》SQL语句执行性能【软件工程师】


下面列出一些数据库SQL优化方案：


（01）选择最有效率的表名顺序（笔试常考） 
      数据库的解析器按照从右到左的顺序处理FROM子句中的表名， 
      FROM子句中写在最后的表将被最先处理，
      在FROM子句中包含多个表的情况下,你必须选择记录条数最少的表放在最后，
      如果有3个以上的表连接查询,那就需要选择那个被其他表所引用的表放在最后。
     
      例如：查询员工的编号，姓名，工资，工资等级，部门名
      select emp.empno,emp.ename,emp.sal,salgrade.grade,dept.dname
      from salgrade,dept,emp
      where (emp.deptno = dept.deptno) and (emp.sal between salgrade.losal and salgrade.hisal)  
		
      1)如果三个表是完全无关系的话，将记录和列名最少的表，写在最后，然后依次类推
      2)如果三个表是有关系的话，将引用最多的表，放在最后，然后依次类推


（02）WHERE子句中的连接顺序（笔试常考）  
      数据库采用自右而左的顺序解析WHERE子句,根据这个原理,表之间的连接必须写在其他WHERE条件之左,
      那些可以过滤掉最大数量记录的条件必须写在WHERE子句的之右。  
      
      例如：查询员工的编号，姓名，工资，部门名  
      select emp.empno,emp.ename,emp.sal,dept.dname
      from emp,dept
      where (emp.deptno = dept.deptno) and (emp.sal > 1500)  //最右边能砍掉记录中N条记录 
  	
（03）SELECT子句中避免使用*号
      数据库在解析的过程中,会将*依次转换成所有的列名，这个工作是通过查询数据字典完成的，这意味着将耗费更多的时间
      select empno,ename from emp;

（04）用TRUNCATE替代DELET
		delete 是一条一条的删
		truncate 直接全部删除
   
（05）尽量多使用COMMIT
      因为COMMIT会释放回滚点

（06）用WHERE子句替换HAVING子句
      WHERE先执行，HAVING后执行
     
（07）多使用内部函数提高SQL效率
     
（08）使用表的别名
      salgrade s
     
（09）使用列的别名
      ename e
    
总之，数据库优化不是一天的课题，你得在长期工作实践中，进行反复测试与总结，希望学员们日后好好领会
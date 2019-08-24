
4. 关联的查询




		USE day16;


需求： 查询员工及其所在部门（显示员工姓名，部门名称）
4.1 交叉连接查询 （不推荐。产生笛卡尔积乘积现象: 3 * 3 = 9 ; 有些事重复记录）
		SELECT empName, deptName FROM employee, dept;

SELECT * FROM employee;
SELECT * FROM dept;



需求： 查询员工及其所在部门（显示员工姓名，部门名称）
多表查询规则： 1）确定查询哪些表  2）确定哪些字段  3）确定表与表连接的条件
4.2 内连接查询

		SELECT empName,deptName       -- 2）确定哪些哪些字段
		FROM employee,dept    -- 1）确定查询哪些表
		WHERE employee.deptId=dept.id  -- 3）表与表之间连接条件


-- 内连接的另一种语法
		SELECT empName,deptName
		FROM employee
		INNER JOIN dept
		ON employee.deptId=dept.id;
	
-- 使用别名
		SELECT e.empName,d.deptName
		FROM employee AS e     -- AS 都可以省略不写 
		INNER JOIN dept AS d
		ON e.deptId=d.id;

-- 需求： 查询每个部门的员工
-- 预期结果：
 --  软件开发部  张三
 --  软件开发部  李四
 --  应用维护部  王五
 --  秘书部      null
 --  总经办      null 
 
4.3 左[外]连接查询：使用左边表的数据去匹配右边表的数据   如果符合条件就连接起来   不符合就不连接
	（注意： 做外连接： 左边的数据一定会完成显示！）   没有人也会显示出来（扫描器）
		SELECT d.deptName,e.empName
		FROM dept d
		LEFT OUTER JOIN employee e
		ON d.id=e.deptId;
	右[外]连接查询：使用右边表的数据去匹配左边表的数据     （相反）
		SELECT d.deptName,e.empName
		FROM employee e
		LEFT OUTER JOIN dept d
		ON d.id=e.deptId;
	
	



		ALTER TABLE employee ADD bossId INT;
		-- 添加上司ID
		UPDATE employee SET bossId=1 WHERE id=2;
		UPDATE employee SET bossId=2 WHERE id=3;
2.4 自连接查询
		SELECT e.empName, b.empName
		FROM employee e
		LEFT OUTER JOIN employee b
		ON e.bossId=b.id

SELECT * FROM employee;
SELECT * FROM dept;
		

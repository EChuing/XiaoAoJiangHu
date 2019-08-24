root 拥有所有权限 可以做任何事情

权限账户： 只拥有部分权限（CURD）   例如只能操作某个数据库的某张表


--  如何修改mysql用户的 密码

-- password    md5 的加密函数(单项加密)  只可以加密不能解	

SELECT PASSWORD（'root'） ;

-- mysql数据库，用户配置：  user表


USE mysq;
SELECT * FROM USER;

-- 修改密码
UPDATE USER SET PASSWORD=PASSWORD('123456') WHERE USER='ROOT';   -- 需要重启mysql生效

-- 分配权限账户（ 只能查询到  day16库.employee表 ）
GRANT SELECT ON day16.employee TO '账户名' @' 指定IP地址可以登录' IDENTIFIED BY '密码';
	  DEKETE -- 直接在这里添加 可以增加赋权  	



备份 
mysql -uroot -p day16 > e:/bak.sql
恢复
mysql -u root -p day16 < e:/day16.sql  

-- 都不需登录
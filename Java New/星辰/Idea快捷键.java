

IDEA 2019 快捷键

	Ctrl+Shift+R  全局搜索
	Ctrl+Shift+?  多行注释
	Alt+Shift+箭头  行移动
	

	

	Alt+回车 （ante）   导包






IDEA关于 

	--	Tomcat 部署
		Tomcat
			-Server
				Name: 命名
				After launch : 默认浏览器启动
				URL：调试时访问的首页
				HTTP:端口号   
				------------  其余的不用管
			
			-Deployment
				Deployment

		Tomcat 的 Deployment配置没有  Artifac 选项
				1.project Structure( Ctrl+Alt+Shift+C )
				2.Modules  “+号” 导入项目    ->  出现Web 字样
				3.Artifacts    有出现对应项目文件：war
				4.点OK 回到tomcat中  Run/Debug Configurations 配置好 ->  点击Deployment
				5.没有 对应项目的exploded   点加号 添加 Artifac






	--	外部设备禁止访问 IEDA 项目     
			Build,Execution, Deployment
				-Deployment
					Port :9999
					勾选 Can accept external connections   "是否允许外部设备访问"
					勾选 Allow unsigned requests	

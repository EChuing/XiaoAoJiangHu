Tocat 基本使用
													
	到apache官网下载www.apache.org    http：//jakarta.apache.org（产品主页）
	

			安装版			window（exe、msi）  linux（rmp）      -> 会自动在环境变量中插入 CATALINA_HOME
			压缩版（解压包）	window（rar、zip）  linux（tar、targz）学习时使用

	运行tomcat的  bin/startup.bat		打开浏览器检测 http://localhost：8080
	关闭		   bin/shutdown.bat		清空浏览器缓存 检测


常见问题
	1.闪退															 （家）						
		tomcat软件时JAVA语言开发的  启动时会找到环境变量中的JAVA_HOME的变量，HOME 会找到tomcat所需的 jvm

		JAVA_HOME 指向java的根目录 即可

	2.端口占用错误
		tomcat启动所需的端口被占用    
		解决方案：
				a.关闭软件，释放端口
				b.找到并修改 tomcat/conf/server.xml文件
			<Connector port="8080" protocol="HTTP/1.1" 
			connectionTimeout="20000" redirectPort="8443" />

		一个端口只能被一个软件占用
	
	3.CATALINA 环境变量问题                          (kelinai hone)
		tomcat软件启动后 除了找JAVA_HONE 还会查找个CATLINA_HOME变量 这个变量作用是设置tomcat的根目录
		解决： 删除CATALINA_HOME 或修改 对应目录


-----------------
需共享都东西都放进 tomcat/webapps 里
		注意：不能共享单个文件  必须是文件夹
		例：
			新建myweb文件夹
			http://localhost：8080/myweb/test.html
					本地IP

		/myweb:   web应用的名称。默认情况下，在webapps目录下找
		/test.html  ： 资源名称。


URL
	统一资源定位符，用于定位互联网的资源

	http://    http协议

	localhost   域名               URL 浏览器先查看本机的 hosts 的域名查找，在去内外部查看        

					本地域名： localhost
					外部域名：www.baidu.com   

	8081   端口  软件监听
				
		8080： tomcat默认的端口
		3306：mysql数据库的端口
		1521： orace数据库的端口。


5 Tomcat的目录结构


		|-bin: 存放tomcat的命令。
				catalina.bat 命令：
					startup.bat  -> catalina.bat start	
					shutdown.bat - > catalina.bat stop

	    |- conf: 存放tomcat的配置信息。其中server.xml文件是核心的配置文件。
		
		|-lib：支持tomcat软件运行的jar包。其中还有技术支持包，如servlet，jsp
		
		|-logs：运行过程的日志信息
		
		|-temp: 临时目录
		
		|-webapps： 共享资源目录。web应用目录。（注意不能以单独的文件进行共享）
		
		|-work： tomcat的运行目录。jsp运行时产生的临时文件就存放在这里



6 Web应用目录结构

	|- WebRoot    "根目录
		|- 静态资源（html+css+javascript+images+xml+vedio）   "可直接被浏览器访问
			
		|- WEB-INF ： 固定写法。	"不可被浏览器直接访问							
			|-classes：				存放class字节码文件
			|-lib：					存放jar包文件。
			|-web.xml				web应用的配置文件，配置servlet   

	注意：
		1）WEB-INF目录里面的资源不能通过浏览器直接访问
		2）如果希望访问到WEB-INF里面的资源，就必须把资源配置到一个叫web.xml的文件中。


	练习：
		1）在webapps下建立一个mybbs目录
		2）创建两个文件
				2.1 index.html  里面随便写内容	，有超链接-连接到test.html	
				2.2 test.html   里面随便写
		3）通过浏览器访问到。
























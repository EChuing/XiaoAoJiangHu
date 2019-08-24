Http协议
 
		对浏览器 和 服务器 之间数据传输的格式规范



查看http协议工具

	1.使用360浏览器 “审查元素”  ， 找 Netwoek（网络）
	2.使用cmd 的 telnet 工具 （远程访问）
			a.      telnet 地址 端口号            访问tomcat服务器
			  例   relnet  localhost 8080
			b. ctrl + ]   后按 回车				可以看到回显
			c. 输入请求内容	
				如：
					GET /day09/hello HTTP/1.1
					Host:localhost:8080





请求   （浏览器->服务器）
	"-------------------------------------------	
		GET /day09/hello HTTP/1.1		//请求行    分为三段
		Host: localhost:8080			//请求头    多个key-vlaue （键：值  对象）
		User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0
	"	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		Accept-Language: zh-cn,en-us;q=0.8,zh;q=0.5,en;q=0.3
		Accept-Encoding: gzip, deflate
		Connection: keep-alive
		   ----------------------			一个空行
		name=eric&passwork=643535533      (可选)实体内容



响应    （服务器->浏览器）
	"-----------------------------------------------
		HTTP/1.1 200 OK
		Server: Apache-Coyote/1.1
		Content-Length: 24
		Date: Fri, 30 Jan 2015 01:54:57 GMT

	页面显示的内容
	"------------------------------------
	this is hello servlet!!!










请求行 
		GET /day09/hello HTTP/1.1
	

	http协议版本
		
		http1.0 浏览器与服务器之间建立连接后，只发一次请求，一次之后连接关闭
		http1.1	浏览器与服务器之间建立连接后，发送多次请求，连接不会关闭    （常用）

	"显示一次页面，一次请求
	"一张图片 ，一次请求
	"注意浏览器 有缓存功能，相同的图片会减少请求记录 但实际是有发出请求的
	"所有图标集中在一张图片中 有利于减少请求

	#请求资源  
		URL		统一资源定位符   
				http：//localhost：8080/day09/test.html
				只能定位互联网资源  是 URI 的子集
		
		URI		统一资源标记符	
				/day09/hello
				标记任何资源。 
				可以是本地文件、局域网资源、互联网
	#请求方式
		常见： GET POST HEAD TRACE PUT CONNECT DELETE
		常用： GET POST

		表单提交 
			<form action="提交地址" method="GET/POST">

		
		
		GET 和 POST 区别
			
	1）GET方式提交 
		a）地址栏（URI）会跟上参数数据。以？开头，多个参数之间以&分割。
		b）GET提交参数数据有限制，不超过1KB。
		c）GET方式不适合提交敏感密码。
		d）注意： 浏览器直接访问的请求，默认提交方式是GET方式

		GET /day09/testMethod.html?name=eric&password=123456 HTTP/1.1
		Host: localhost:8080
		User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0
	"	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		Accept-Language: zh-cn,en-us;q=0.8,zh;q=0.5,en;q=0.3
		Accept-Encoding: gzip, deflate
		Referer: http://localhost:8080/day09/testMethod.html
		Connection: keep-alive



	2）POST方式提交
		a）参数不会跟着URI后面。参数而是跟在请求的实体内容中。没有？开头，多个参数之间以&分割。
		b）POST提交的参数数据没有限制。
		c）POST方式提交敏感数据。

		POST /day09/testMethod.html HTTP/1.1
		Host: localhost:8080
		User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0
	"	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
		Accept-Language: zh-cn,en-us;q=0.8,zh;q=0.5,en;q=0.3
		Accept-Encoding: gzip, deflate
		Referer: http://localhost:8080/day09/testMethod.html
		Connection: keep-alive

		name=eric&password=123456       "实体内容


请求头
	

	Accept: text/html,image/ *			-- 浏览器接受的数据类型
	Accept-Charset: ISO-8859-1			-- 浏览器接受的编码格式
	Accept-Encoding: gzip,compress		--浏览器接受的数据压缩格式
	Accept-Language: en-us,zh-			--浏览器接受的语言
	Host: www.it315.org:80				--（必须的）当前请求访问的目标地址（主机:端口）
	If-Modified-Since: Tue, 11 Jul 2000 18:23:51 GMT  --浏览器最后的缓存时间
	Referer: http://www.it315.org/index.jsp      -- 当前请求来自于哪里
	User-Agent: Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0)  --浏览器类型
	Cookie:name=eric                     -- 浏览器保存的cookie信息
	Connection: close/Keep-Alive            -- 浏览器跟服务器连接状态。close: 连接关闭  keep-alive：保存连接。
	Date: Tue, 11 Jul 2000 18:23:51 GMT      -- 请求发出的时间



实体内容
	只有POST提交的参数 才存到实体内容中



























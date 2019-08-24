
 Http响应



	HTTP/1.1 200 OK						--响应行
	Server: Apache-Coyote/1.1			--响应头（key-vaule）
	Content-Length: 24 
	Date: Fri, 30 Jan 2015 01:54:57 GMT
										--一个空行
	this is hello servlet!!!			--实体内容








响应行
		     
	 #http协议版本
	 
	 
	 #状态码: 服务器处理请求的结果（状态）
		
		100 ~ 199  成功接收请求，要求客户端继续提交下一次请求才能完成整个处理过程
		200 ~ 299  表示成功接收请求并已完成整个处理过程
		300 ~ 399  完成请求，客户端需进步一细化请求，例：请求的资源已经移动到一个新地址
		400 ~ 499  客户端请求有误
		500 ~ 599  服务器端出现错误


			常见的状态：
				200 ：  表示请求处理完成并完美返回
				302 ：   表示请求需要进一步细化。
				404 ：   表示客户访问的资源找不到。
				500 ：   表示服务器的资源发送错误。（服务器内部错误）
	#状态描述		



常见的响应头
			Location: http://www.it315.org/index.jsp			---表示重定向的地址，该头和302的状态码一起使用。
			Server:apache tomcat								---表示服务器的类型
			Content-Encoding: gzip								---表示服务器发送给浏览器的数据压缩类型
			Content-Length: 80									---表示服务器发送给浏览器的数据长度
			Content-Language: zh-cn								---表示服务器支持的语言
			Content-Type: text/html; charset=GB2312				---表示服务器发送给浏览器的数据类型及内容编码
			Last-Modified: Tue, 11 Jul 2000 18:23:51 GMT		---表示服务器资源的最后修改时间
			Refresh: 1;url=http://www.it315.org					---表示定时刷新
			Content-Disposition: attachment; filename=aaa.zip	---表示告诉浏览器以下载方式打开资源（下载文件时用到）
			Transfer-Encoding: chunked
			Set-Cookie:SS=Q0=5Lb_nQ; path=/search				---表示服务器发送给浏览器的cookie信息（会话管理用到）
			Expires: -1											---表示通知浏览器不进行缓存
			Cache-Control: no-cache
			Pragma: no-cache
			Connection: close/Keep-Alive						---表示服务器和浏览器的连接状态。close：关闭连接 keep-alive:保存连接







HttpServletResponse对象修改响应信息：

		响应行： http协议版本  状态码  描述
				response.setStatus()  设置状态码
						   (sidei te)	

		响应头： （ location (结合302状态码完成请求重定向功能)、refresh(定时刷新)、 Content-Type 、 Content-Disposition (以下载的方式打开) ）
				response.setHeader("name","value")  设置响应头

             ---------------- 一个空行   ------------------------------

		实体内容：
				response.getWriter().writer();			发送字符实体内容
				response.getOutputStream().writer()		发送字节实体内容 




	------------  具体请看DAY_9的_06  --------------------
	4.4 案例- 请求重定向（Location）
	4.5 案例- 定时刷新(refresh)
	4.6 案例-content-Type作用	



总结：
	
	http协议： 浏览器和服务器之间数据传输的格式规范

	

	1）http请求：
			格式：
					请求行
					请求头
					空行
					实体内容（POST提交的数据在实体内容中）
			重点： 
				使用HttpServletRequest对象： 获取请求数据


	2）http响应;
			格式：
					响应行
					响应头
					空行
					实体内容（浏览器看到的内容）
			重点：
				使用HttpServletResponse对象： 设置响应数据

		
DAY 10 _ 02

作业 通讯录
	功能  
			添加联系人
			修改
			删除
			查询
	要求
			console控制
			数据保存在xml中
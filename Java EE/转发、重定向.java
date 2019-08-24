5） 写出转发与重定向代码。 并说出转发与重定向时的区别。
							 			转发是服务器的行为，重定向是客户端的行为
	
	
	
	'转发 : 浏览器 地址不变  
			Request中 存放的变量全部失效 （）进入新的）
	request.getRequestDispatcher(“success.jsp”).forward(request,respone)
						//转发到 success.jsp
	Jsp页面 转发：
	< jsp : forward  page=”apage.jsp” />

	流程：      客户端请求  web服务器 
				 调用内部方法，容器内完成请求处理 和 转发 
				 发送目标资源
	
	用途： 有数据传递、查询、表单提交，
 




	'重定向 ： 浏览器 地址不变  （实际是二次请求  网站可任意）
			Request中 变量不变
	response.sendRedirect(“success.jsp”)  //重定向到 success.jsp

	流程：客户端请求  web服务器接收，发送302状态码及新的 location 给客户端
				 浏览器 收到302 ，则自动发新的 请求 url 是 location 地址 
				 服务器按请求响应给客户
	
	用途： 修改数据操作 、 没有数据传递

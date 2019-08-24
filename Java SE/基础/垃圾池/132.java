String name = new String(name.getBytes("ios-8859-i"),"utf-8");
request.set Character Encoding ("utf-8");


window(浏览器)  document(白色区域)  
status(状态栏)  location(地址栏) 
history(历史栏 前进 后退)

alert();
document.write();


Servlet 作用  用java语言开发动态资源技术


out   JspWriter    
	writer(); 向jsp缓冲区写出内容

	当满足以下条件之一，缓冲区内容写出：
			1）缓冲区满了
			2）刷新缓存区
			3）关闭缓存区
			4）执行完毕jsp页面

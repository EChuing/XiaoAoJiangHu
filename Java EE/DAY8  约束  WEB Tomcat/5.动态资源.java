开发动态资源
	静态资源： 当用户多次访问这个资源，资源的源代码永远不会改变
	动态资源： 多次访问                                    会改变




Servlet技术

		用 java 语言编写动态资源的开发技术

Servlet特点：
	1）普通的java类， 继承HttpServlet类
	2）Servlet类只能交给tomcat服务器运行 （开发者自己不能运行）

Servlet手动编写"步骤：
	
	1）编写一个servlet程序，继承HttpServlet
	----------------------------------------------------	

		import java.io.IOException;
		import java.util.Date;
		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;


		public class HolleServlet extends HttpServlet {
			
			//覆盖doGet方法				（v  侩site）请求	（vsi bom）响应
	(putake ti.d)protected void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				//解决中文乱码问题
				resp.setContentType("text/html;charset=utf-8");
				//向浏览器输出内容
				resp.getWriter().write("这是第一个servlet程序.当前时间为："+new Date());
			}	        (ruai te)
		}
		---------------------------------------------

	2）找到HelloServlet类的class字节码，然后把拷贝到tomcat的一个web应用中WEB-INF/classes目录下。
	3）在当前web应用下的web.xml文件配置Servlet。
	--------------------------------------
		<!-- 配置一个servlet程序 -->
	<servlet>
		<!-- servlet的内部名称 ，可以自定义-->
		<servlet-name>HelloServlet</servlet-name>
		<!-- servlet类名： 包名+简单类名-->
		<servlet-class>gz.itcast.d_servlet.HelloServlet</servlet-class>
	</servlet>

	<servlet-mapping>
		<!-- servlet的内部名称，和上面的名称保持一致！！！-->
		<servlet-name>HelloServlet</servlet-name>
		<!-- servlet的访问名称： /名称 -->
		<url-pattern>/hello</url-pattern>
	</servlet-mapping>            (pa ten)

		--------------------------------

	4）启动tomcat服务器，运行访问
	   访问servlet:   http：//localhost：8080/myweb/hello
	

----------------------------------------------

今天作业
			1）手动编写并运行一个servlet程序。
			2）用myecplise建立servlet程序。

    明天：		http协议   用到servlet程序。（重点）
	后后天：	servlet编程 （理解servlet原理）


			
		总结： 
				web开发入门
				1）web服务器作用：共享本地资源给外部访问
				2）tomcat服务器： 基本操作
				3）编写一个规范的web应用
				4）如何编写一个动态资源（手动+工具）











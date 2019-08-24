servlet 步骤
	1.普通类 继承HttpServlet
	2.将class字节码文件拷贝到tomcat/webapps/WEB-INF/classes目录下
	3.配置web.xml文件的<servlet>
	4.启动tomcat服务器，运行访问



2.
--------------------------------
导入tomcat的 servlet-apt.jar 包

public class HolleServlet extends HttpServlet {
	//覆盖doGet方法
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
				throws ServletException,IOException{
		resp.setContenType(............);
		resp.getWriter().(write)
;		}
	}
}




3.
-------------------------------
<servlet>
	<servlet-name></servlet-name>
	<servlet-class></servlet-class>
</servlet>

<servlet-mapping>
	<servlet-name></servlet-name>
	<url-pattern></url-pattern>
</servlet-mapping>

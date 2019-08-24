package cn.itcast.servle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 控制层开发                                           
 * @author Administrator
 * 
 * 新建是 注意
 * 选择：  doGet() doPost()
 *注意URL：    /admin    
 */

 ----------------Servlet 文件 -和下面对应---------------
public class AdminServlet extends HttpServlet {
public class AdminSerblet extends HttpSreblet
{
}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		this.doGet(request, response);
	}



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

--------------------web.xml 文件----------------------------

<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" 
	xmlns="http://java.sun.com/xml/ns/javaee" 
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
	http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">


   <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  	</welcome-file-list>
</web-app>   
 HttpServletRequest 对象
	
     作用是用于获取请求数据。

     核心的API：
	
	
     请求行： 
		request.getMethod();					获取请求方式  （GET/POST）
		
		---以下少用
		request.getRequetURI()/request.getRequetURL()		获取请求资源的URI/URL
		request.getProtocol()					请求http协议版本

      请求头：
		request.getHeader("名称")   根据请求头获取请求值
		request.getHeaderNames()    获取所有的请求头名称

       实体内容:（POST中才有）
		request.getInputStream()   获取实体内容数据




service 和 doXX方法区别    ?




请求参数如何获取	


	GET方式： 参数放在URI后面        域名行例
	POST方式： 参数放在实体内容中   保存在实体内容中 


获取请求的 实体内容

	获取GET方式参数：
			request.getQueryString();
	获取POST方式参数：
			request.getInputStream();


	问题：但是以上两种不通用，而且获取到的参数还需要进一步地解析。
	所以可以使用统一方便的获取参数的方式：
		

	核心的API：		   “参数名”	
		request.getParameter("name");	根据参数名获取参数值（注意，只能获取一个值的参数）
		request.getParameterValue("name")；	根据参数名获取参数值（可以获取多个值的参数）

		request.getParameterNames();   获取所有参数名称列表  
		
		


3.9 请求参数编码问题
		
		修改POST方式参数编码：
		request.setCharacterEncoding("utf-8");
		
		
		修改GET方式参数编码：
		手动解码：String name = new String(name.getBytes("iso-8859-1"),"utf-8");





-------------------------------------------------------------------
package gz.itcast.b_request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取GET方式和Post方式提交的参数
 * @author APPle
 *
 */
public class RequestDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 设置参数查询的编码
		 * 该方法只能对请求实体内容的数据编码起作用。POST提交的数据在实体内容中，所以该方法对POST方法有效！
		 * GET方法的参数放在URI后面，所以对GET方式无效！！！
		 */
		request.setCharacterEncoding("utf-8");
		
		
	/*	System.out.println("GET方式");
		//接收GET方式提交的参数
		String value = request.getQueryString();
		System.out.println(value);*/
		
		
		/**
		 * 统一方便地获取请求参数的方法
		 */
		System.out.println(request.getMethod()+"方式");
		//getParameter(name): 根据参数名得到参数值(只能获取一个值的参数)
		String name = request.getParameter("name");
		
		/**
		 * 手动重新解码(iso-8859-1 字符串-> utf-8 字符串)
		 */
		/*if("GET".equals(request.getMethod())){
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		}*/
		
		String password = request.getParameter("password");
		
		/*if("GET".equals(request.getMethod())){
			password = new String(password.getBytes("iso-8859-1"),"utf-8");
		}*/
		
		System.out.println(name+"="+password);
		
		System.out.println("=============================");
		Enumeration<String> enums = request.getParameterNames();
		while( enums.hasMoreElements() ){
			String paramName = enums.nextElement();
			
			//如果参数名是hobit，则调用getParameterValues
			if("hobit".equals(paramName)){
				/**
				 * getParameterValues(name): 根据参数名获取参数值（可以获取多个值的同名参数）
				 */
				System.out.println(paramName+":");
				String[] hobits = request.getParameterValues("hobit");
				for(String h: hobits){
				/*	if("GET".equals(request.getMethod())){
						h = new String(h.getBytes("iso-8859-1"),"utf-8");
					}*/
					System.out.print(h+",");
				}
				System.out.println();
				//如果不是hobit，则调用getParameter
			}else{
				String paramValue = request.getParameter(paramName);
				/*
				if("GET".equals(request.getMethod())){
					paramValue = new String(paramValue.getBytes("iso-8859-1"),"utf-8");
				}*/
				
				System.out.println(paramName+"="+paramValue);
			}
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*System.out.println("POST方式");
		InputStream in = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while(  (len=in.read(buf))!=-1 ){
			System.out.println(new String(buf,0,len));
		}*/
		
		/**
		 * 统一方便地获取请求参数的方法
		 */
		/*System.out.println("POST方式");
		//根据参数名得到参数值
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+"="+password);
		
		System.out.println("=============================");
		Enumeration<String> enums = request.getParameterNames();
		while( enums.hasMoreElements() ){
			String paramName = enums.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}*/
		
		//一定调用doGet方式
		this.doGet(request, response);
	}

}
testParam
-----------------------------------------------------------------
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>请求参数传递和接收问题</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  <h3>GET方式提交</h3>
    <form action="/day09/RequestDemo5" method="GET">
    	用户名：<input type="text" name="name"/><br/>
    	密码：<input type="password" name="password"/><br/>
    	性别：
    	<input type="radio" name="gender" value="男"/>男
    	<input type="radio" name="gender" value="女"/>女<br/>
    	籍贯：
    		<select name="jiguan">
    			<option value="广东">广东</option>
    			<option value="广西">广西</option>
    			<option value="湖南">湖南</option>
    		</select>
    		<br/>
    	爱好：
    	<input type="checkbox" name="hobit" value="篮球"/>篮球
    	<input type="checkbox" name="hobit" value="足球"/>足球
    	<input type="checkbox" name="hobit" value="羽毛球"/>羽毛球<br/>
    	个人简介：
    	<textarea rows="5" cols="10" name="info"></textarea><br/>
    	<!-- 隐藏域 -->
    	<input type="hidden" name="id" value="001"/>
    	<input type="submit" value="提交"/>
    </form>
    <hr/>
    
    <h3>POST方式提交</h3>
    <form action="/day09/RequestDemo5" method="POST">
    	用户名：<input type="text" name="name"/><br/>
    	密码：<input type="password" name="password"/><br/>
    	性别：
    	<input type="radio" name="gender" value="男"/>男
    	<input type="radio" name="gender" value="女"/>女<br/>
    	籍贯：
    		<select name="jiguan">
    			<option value="广东">广东</option>
    			<option value="广西">广西</option>
    			<option value="湖南">湖南</option>
    		</select>
    		<br/>
    	爱好：
    	<input type="checkbox" name="hobit" value="篮球"/>篮球
    	<input type="checkbox" name="hobit" value="足球"/>足球
    	<input type="checkbox" name="hobit" value="羽毛球"/>羽毛球<br/>
    	个人简介：
    	<textarea rows="5" cols="10" name="info"></textarea><br/>
    	<!-- 隐藏域 -->
    	<input type="hidden" name="id" value="001"/>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>

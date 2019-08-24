框架的好处：    用action 替代 Servlet  ，统一代码 为方便开发   
Sturts 1 : 最早的一种MVC模式框架

"配置流程
si chua s tu
Struts 2 ：  开发步骤    --apache成员

	1.引 jar 包
			|lib基本包
	
	2.配置 web.cml  引入核心功能
			|配置过滤器
		----------------------------------
				<!--  引入struts核心过滤器 -->
		<filter>
			<filter-name>struts2</filter-name>   <!--  Ctrl + Shift + T   输入Struts*P*and*E   复制路径 -->
			<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
		</filter>

		<filter-mapping>
			<filter-name>struts2</filter-name>
'				<url-pattern>/*</url-pattern>
		</filter-mapping>
	

	3.开发action
		-----------------------------------
			import com.opensymphony.xwork2.ActionSupport;
			/**
		 * 开发action 
		 * 处理请求
		 * @author Administrator
		 */
		public class HelloAction extends ActionSupport {
			
			public String excute() throws Exception{
					System.out.println("反");
					
					//访问到action 处理请求
					//调用service
					
					
				//最后返回是 跳转的标记
				return "success";
			}
		}
	
	4.配置action
		src/struts.xml
		------------------------------------
			<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE struts PUBLIC
					  "-//Apache Software Foundation//DTD Struts Configuration 2.0//EN"
					  "http://struts.apache.org/dtds/struts-2.0.dtd">
					  
					  
					  
					  
			<struts>   <!--  name随便    后面固定   -->
				<package name="xxxx" extends="struts-default">
					<!--     uri 访问的路径                                             处理的类							类的方法	 -->
					<action name="hello" class="cn.itcast.action.HelloAction" method="execute">
						<!--       返回的标记是什么           跳转的页面                           -->
						<result name="success">/success.jsp</result>
					</action>
				</package> 

			</struts>



"Strut 执行流程
	服务器启动：
		1. 加载项目web.xml
		2. 创建Struts核心过滤器对象， 执行filter   init()
				struts-default.xml,    核心功能的初始化
				struts-plugin.xml,     struts相关插件
				struts.xml			   用户编写的配置文件

	访问：
		3. 用户访问Action, 服务器根据访问路径名称，找对应的aciton配置, 创建action对象
		4. 执行默认拦截器栈中定义的18个拦截器
		5. 执行action的业务处理方法

	struts-default.xml, 详解
			目录：struts2-core-2.3.4.1.jar/ struts-default.xml
			内容：
				1. bean节点指定struts在运行的时候创建的对象类型
				2.指定struts-default包  【用户写的package(struts.xml)一样要继承此包 】
						package  struts-default  包中定义了：
					a.  跳转的结果类型
						dispatcher    转发，不指定默认为转发
						redirect       重定向
						redirectAction  重定向到action资源
						stream        (文件下载的时候用)
					b. 定义了所有的拦截器
						定义了32个拦截器！
						为了拦截器引用方便，可以通过定义栈的方式引用拦截器，
						此时如果引用了栈，栈中的拦截器都会被引用!
					
						defaultStack
							默认的栈，其中定义默认要执行的18个拦截器！


					c. 默认执行的拦截器栈、默认执行的action
				<default-interceptor-ref name="defaultStack"/>
               <default-class-ref class="com.opensymphony.xwork2.ActionSupport" />


			<interceptor name="prepare" class="com.opensymphony.xwork2.interceptor.PrepareInterceptor"/>
			<interceptor name="params" class="com.opensymphony.xwork2.interceptor.ParametersInterceptor"/>

拦截器（先睹为快）：
	拦截器功能与过滤器功能类似。
	区别：
		共同点： 都拦截资源！
		区别：
			过滤器，拦截器所有资源都可以；  (/index.jsp/servlet/img/css/js)
			拦截器，只拦截action请求。
			
			拦截器是struts的概念，只能在struts中用。
			过滤器是servlet的概念，可以在struts项目、servlet项目用。


// 面试题： 拦截器什么时候执行？ (访问/启动)  先执行action类创建，先执行拦截器？
	// --》 1. 用户访问时候按顺序执行18个拦截器；
	//---》 2. 先执行Action类的创建，再执行拦截器； 最后拦截器执行完，再执行业务方法





































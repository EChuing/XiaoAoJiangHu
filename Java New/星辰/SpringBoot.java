package com.fangzhizun.cowxgzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ServletComponentScan
public class CowxgzhApplication {

	public static void main(String[] args) {
		SpringApplication.run(CowxgzhApplication.class, args);
	}
}

----------------------------------------------------------------------------------------------
springboot 启动类注解
   '@EnableTransactionManagement  //开启事务支持
   '@SpringBootApplication = (默认属性)	@Configuration + @EnableAutoConfiguration + @ComponentScan。
   	    @Configuration + @Bean
   	    	 这两个注解就可以创建一个简单的spring配置类,可以用来替代相应的xml配置文件。
   	    @Configuration
   	    	 的注解类标识这个类可以使用Spring IOC容器作为bean定义的来源。@Bean注解告诉Spring,
   	    	 一个带有@Bean的注解方法将返回一个对象,该对象应该被注册为在Spring应用程序上下文中的bean。

   	    @EnableAutoConfiguration
   	    	 能够自动配置spring的上下文,试图猜测和配置你想要的bean类,
   	    	 通常会自动根据你的类路径和你的bean定义自动配置。

   	    @ComponentScan
   	    	 会自动扫描指定包下的全部标有@Component的类,并注册成bean,
   	    	 当然包括@Component下的子注解@Service,@Repository,@Controller。

   '@ServletComponentScan
   			注解后,Servlet、Filter、Listener 可以直接通过
   			@WebServlet、@WebFilter、@WebListener 注解自动注册,无需其他代码









springboot 整合 springMVC
	pom.xml
		'spring-boot-starter-web
			springboot 通过引用spring-boot-starter-web依赖,整合SpingMVC框架
			通过Maven继承的方式引用到Spring-aop,Spring-beans,Spring-core,Spring-web等相关依赖。




	注解
		'@Configuration       //配置
		'@EnableWebMvc		//启动webmvc       此注解就是开启SpringMVC容器
		'@ComponentScan(basePackages = { "com.springboot.controller" })   // 组件扫描

	springBoot框架流程：
		先创建Tomcat容器,然后加载class文件,加载过程中如果发现有java代码编写的SpringMVC初始化,
		就会创建SpringMVC容器。所有程序执行完毕后,项目就可以访问了。






路径类注解
	https://cloud.tencent.com/developer/article/1082720

	'@Controller

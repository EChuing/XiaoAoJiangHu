springMVC
基于 Servlet   小型服务器


									
						
										前端核心处理器
V kuesi te(请求)						disi pei scher li （分发器）			  handelo mapi 处理器映射			  
request	   《需求传送》					DispatcherServlet	     											
----------------------------------->[				  ]--------------------->[   handlerMapping  ]--------




			控制层   kan que li							模型和视图 （modouand Ve o）
--------->[ Controller     ]--------结果返回-- 封装到---->[ ModelAndView  ]-------->-



						视图解析器									视图层				(Vsi bansi)相应
--------->------------->[ViewResolver]---------------------------->[View(jsp)]----------->response


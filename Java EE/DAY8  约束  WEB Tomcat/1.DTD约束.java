2.1 
XML约束要求： 通熟易懂，根据约束内容写出符合规则的xml文件




	XML 语法： 规范的xml文件的基本编写规则。   （有 w3c 组织规定的）
	XML 约束： 规范XML文件数据内容格式的编写规则。（由开发者自行定义）

2.2 约束技术

	DTD约束： 语法和功能 都相对简单，学习成本低！
	Schema （si gimen）约束：     复杂，         高！ （名称空间）

后缀名为     xxx.dtd
同名标签只能受到一个约束








2.3 DTD约束
	     
DTD 导入
				直接在XML中写	
	内部导入  <!DOCTYPE note [
				   <!ELEMENT not (to,from.heading,body)>   
						<!ELEMENT to		(#PCDATA)>
						<!ELEMENT from		(#PCDATA)>
						<!ELEMENT heading	(#PCDATA)>
						<!ELEMENT body		(#PCDATA)>
					]> 
	
						 
						 根元素
	外部导入 <!DOCTYPE   note     SYSTEM "路径">
	
											文件名
	公共导入 <!DOCTYPE 根元素 PUBLIC   "http//：：" >  多用于网上引入别人的框架 


 DTD 语法
			约束标签 
					<!ELEMENT 元素名 类别>  或 <!ELEMENT  名  （元素内容）>
			

			----限制内容		
				类别：
					空标签			EMPTY		内容为空为空 
					普通字符串		PCDATA		内容已定位普通字符串（不能含有子标签）
					任何内容		ANY			任意内容  无限制
					

				顺序问题			元素内容
					<!ELEMENT  元素名称  （A,B,...,...）>  括号内的子标签 依次出现   
				
				次数问题
					标签	：		必须且出现一次
					标签+	：		最少出现一次   可多次
					标签*	：		0 到 n 次
					标签？	：		0 到 1 次
			约束属性
					<!ATTLIST 元素名称  属性名称 属性类型 默认值>
										  属性类型					
			
			----限制标签的属性
				默认值：
					#REQUIRED（rui kuaide）		属性值是必须的				不写就报错提示没有属性  （属性和元素名称一致）
					#IMPLIED		属性非必须的							属性值可写可不写
					#FIXED value	属性非必须的，但属性值是固定的	
					（fei si）
			
			
			----控制属性内容
				属性类型：
					 CDATA		普通字符串				
					(a|A|c)     （枚举类型）任性其中一值
					ID			表示 XML 文档的ID值唯一，以字母开头  （不能出现重复）












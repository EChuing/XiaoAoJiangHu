xml基础回顾
	xml作用
		用作 软件配置文件
			  小型数据库

	xml语法 ( w3c组织规定 )
		标签：	标签名 不能数字开头，中间不能有空格，区分大小写，根标签（唯一）
		属性：	可多个，属性值必须用引号（单/双都可，不能混用），不能省略
		文档声明：	<xml version="1.0" encoding="utf-8"?>
					encoding="utf-8":打开或解析xml时 的编码
					
					注：xml保存时 里面的和保存文件编码类型要一致
	xml解析
		程序读取或操作xml文档
		
		两种解析方式： 
				
				DOM解析：xml一次性加载成Decument树，通过Decument 得到节点对象
						 通过节点访问xml文档内容（标签 实训 文本 注释）

						 把XML文档当成对象处理，文档加载到内存，构造树结构，通过节点访问xml文档内容
				
				SAX解析：

		Dom4j工具 （基于DOM 解析原理）
			读取xml文档：
				Document doc = new SAXReader().read("xml文件"); 

			节点：	
				nodeIterator();		所有节点
			标签：
				element("名称")		指定名称的第一个子标签对象
				elementIterator("名称");  指定名称的所有子标签对象
				elements();			所有子标签对象
			属性：
				attributeValue（"名称"）		指定名称的属性值
				attribute("名称")	指定名称的属性对象
				getName()		属性名称
				getValue()		属性值
				atributeIterator()  所有属性对象（Iterator）
				attributes()		所有属性对象（List）
			文本：
				getText()  得到当前标签的文本
				elementText("子标签名称")  得到子标签的文本

				
今天的目标：     Dom4J修改xml   + xPath技术  + SAX解析 + XML约束







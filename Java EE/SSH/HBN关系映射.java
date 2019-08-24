关系映射:

	
	
	当前表
	//主键表
	<class name-"" table="">
		//这ID代表唯一的主键
		<id name="" column="">//在这里的外键字段 就是应用当前表的主键字段
	
	
	
	一对多：
		<set name="映射的集合属性"  table="(可选)集合属性对应的表 或 外键表" >
			<key column="外键表的 外键字段"/>  
			<one-to-many class="集合元素的类型"/>
		</set>


	多对一：
		<set    >
			<many-to-one name="对象属性" class="对象类型" column="外键字段">
		</set>


	多对多：
		<set  name="映射集合属性"   table="中间表 或 关系表" >
			<key column="关系表的外键字段	"/>
			<many-to-many column="" class="">
		</set>
jsp 的post请求映射
   
  ' 注解方式： (直接在java方法头用)
   @Action("querySensorDevice")



  '	struts.xml  配置形式：    positionDeviceAction对应 xxxAction.java    insertListSeat  是xxxAction.java   中的方法
	<package name="positionDeviceAction" extends="json-default" namespace="/">
		<!-- 添加座位 -->
		<action name="insertListSeat" class="positionDeviceAction" method="insertListSeat">
		</action>
	</package>






struts.xml 文件
   <?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE struts PUBLIC "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN" "http://struts.apache.org/dtds/struts-2.3.dtd">

<struts>

	<constant name="struts.multipart.maxSize" value="1000000000" />
    <constant name="struts.enable.DynamicMethodInvocation" value="false" />
    <constant name="struts.devMode" value="true" />



		<package name="positionDeviceAction" extends="json-default" namespace="/">
			<!-- 查询所有位置设备 -->
			<action name="queryPositionDeviceList" class="positionDeviceAction" method="queryPositionDeviceList">
			</action>
			<!-- 插入设备 -->
			<action name="updatePositionDevice" class="positionDeviceAction" method="updatePositionDevice">
			</action>
			<!-- 离职人员操作 -->
			<action name="deletePositionDevice" class="positionDeviceAction" method="deletePositionDevice">
			</action>
			<!-- 添加座位 -->
			<action name="insertListSeat" class="positionDeviceAction" method="insertListSeat">
			</action>
		</package>



</struts>

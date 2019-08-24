
初始设置-公寓设置，添加“下定金”通用功能，开关：money_switch(1：开，2：关)	；数额：money_values，目前只用于微信公众号


		money_switch	下定金开关(1：开，2：关)		

		money_values	下定金数额


ALTER TABLE `sys_company_var` ADD COLUMN `money_switch` INT(1) NULL DEFAULT '2' COMMENT '下定金开关(1：开，2：关)' AFTER `campus_message_switch`, ADD COLUMN `money_values` INT(1) NULL DEFAULT '0' COMMENT '下定金数额' AFTER `money_switch`;
SELECT `DEFAULT_COLLATION_NAME` FROM `information_schema`.`SCHEMATA` WHERE `SCHEMA_NAME`='rental_sys';





前端
		 <div id="moneySwitchDiv" style="width: 100%;color:black;float:left;">
			 租房定金：<input id="moneySwitch" type="checkbox" />
			 <span style="color:red;font-size:13px">用途：勾选，开启定金功能</span>
			 <br><br>
			 <input type="button" value="保存" onclick="doSaveVariable('moneySwitch')">
			 <input type="button" value="恢复初始" onclick="recoveryVariable('moneySwitch')">
			 <br><br>
		 </div>
		 <div id="moneyValuesDiv" style="width: 100%;color:black;float:left;">
			 租房定金数额：<input id="moneyValues" type="text" />
			 <span style="color:red;font-size:13px">用途：设置定金的数额</span>
			 <br><br>
			 <input type="button" value="保存" onclick="doSaveVariable('moneyValues')">
			 <input type="button" value="恢复初始" onclick="recoveryVariable('moneyValues')">
			 <br><br>
		 </div>





JQ, 前端onclick触发
		else if(id == 'moneySwitch'){

			var moneySwitch = $("#moneySwitch").prop('checked')? 1 : 2 ;
			console.log(moneySwitch);
			if( moneySwitch  == 1){
				$.messager.confirm("操作提示", "开启，请设置定金数额");
			}
			updateJson = {moneySwitch :moneySwitch};
		}else if(id == 'moneyValues') {
			var moneyValues = $("#moneyValues").val();
			updateJson = {moneyValues: moneyValues};
		}



实体类
		private intger moneySwitch
		private intger moneyValues

		get
		
		set
	
		toString




mapper.xml
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
		<mapper namespace="com.zz.mapper.sys.SysVariablesMapper" >
		   <resultMap id="BaseResultMap" type="com.zz.po.sys.SysVariables" >
			<id column="variables_id" property="variablesId" jdbcType="INTEGER" />
				<result column="money_switch" property="moneySwitch" jdbcType="INTEGER" />
				<result column="money_values" property="moneyValues" jdbcType="INTEGER" />
		   </resultMap>






		  <update id="updateByPrimaryKeySelective" parameterType="com.zz.po.sys.SysVariables" >
				update sys_company_var
			   <set>
				<if test="moneySwitch != null and moneySwitch != ''" >
					 money_switch = #{moneySwitch,jdbcType=INTEGER},
				</if>
				<if test="moneyValues != null and moneyValues != ''" >
					 money_values = #{moneyValues,jdbcType=INTEGER},
				 </if>

			   </set>
			where variables_id = 1
		  </update>






		 <update id="recoveryFirst" parameterType="com.zz.po.sys.SysVariables" >
				update sys_company_var
			 <set >
			<if test="moneySwitch != null" >
						money_switch = ( select a.moneySwitch from (select money_switch moneySwitch from sys_company_var where variables_id = 2) a),
				</if>
				<if test="moneyValues != null and moneyValues !=''">
						money_values = ( select a.moneyValues from (select money_values moneyValues from sys_company_var where variables_id = 2) a),
				</if>
			</set>
			where variables_id = 1
			</update>
		</mapper>
resultMap  (ru燥 Map)	结果映射




MyBatis  的ONGL表达式



<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="com.zz.mapper.sys.SysUserMapper" >
	<resultMap id="BaseResultMap" type="com.zz.po.sys.SysUserExpand" > 		//  id: 对应下面的resultMap     type: 返回的数据类型
		<id column="user_coding" property="userId" jdbcType="INTEGER" /> 	// ->  数据库字段  -  Java字段 - 数据类型
	</resultMap>

	//      id对应接口中的方法      -      上面有        -	   	parameterType： 参数的数据类型(可用路径形式)
	<select id="nameNumber" resultMap="BaseResultMap" parameterType="com.zz.po.sys.SysUserExpand">
  	select u.user_coding,u.su_department_id,u.su_store_id,u.su_staff_name,dt.department_name departmentName, u.su_state,

   /*   以下为参考用 ----------------
   <where>
  		su_state = '正常'
  		<if test="suDepartmentId != null and suDepartmentId != ''">
  			and su_department_id = #{suDepartmentId,jdbcType=INTEGER}</if>
  		<if test="userId != null and userId != '' ">
  			and user_coding = #{userId,jdbcType=INTEGER}
  		</if>
  	</where>
	*/

  </select>
</mapper>


扩展：
	/**
	id="countByClass" 接口中定义的方法    public  int getEmpWhereIF （long classId）;
	resultType="int"： 定义返回的数据类型
	parameterType="java.lang.Long" : 定义参数类型
	*/
	<select id="countByClass" resultType="int" parameterType="java.lang.Long" databaseId="mysql">
        select count(id)  as total from t_user where class_id = #{classId,jdbcType=BIGINT}
    </select>


注： 二级缓存： 查询同个id 会直接从缓存中获取数据，，不在重复sql查询
				前提：全局配置文件开启：<setting name="cacheEnabled" value="true"/>







一个Mapper.xml 对应一个实体类 <mapper namespace="com.zz.mapper.journal.PositionDeviceMapper" >  PositionDeviceMapper ： 实体类

涉及查询,就要写   <result column="hs_add_community" property="hsAddCommunity" jdbcType="VARCHAR" />










'批量插入
    <insert id="insertListSeat" parameterType="java.util.List">
        insert into position_device
        (
        pd_hs_id,
        pd_position_name
        )
        values
        <foreach collection="imageUrlBeen" item="item" index= "index" separator =",">
        (
        #{item.pdHsId    },
        #{item.pdPositionName    }
        )
        </foreach>
    </insert>




'批量修改  ( 据说有三种方法 )
	<update id="updateDeviceList" parameterType="java.util.List">
		<foreach collection="imageUrlBeen" item="item" index="index" open="" close="" separator=";">
			update jour_device
			<set>
				dev_enable_state = #{item.devEnableState}
			</set>
			where id = #{item.id}
		</foreach>
	</update>
	一个foreach 代表一次循环修改

struts + spring + MyBatis
	jsp中POST请求   struts.xml对方法进形拦截，响应对应的Action.java （请求后端?） 
	Action 中的方法调用，执行SQL请求方法，

	Java请求SQL 流程： Action - PositionDeviceServiceImp - PositionDeviceMapper - XML文件
	如下：

	PositionDeviceBase.java				实体类   （包含有get set  toString）


	'PositionDeviceAction.java			Action类
			public class PositionDeviceAction extends BaseAction implements ModelDriven<PositionDeviceBase> {
			private PositionDeviceBase positionDeviceBase;

			@Autowired
			private PositionDeviceService positionDeviceService;

			@Override
			public PositionDeviceBase getModel() {
				if(positionDeviceBase==null){
					positionDeviceBase = new PositionDeviceBase();
				}
				return positionDeviceBase;
			}
		
					'---------------------------------------------------------------
					//批量添加座位
					public void insertListSeat() {
						try {
							List<PositionDeviceBase> imageUrlBeen = JSONArray.parseArray(positionDeviceBase.getJsonArray(),PositionDeviceBase.class);
							positionDeviceBase.setImageUrlBeen(imageUrlBeen);
							int result = positionDeviceService.insertListSeat(positionDeviceBase);

							if (result > 0) {
								String resultStr = JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
								printlnOfJson(resultStr);
							} else {
								printlnOfJson(CommonMethodClass.jsonData(-1, " 插入有误！", null));
							}
						} catch (Exception e) {
							e.printStackTrace();
							Syslog.writeErr(e);
							printlnOfJson(CommonMethodClass.jsonData(-2, "查不到数据 ！", null));
						}
					}
					'---------------------------------------------------------------


			}

	'PositionDeviceServiceImp.java		接口   
			public class PositionDeviceServiceImpl implements PositionDeviceService {
					@Resource
					private PositionDeviceMapper positionDeviceMapper;
						@Override
						public int insertListSeat(PositionDeviceBase positionDeviceBase) throws Exception {
						Integer result=positionDeviceMapper.insertListSeat(positionDeviceBase);
						return result;
						}
			}
	'PositionDeviceService.java			实现类
			public interface PositionDeviceService {
					//批量添加座位
					int insertListSeat(PositionDeviceBase positionDeviceBase)throws Exception;
			}
	'PositionDeviceMapper.java			Mapper映射
			public interface PositionDeviceMapper {
					//批量添加座位
					int insertListSeat(PositionDeviceBase positionDeviceBase) throws Exception;
			}
    'PositionDeviceMapper.xml		XML文件
			<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
			<mapper namespace="com.zz.mapper.journal.PositionDeviceMapper" >
				<resultMap id="BaseResultMap" type="com.zz.po.journal.PositionDeviceBase" >
					<result column="hs_add_community" property="hsAddCommunity" jdbcType="VARCHAR" />
				</resultMap>

				<!-- 批量插入座位-->
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
			</mapper>

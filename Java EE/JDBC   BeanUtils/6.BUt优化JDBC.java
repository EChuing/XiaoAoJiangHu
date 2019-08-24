package cn.itcast.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
	/**
     *  WebUtils类 
	 *
	 * JDBC表单信息优化
	 *   基于BeanUtils
	 */                                                     //Object obj 返回东西可能是空的  返回void
	public static <T> T copyToBean(HttpServletRequest request,Class<T> clazz){
		try {
			//需要 创建一个对象
			T t = clazz.newInstance() ; 
			
			//获取所有表单元素的名称
			Enumeration<String> enums= request.getParameterNames();
			//遍历
			while(enums.hasMoreElements()){
				//获取表单元素名称<input type="password" name="pwd"/>
				String name = enums.nextElement(); //pwd
				//获取名称对应的值
				String value = request.getParameter(name);
				//把指定属性名称对应的值进行拷贝       
					BeanUtils.copyProperty(t, name,value);
			}
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}




	/**
	 * 最简洁      （项目中的 WebUtils 类）
	 *   优化上面的BeanUtils
	 */
	public static <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		try {

			// （此处可以添加  注册日期类型转换器）用于处理各种表
			
			
			// 创建对象
			T t = clazz.newInstance();
			// 获取键值对  的方式			// 获取键值对  的方式
			BeanUtils.populate(t, request.getParameterMap());
			return t;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}





}

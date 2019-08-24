需要导入BenUtils的关联包

package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Admin;

public class AdmindAO extends BaseDao {

	//删除
	public void delete(int id){
		String sql = "selete from admin where id=?";
		Object[] paramsValue = {id};
		super.update(sql, paramsValue);//调用父类的方法
	}
	
	//插入
	public void save(Admin admin){
		String sql = "insert into admin (userName,pwd) values(?,?)";
		Object[] paramsValue = {admin.getUserName(),admin.getPwd()};
		super.update(sql, paramsValue);
		
	}
	//查询
	public List<Admin> getAll(){
		String sql ="select * from admin";
		List<Admin> list = super.query(sql, null, Admin.class);
		return list;
		
		
	}

}

-------------------------------------------------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.utils.JdbcUtil;

/**
 *	 调用dao， 自己写的所有的dao都继承此类
 *	此类定义了2个通用方法
 *		更新
 *		查询
 */
public class BaseDao {
	private Connection con ;
	private PreparedStatement pstmt ; 
	private ResultSet rs;
	
	/**
	 * 更新通用的方法
	 * @param sql	 更新的sql语句（update/inser/delete）
	 * @param paramsValues	sql语句中占位符对应的值（如果没有传入null）
	 */
	public void update(String sql,Object[] paramsValue){
		try {
			
			//获取连接                          get ke nashen
			con = JdbcUtil.getConnection();
			//创建执行命令的stmt对象
			pstmt = con.prepareStatement(sql);
			//参数元数据： 得到参数占位符    得到占位符的参数个数
			int count = pstmt.getParameterMetaData().getParameterCount();
			
			//设置占位符参数的值
			if(paramsValue !=null && paramsValue.length >0){
				//循环给参数赋值
				for( int i = 0 ; i < count ; i++ ) {
					pstmt.setObject(i+1	, paramsValue[i]);//从第一个开始
				}
			}
			//执行更新 (ex qiut)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
				//	  ruan taien E sa shen 运行时异常	
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(con, pstmt, null);
		}
		
	}
	/**
	 * 查询的通用方法
	 * @param sql
	 * @param paramsValue
	 * 泛型  先定义 <T> 后使用  List<T>
	 */
	public <T> List<T>  query(String sql,Object[] paramsValue, Class<T> clazz){
		try {
			
			//返回的集合
			List<T> list = new ArrayList<T>();
			//对象
			T t = null;
			
			//1.获取连接
			con = JdbcUtil.getConnection();
			//2.创建pstmt对象
			pstmt = con.prepareStatement(sql);
			//3.获取占位符参数的个数   并设置每个参数的值
			int count = pstmt.getParameterMetaData().getParameterCount();
			if(paramsValue !=null && paramsValue.length>0){
				for(int i=0; i<paramsValue.length ; i++){
					pstmt.setObject(i+1, paramsValue[i]);
				}
			}
			//4.执行查询
			rs = pstmt.executeQuery();
			//5.获取结果集元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			//----->获取列的个数
			int columnCount = rsmd.getColumnCount();
			//6. 遍历
			while(rs.next()){
				//要封装的对象
				t = clazz.newInstance();
				//7.遍历每一行的每一列，封装数据
				for(int i = 0;i<columnCount; i++){
					//获取每一列的类名称
					String columnName = rsmd.getColumnName(i+1);
					//每一列名称对应的值
					Object value = rs.getObject(columnName);
					//封装：设置到t对象的属性中
					BeanUtils.copyProperty(t, columnName, value);
				}
				//把封装完毕的对象，添加到list集合中
				list.add(t);
			}
			return list;
		} catch (Exception e) {
				throw new RuntimeException(e);
		}finally{
			JdbcUtil.closeAll(con, pstmt, null);
		}
	}
		

}

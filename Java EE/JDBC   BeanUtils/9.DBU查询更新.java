欠缺  Admin实体类  、 组件 包等



import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.itcast.utils.JdbcUtil;
/**
 * 使用DBUtils 组件 查询和更新
 * @author Administrator
 *
 */
public class App {

	//使用DBUtils组件	更新
	@Test
	public void testUpdate() throws Exception{
		String sql = "delete from admin where id=10";
		//1.1连接
		Connection con = JdbcUtil.getConnection();
		//1.2创建核心工具类   Qweli ruan ne
		QueryRunner qr = new QueryRunner();
		//1.3更新
		qr.update(con,sql);
		//
		
	}
	//使用DBUtils组件	查询
	@Test  
	public void testQuery() throws Exception{
		String sql = "select * from admin ";
		//1.1连接
		Connection con = JdbcUtil.getConnection();
		//1.2创建核心工具类   Qweli ruan ne
		QueryRunner qr = new QueryRunner();
		//1.3查询
		List<Admin> list =         // 结果集的封装 
				qr.query(con, sql, new BeanListHandler<Admin>(Admin.class));
		System.out.println(list);
	}
}

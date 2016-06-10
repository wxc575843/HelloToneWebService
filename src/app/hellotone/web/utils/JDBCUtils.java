package app.hellotone.web.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC工具类
 * @author 金云龙
 * 
 */
public class JDBCUtils {
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/*private static Properties props = new Properties();
	// static中的语句只执行一次,在当前类被加载时执行.
	static {
		try {
			
			 * 1 将配置文件中的内容加载到props对象中
			 
			// 获取类路径下的资源
			InputStream in = JDBCUtils.class.getResourceAsStream("/dbconfig.properties");
			// 加载配置文件
			props.load(in);
			
			 * 2 注册驱动类
			 
			Class.forName(props.getProperty("driverClassName"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}*/

	/**
	 * 获取连接对象
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		/*
		 * 3 获取连接对象
		 */
		/*Connection conn = DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"), props.getProperty("password"));*/
		
		return dataSource.getConnection();
	}
	
	public static void close(Statement stmt, Connection conn){
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	public static void close(Statement stmt, Connection conn, ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

}

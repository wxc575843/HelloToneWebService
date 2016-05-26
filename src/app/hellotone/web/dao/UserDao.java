package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
	public UserDao() throws IOException, ClassNotFoundException{
		manager = SqlManager.createInstance();
	}
	
	public boolean signIn(String username, String password) throws SQLException{
		boolean success = false;
		this.sql = "select Email,Password from User where Email=? and Password=?";
		Object[] params = new Object[]{username,password};
		manager.connectDB();
		rs=manager.executeQuery(sql, params);
		if(rs.next()) success=true;
		manager.closeDB();
		return success;
	}
}

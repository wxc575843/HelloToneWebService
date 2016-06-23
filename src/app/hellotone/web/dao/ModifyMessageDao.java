package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.model.CommunityNews;

public class ModifyMessageDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public ModifyMessageDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	public boolean modifyNick(String nickname,String email) throws SQLException {
		boolean r = false;
		sql = "Update User Set nickname=? where Email=?";
		Object[] params = {nickname,email};
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}
	
	public boolean modifyPassword(String email,String password) throws SQLException {
		boolean r=false;
		sql = "update User Set password=? where Email=?";
		Object[] params = {password,email};
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}
}

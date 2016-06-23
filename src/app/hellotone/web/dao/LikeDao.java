package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class LikeDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public LikeDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	public boolean like(String id,String userId) throws SQLException {
		boolean r = false;
		sql = "insert into User_Article_Like values(?,?)";
		Object[] params = {userId,id};
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}
	
	public boolean unlike(String id,String userId) throws SQLException {
		boolean r = false;
		sql = "delete from User_Article_Like where UserID=? and ArticleID=?";
		Object[] params = {userId,id};
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}

	public boolean islike(String articleId, String userId) throws SQLException {
		boolean r = false;
		sql = "select * from User_Article_Like where UserID=? and ArticleID=?";
		Object[] params = {userId,articleId};
		manager.connectDB();
		rs = manager.executeQuery(sql, params);
		if (rs.next()) {
			r = true;
		}
		manager.closeDB();
		return r;
	}
}

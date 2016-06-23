package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.enterprise.inject.New;

import app.hellotone.web.model.CommunityNews;

public class FavouriteDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public FavouriteDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	public boolean like(String id,String userId) throws SQLException {
		boolean r=false;
		sql = "insert into User_Article_Favourite values(?,?,?)";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Object[] params = {userId,id,df.format(new Date(0))};
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}
	
	public List<CommunityNews> getLikeNewsList(String userId) throws SQLException {
		List<CommunityNews> list = new ArrayList<CommunityNews>();
		Object[] params = {userId};
		sql = "call getLikeList(?)";
		manager.connectDB();
		rs = manager.executeQuery(sql, params); 
		
		while(rs.next()){
			CommunityNews communityNews = new CommunityNews();
			communityNews.setId(rs.getInt("ID"));
			communityNews.setContent(rs.getString("Content"));
			communityNews.setTitle(rs.getString("Title"));
			communityNews.setAuthor(rs.getString("Author"));
			communityNews.setPicUrl(rs.getString("Picture"));
			list.add(communityNews);
		}
		manager.closeDB();
		return list;
	}

	public boolean unlike(String articleId, String userId) throws SQLException {
		boolean r=false;
		sql = "delete from User_Article_Favourite where UserId=? and ArticleID=?";
		
		Object[] params = {userId,articleId};
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}

	public boolean isLike(String articleId, String userId) throws SQLException {
		boolean r = false;
		sql = "select * from User_Article_Favourite where UserID=? and ArticleID=?";
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

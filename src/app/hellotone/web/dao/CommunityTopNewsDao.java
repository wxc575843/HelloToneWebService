package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.model.CommunityNews;

public class CommunityTopNewsDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public CommunityTopNewsDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	public List<CommunityNews> getNews() throws SQLException {
		List<CommunityNews> list = new ArrayList<CommunityNews>();
		this.sql = "Select * from Article where Aclass = 'article' and Top = 1";
		manager.connectDB();
		this.rs = manager.executeQuery(this.sql, null);
		
		while (rs.next()) {
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
}

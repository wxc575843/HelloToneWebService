package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.model.Comment;

public class CommentDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public CommentDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	public List<Comment> getComment(String id) throws SQLException {
		List<Comment> list = new ArrayList<Comment>();
		Object[] params = {id};
		sql = "select * from commentarticle where ArticleID=?";
		manager.connectDB();
		rs = manager.executeQuery(sql, params);
		while(rs.next()){
			Comment comment = new Comment();
			comment.setArticleId(id);
			comment.setContent(rs.getString("Content"));
			comment.setDate(rs.getString("Cdate"));
			comment.setUserId(rs.getString("UserID"));
			comment.setNickname(rs.getString("Nickname"));
			list.add(comment);
		}
		manager.closeDB();
		return list;
	}
	
	public boolean addComment(String userId,String articleId,String content,String date) throws SQLException {
		boolean r = false;
		Object[] params={userId,content,date,articleId};
		sql="insert into Comments(UserID,Content,Cdate,ArticleID) values(?,?,?,?)";
		manager.connectDB();
		r = manager.executeUpdate(sql, params);
		manager.closeDB();
		return r;
	}
}

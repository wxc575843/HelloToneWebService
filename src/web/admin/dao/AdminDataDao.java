package web.admin.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.dao.SqlManager;
import app.hellotone.web.model.Admin;
import app.hellotone.web.model.Article;
import app.hellotone.web.model.CommunityNews;
import app.hellotone.web.model.Record;
import app.hellotone.web.model.User;

public class AdminDataDao {

	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public AdminDataDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	
	public List<Admin> findAllAdmin() throws SQLException {
		this.sql = "select * from Admin";
		List<Admin> admins = new ArrayList<Admin>();
		manager.connectDB();
		rs = manager.executeQuery(sql,null);
		while (rs.next()) {
			Admin admin = new Admin();
			admin.setId(rs.getInt("ID"));
			admin.setName(rs.getString("Aname"));
			admin.setPassword(rs.getString("Password"));
			admins.add(admin);
		}
		manager.closeDB();
		return admins;
	}
	
	public List<User> findAllUser() throws SQLException {
		this.sql = "select * from userfull";
		List<User> users = new ArrayList<User>();
		manager.connectDB();
		rs = manager.executeQuery(sql,null);
		while (rs.next()) {
			User user = new User();
			user.setStateCode(1);
			user.setId(rs.getInt("ID"));
			user.setNickName(rs.getString("Nickname"));
			user.setEmail(rs.getString("Email"));
			user.setGender(rs.getString("Gender"));
			user.setCountry(rs.getString("Country"));
			user.setLevel(rs.getInt("ULevel"));
			user.setChineseLevel(rs.getString("汉语水平"));
			user.setHeadPicture(rs.getString("头像"));
			user.setArticleNum(rs.getInt("ArticleNum"));
			user.setPostNum(rs.getInt("PostNum"));
			user.setExperience(rs.getInt("Experience"));
			user.setPassword(rs.getString("Password"));
			users.add(user);
		}
		manager.closeDB();
		return users;
	}
	
	public List<Record> findAllRecord() throws SQLException {
		this.sql = "select * from Record";
		List<Record> records = new ArrayList<Record>();
		manager.connectDB();
		rs = manager.executeQuery(sql,null);
		while (rs.next()) {
			Record record = new Record();
			record.setId(rs.getInt("ID"));
			record.setName(rs.getString("名称"));
			record.setExamplePath(rs.getString("Example"));
			record.setExplainPath(rs.getString("Explain"));
			record.setFilePath(rs.getString("存储路径"));
			record.setFilePathW(rs.getString("存储路径女"));
			record.setPicturePath(rs.getString("picture"));
			record.setRecordClass(rs.getString("Class"));
			record.setScore(rs.getDouble("历史最高分"));
			records.add(record);
		}
		manager.closeDB();
		return records;
	}
	
	public List<Article> findAllArticle() throws SQLException {
		this.sql = "select * from Article";
		List<Article> articles = new ArrayList<Article>();
		manager.connectDB();
		rs = manager.executeQuery(sql,null);
		while (rs.next()) {
			Article article = new Article();
			article.setAclass(rs.getString("Aclass"));
			article.setAuthor(rs.getString("Author"));
			article.setContent(rs.getString("Content"));
			article.setId(rs.getInt("ID"));
			article.setPicture(rs.getString("Picture"));
			article.setTitle(rs.getString("Title"));
			article.setTop(rs.getString("Top"));
			articles.add(article);
		}
		manager.closeDB();
		return articles;
	}
	
	public boolean deleteArticle(String id) throws SQLException {
		boolean lrs = false;
		this.sql = "delete from Article where ID=?";
		Object[] params = {id};
		manager.connectDB();
		lrs = manager.executeUpdate(sql, params);
		return lrs;
	}
	
	public boolean modifyArticle(Article article) throws SQLException {
		boolean lrs = false;
		this.sql = "update Article set Title=? ,Content=? ,Author=? ,Aclass=? ,Top=? ,Picture=? where Title=?";
		Object[] params = {article.getTitle(),article.getContent(),article.getAuthor(),article.getAclass(),article.getTop(),article.getPicture(),article.getTitle()};
		manager.connectDB();
		lrs = manager.executeUpdate(sql, params);
		return lrs;
	}
	
	public boolean insertArticle(Article article) throws SQLException {
		boolean lrs = false;
		this.sql = "insert into Article(Content,Title,Author,Aclass,Top,Picture) values(?,?,?,?,?,?) ";
		Object[] params = {article.getContent(),article.getTitle(),article.getAuthor(),article.getAclass(),article.getTop(),article.getPicture()};
		manager.connectDB();
		lrs = manager.executeUpdate(sql, params);
		return lrs;
	}
}

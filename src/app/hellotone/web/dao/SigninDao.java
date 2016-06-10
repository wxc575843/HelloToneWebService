package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.hellotone.web.model.User;

public class SigninDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
	public SigninDao() throws IOException, ClassNotFoundException{
		manager = SqlManager.createInstance();
	}
	
	public User signIn(String username, String password) throws SQLException{
		boolean success = false;
		this.sql = "select * from User where Email=? and Password=?";
		Object[] params = new Object[]{username,password};
		User user = new User();
		manager.connectDB();
		rs=manager.executeQuery(sql, params);
		if(rs.next()) {
			user.setStateCode(1);
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
		}
		manager.closeDB();
		return user;
	}
}

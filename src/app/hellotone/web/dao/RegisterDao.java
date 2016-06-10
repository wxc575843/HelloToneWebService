package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.model.PracticeCategroy;

public class RegisterDao {

	SqlManager manager;
	String sql = "";
	boolean rs;
	
	public RegisterDao () throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	}
	
	public boolean addUser(String email, String password, String nickName, String gender) throws SQLException {
		List<PracticeCategroy> practiceCategroys = new ArrayList<PracticeCategroy>();
		this.sql = "insert into User(Email,Password,Nickname,gender) value(?,?,?,?)";
		manager.connectDB();
		Object[] param = {email,password,nickName,gender};
		this.rs = manager.executeUpdate(this.sql, param);
		manager.closeDB();
		return this.rs;
	}
}

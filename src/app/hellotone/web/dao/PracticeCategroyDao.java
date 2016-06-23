package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.model.PracticeCategroy;

public class PracticeCategroyDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
	public PracticeCategroyDao() throws IOException, ClassNotFoundException{
		manager = SqlManager.createInstance();
	}
	public List<PracticeCategroy> getCategroy() throws SQLException{
		List<PracticeCategroy> practiceCategroys = new ArrayList<PracticeCategroy>();
		this.sql = "select distinct Class class from Record";
		manager.connectDB();
		this.rs = manager.executeQuery(this.sql, null);
		while(rs.next()){
			PracticeCategroy practiceCategroy = new PracticeCategroy();
			practiceCategroy.setItem(rs.getString("class"));
			System.out.println(rs.getString("class"));
			practiceCategroys.add(practiceCategroy);
		}
		return practiceCategroys;
	}
}

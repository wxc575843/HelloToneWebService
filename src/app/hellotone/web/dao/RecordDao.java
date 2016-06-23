package app.hellotone.web.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.hellotone.web.model.CommunityNews;
import app.hellotone.web.model.Record;

public class RecordDao {
	SqlManager manager;
	String sql = "";
	ResultSet rs;
	
    public RecordDao() throws IOException, ClassNotFoundException {
		manager = SqlManager.createInstance();
	} 
	
	public List<Record> getRecordList() throws SQLException {
		List<Record> list = new ArrayList<Record>();
		sql = "select * from Record order by ID desc";
		System.out.println("2333");
		manager.connectDB();
		rs = manager.executeQuery(sql, null);
		while(rs.next()){
			Record record = new Record();
			record.setId(rs.getInt("ID"));
			record.setExamplePath(rs.getString("Example"));
			record.setExplainPath(rs.getString("Explain"));
			record.setFilePath(rs.getString("存储路径"));
			record.setFilePathW(rs.getString("存储路径女"));
			record.setName(rs.getString("名称"));
			record.setPicturePath(rs.getString("picture"));
			record.setRecordClass(rs.getString("Class"));
			record.setScore(rs.getDouble("历史最高分"));
			list.add(record);
		}
		manager.closeDB();
		return list;
	}
	
	public boolean likeRecord(String userid,String recordid) throws SQLException {
		boolean b = false;
		sql="insert into User_Record_Favourite values(?,?,now())";
		Object[] params = {userid,recordid};
		manager.connectDB();
		b = manager.executeUpdate(sql, params);
		//sql = "insert into User_Record_Learn values(?,?,now(),0)";
		//b = manager.executeUpdate(sql, params);
		manager.closeDB();
		return b;
	}
	
	public List<Record> likeRecordList(String userid) throws SQLException {
		List<Record> list = new ArrayList<Record>();
		sql = "call RecordLikeList(?)";
		Object[] params = {userid};
//		System.out.println("2333");
		manager.connectDB();
		rs = manager.executeQuery(sql, params);
		while(rs.next()){
			Record record = new Record();
			record.setId(rs.getInt("ID"));
			record.setExamplePath(rs.getString("Example"));
			record.setExplainPath(rs.getString("Explain"));
			record.setFilePath(rs.getString("存储路径"));
			record.setFilePathW(rs.getString("存储路径女"));
			record.setName(rs.getString("名称"));
			record.setPicturePath(rs.getString("picture"));
			record.setRecordClass(rs.getString("Class"));
			record.setScore(rs.getDouble("历史最高分"));
			list.add(record);
		}
		manager.closeDB();
		return list;
		
	}

	public boolean unlike(String userid,String recordid) throws SQLException {
		boolean b = false;
		sql="delete from User_Record_Favourite where UserID=? and RecordID=?";
		Object[] params = {userid,recordid};
		manager.connectDB();
		b = manager.executeUpdate(sql, params);
		//sql = "insert into User_Record_Learn values(?,?,now(),0)";
		//b = manager.executeUpdate(sql, params);
		manager.closeDB();
		return b;
	}
	
	public boolean isLike(String userid,String recordid) throws SQLException {
		boolean b = false;
		sql="select * from User_Record_Favourite where UserID=? and RecordID=?";
		Object[] params = {userid,recordid};
		manager.connectDB();
		rs = manager.executeQuery(sql, params);
		if (rs.next()) {
			b=true;
		}
		//sql = "insert into User_Record_Learn values(?,?,now(),0)";
		//b = manager.executeUpdate(sql, params);
		manager.closeDB();
		return b;
	}
}

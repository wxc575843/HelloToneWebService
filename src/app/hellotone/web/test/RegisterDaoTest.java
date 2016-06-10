package app.hellotone.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import app.hellotone.web.dao.PracticeCategroyDao;
import app.hellotone.web.dao.RegisterDao;
import app.hellotone.web.model.PracticeCategroy;

public class RegisterDaoTest {

	RegisterDao registerDao;
	@Before
	public void Init() throws IOException, ClassNotFoundException{
		registerDao = new RegisterDao();
	}
	
	@Test
	public void testSignIn() throws SQLException{
		boolean b=false;
		String email = "1040142133@qq.com";
		String password = "123456";
		String nickName = "wxc575843";
		String gender = "0";
		b = registerDao.addUser(email, password, nickName, gender);
		if(b){
			System.out.println("success");
		}else{
			System.out.println("fail");
		}
		
	}

}

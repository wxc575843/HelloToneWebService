package app.hellotone.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import app.hellotone.web.dao.SigninDao;
import app.hellotone.web.model.User;

public class SigninDaoTest {

	SigninDao userDao;
	@Before
	public void Init() throws IOException, ClassNotFoundException{
		userDao = new SigninDao();
	}
	
	@Test
	public void testSignIn() throws SQLException{
		User user;
		user = userDao.signIn("zyt@ecnu.edu.cn", "h");
		if(user.getStateCode()==1){
			System.out.println("success");
			System.out.println(user.getChineseLevel());
			System.out.println(user.getArticleNum());
		}
		else System.out.println("fail");
	}

}

package app.hellotone.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import app.hellotone.web.dao.UserDao;

public class UserDaoTest {

	UserDao userDao;
	@Before
	public void Init() throws IOException, ClassNotFoundException{
		userDao = new UserDao();
	}
	
	@Test
	public void testSignIn() throws SQLException{
		boolean b=false;
		b = userDao.signIn("zyt@ecnu.edu.cn", "hellotone");
		if(b) System.out.println("Success");
		else System.out.println("Fail");
	}

}

package app.hellotone.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import app.hellotone.web.dao.PracticeCategroyDao;
import app.hellotone.web.dao.SigninDao;
import app.hellotone.web.model.PracticeCategroy;

public class PracticeCategoryTest {

	PracticeCategroyDao practiceCategroyDao;
	@Before
	public void Init() throws IOException, ClassNotFoundException{
		practiceCategroyDao = new PracticeCategroyDao();
	}
	
	@Test
	public void testSignIn() throws SQLException{
		boolean b=false;
		List<PracticeCategroy> list = practiceCategroyDao.getCategroy();
		for (PracticeCategroy practiceCategroy : list) {
			System.out.println(practiceCategroy.getItem());
		}
	}


}

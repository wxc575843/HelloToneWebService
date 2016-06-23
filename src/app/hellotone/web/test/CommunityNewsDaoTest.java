package app.hellotone.web.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import app.hellotone.web.dao.CommunityNewsDao;
import app.hellotone.web.dao.PracticeCategroyDao;
import app.hellotone.web.model.CommunityNews;
import app.hellotone.web.model.PracticeCategroy;

public class CommunityNewsDaoTest {

	CommunityNewsDao communityNewsDao;
	@Before
	public void Init() throws IOException, ClassNotFoundException{
		communityNewsDao = new CommunityNewsDao();
	}
	
	@Test
	public void testSignIn() throws SQLException{
		List<CommunityNews> list = communityNewsDao.getNews();
		for (CommunityNews communityNews : list) {
			System.out.println(communityNews.getContent());
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		System.out.println(date);
	}

}

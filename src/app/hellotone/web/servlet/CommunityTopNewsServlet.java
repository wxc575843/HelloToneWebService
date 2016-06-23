package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.CommunityNewsDao;
import app.hellotone.web.dao.CommunityTopNewsDao;
import app.hellotone.web.model.CommunityNews;

import com.google.gson.Gson;

public class CommunityTopNewsServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CommunityNews> list = null;
		String rs = "";
		try {
			CommunityTopNewsDao communityNewsDao = new CommunityTopNewsDao();
			list = communityNewsDao.getNews();
			Gson gson = new Gson();
			rs = gson.toJson(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(rs);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

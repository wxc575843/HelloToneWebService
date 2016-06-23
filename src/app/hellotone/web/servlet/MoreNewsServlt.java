package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.hellotone.web.dao.CommunityNewsDao;
import app.hellotone.web.model.CommunityNews;

public class MoreNewsServlt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		List<CommunityNews> list = new ArrayList<CommunityNews>();
		String rs = "";
		try {
			CommunityNewsDao communityNewsDao = new CommunityNewsDao();
			list = communityNewsDao.getMoreNews(num);
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

}

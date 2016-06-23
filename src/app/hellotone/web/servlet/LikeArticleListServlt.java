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

import app.hellotone.web.dao.FavouriteDao;
import app.hellotone.web.model.CommunityNews;

public class LikeArticleListServlt extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<CommunityNews> communityNews = new ArrayList<CommunityNews>();
		String userId = request.getParameter("userId");
		String rs = "";
		try {
			FavouriteDao likeDao = new FavouriteDao();
			communityNews = likeDao.getLikeNewsList(userId);
			Gson gson = new Gson();
			rs = gson.toJson(communityNews);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(rs);
	}

}

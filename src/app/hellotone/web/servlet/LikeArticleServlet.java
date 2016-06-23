package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.FavouriteDao;
import app.hellotone.web.dao.LikeDao;
import app.hellotone.web.model.CommunityNews;

import com.google.gson.Gson;

public class LikeArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("isLike");
		String userId = request.getParameter("userId");
		String articleId = request.getParameter("articleId");
		LikeDao likeDao;
		boolean r = false;
		try {
			likeDao = new LikeDao();
			if (status.equals("like")) {
				r = likeDao.like(articleId, userId);
			} else if (status.equals("unlike")){
				r = likeDao.unlike(articleId, userId);
			} else {
				r = likeDao.islike(articleId, userId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (r) {
			response.getWriter().write("yes");
		} else {
			response.getWriter().write("no");
		}
		
	}

}

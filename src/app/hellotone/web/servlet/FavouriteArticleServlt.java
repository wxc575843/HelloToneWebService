package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.FavouriteDao;

public class FavouriteArticleServlt extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 	String articleId = request.getParameter("id");
	 	String userId = request.getParameter("userId");
	 	String state = request.getParameter("state");
	 	System.out.println("articleId="+articleId+"\nuserId"+userId+"\n"+state);
	 	boolean rs = false;
	 	try {
	 		FavouriteDao favouriteDao = new FavouriteDao();
	 		if (state.equals("favourite")) {
	 			rs = favouriteDao.like(articleId, userId);
			} else if (state.equals("unfavourite")){
				rs = favouriteDao.unlike(articleId,userId);
			} else {
				rs = favouriteDao.isLike(articleId,userId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	if (rs) {
			response.getWriter().write("yes");
		} else {
			response.getWriter().write("no");
		}
	 
	}

	

}

package web.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.admin.dao.AdminDataDao;
import app.hellotone.web.model.Article;

public class AdminAddArticleServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Article article = new Article();
		article.setAclass(request.getParameter("aclass"));
		article.setAuthor(request.getParameter("author"));
		article.setContent(request.getParameter("content"));
		article.setPicture(request.getParameter("picture"));
		article.setTitle(request.getParameter("title"));
		String top = request.getParameter("top");
		if(top.equals("Top")){
			article.setTop("1");
		} else {
			article.setTop("0");
		}
		try {
			AdminDataDao adminDataDao = new AdminDataDao();
			adminDataDao.insertArticle(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package web.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.model.Article;
import web.admin.dao.AdminDataDao;

public class ModifyArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("gid");
		String title = request.getParameter("title");
		String aclass = request.getParameter("aclass");
		String top = request.getParameter("top");
		String content = request.getParameter("content");
		String picture = request.getParameter("picture");
		String author = URLDecoder.decode(request.getParameter("author"),"utf-8");  
		 
		Article article = new Article();
		
		System.out.println("title"+title);
		System.out.println("aclass"+aclass);
		System.out.println("top"+top);
		System.out.println("content"+content);
		System.out.println("picture"+picture);
		System.out.println("author"+author);
	
//		System.out.println("title"+title);
//		article.setId(1);
		article.setTitle(title);
		if (aclass.equals("文章")) {
			article.setAclass("article");
		} else {
			article.setAclass("post");
		}
		
		if(top.equals("是")){
			article.setTop("1");
		} else {
			article.setTop("0");;
		}
		
		article.setContent(content);
		article.setPicture(picture);
		article.setAuthor(author);
		boolean rs = false;
		try {
			AdminDataDao adminDataDao = new AdminDataDao();
			rs = adminDataDao.modifyArticle(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
	}

}

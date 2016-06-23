package web.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.admin.dao.AdminDataDao;
import app.hellotone.web.model.Article;
import app.hellotone.web.model.Record;

import com.google.gson.Gson;

public class AdminArticleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Article> records = null;
		String rs = null;
		try {
			AdminDataDao data = new AdminDataDao();
			records = data.findAllArticle();
			Gson gson = new Gson();
			rs = gson.toJson(records);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write(rs);
		
	}
}

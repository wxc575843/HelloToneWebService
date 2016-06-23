package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.CommentDao;

public class AddCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String articleId = request.getParameter("articleId");
		String content = request.getParameter("comment");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		System.out.println(date);
		boolean rs = false;
		try {
			CommentDao commentDao = new CommentDao();
			rs = commentDao.addComment(userId, articleId, content, date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs) {
			response.getWriter().write("success");
		} else {
			response.getWriter().write("fail");
		}
	}

}

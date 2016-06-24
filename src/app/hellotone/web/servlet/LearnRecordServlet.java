package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.RecordDao;

public class LearnRecordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userId");
		String recordid = request.getParameter("recordId");
		boolean rs = false;
		System.out.println("r:"+recordid);
		System.out.println("u:"+userid);
		try {
			RecordDao recordDao = new RecordDao();
			rs = recordDao.learn(userid, recordid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!rs) {
			response.getWriter().write("new");
		} else {
			response.getWriter().write("old");
		}
	}

}

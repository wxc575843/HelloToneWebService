package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.RecordDao;
import app.hellotone.web.model.Article;
import app.hellotone.web.model.Record;

import com.google.gson.Gson;

public class RecordLikeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userId");
		String recordid = request.getParameter("recordid");
		String state = request.getParameter("state");
		boolean rs = false;
		System.out.println("r:"+recordid);
		System.out.println("u:"+userid);
		System.out.println("s"+state);
		try {
			RecordDao recordDao = new RecordDao();
			if (state.equals("favourite")) {
	 			rs = recordDao.likeRecord(userid, recordid);
			} else if (state.equals("unfavourite")){
				rs = recordDao.unlike(userid,recordid);
			} else {
				rs = recordDao.isLike(userid,recordid);
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

package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.PracticeCategroyDao;
import app.hellotone.web.dao.RecordDao;
import app.hellotone.web.model.PracticeCategroy;
import app.hellotone.web.model.Record;

import com.google.gson.Gson;

public class RecordListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Record> list;
		Gson gson = new Gson();
		String string="";
		try {
			RecordDao recordDao = new RecordDao();
			list = recordDao.getRecordList();
			string = gson.toJson(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(string);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

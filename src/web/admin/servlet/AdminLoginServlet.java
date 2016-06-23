package web.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.SqlManager;
import app.hellotone.web.model.User;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("userName");
		String passwordString = request.getParameter("password");
		String sql = "select * from Admin where Aname=? and Password=?";
		User user=null;
		try {
			SqlManager sqlManager = SqlManager.createInstance();
			sqlManager.connectDB();
			Object[] params = {name,passwordString};
			ResultSet rs = sqlManager.executeQuery(sql, params);
			if(rs.next()){
				user = new User();
				user.setEmail(name);
				user.setPassword(passwordString);
			}
			sqlManager.closeDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user!=null) {
			System.out.println(user.getEmail());
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/HelloToneWebService/admin.jsp");
		} else {
			request.setAttribute("error_msg", "你输入的用户名或密码不正确,请重新输入!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}


}

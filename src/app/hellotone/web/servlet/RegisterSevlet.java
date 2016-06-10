package app.hellotone.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hellotone.web.dao.RegisterDao;

public class RegisterSevlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String nickName = request.getParameter("nickname");
			String gender = request.getParameter("gender");
			
			RegisterDao registerDao;
			boolean rs = false;
			try {
				registerDao = new RegisterDao();
				rs = registerDao.addUser(email, password, nickName, gender);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rs){
				response.getWriter().write("success");
			}else{
				response.getWriter().write("fail");
			}
			
			
	}

}

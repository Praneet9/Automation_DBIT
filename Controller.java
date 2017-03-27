package com.conrtroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("con_new"))
		{
			request.getRequestDispatcher("railway_con_new.jsp").forward(request, response);
		}
		if(action.equals("con_exist"))
		{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		if(action.equals("student_login"))
		{
			request.getRequestDispatcher("railway_com_exist.jsp").forward(request, response);
		}
		if(action.equals("admin_login"))
		{
			request.getRequestDispatcher("railway_admin.jsp").forward(request, response);
		}
		
	}

}

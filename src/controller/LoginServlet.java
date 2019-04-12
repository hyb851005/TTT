package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TblUser;
import service.TblUserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		System.out.println("ÓÃ»§Ãû£º" + username + " ÃÜÂë£º" + password);
		TblUserService uService = new TblUserService();
		if (uService.serviceLogin(username, password)) {
			System.out.println("µÇÂ¼³É¹¦£¡");
			HttpSession session = request.getSession();
			TblUser user = new TblUser();
			user.setUsername(username);
			user.setPassword(password);
			session.setAttribute("user", user);
			response.sendRedirect("success.jsp");
		} else {
			System.out.println("µÇÂ¼Ê§°Ü£¡");
			response.sendRedirect("fail.jsp");
		}
	}

}

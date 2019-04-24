package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TblCommy;
import service.TblCommyService;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		System.out.println("initServlet");
		TblCommyService tblCommyService = new TblCommyService();
		ArrayList<TblCommy> commyList = new ArrayList<TblCommy>();
		commyList = tblCommyService.serviceInit();
		if (commyList.get(0).getUserId().equals("")) {
			System.out.println("暂无数据");
			commyList = new ArrayList<TblCommy>();
			request.setAttribute("list", commyList);
		} else {
			System.out.println("初始化成功");
			// request.setAttribute("initFlag", "true");
			request.setAttribute("list", commyList);
		}
		request.getRequestDispatcher("commy.jsp").forward(request, response);
	}

}

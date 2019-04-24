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
 * Servlet implementation class QuestServlet
 */
@WebServlet("/QuestServlet")
public class QuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuestServlet() {
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
		System.out.println("questServlet");
		String cardNo = request.getParameter("cardNo").trim();
		System.out.println("查询身份证号：" + cardNo);
		TblCommyService tblCommyService = new TblCommyService();
		ArrayList<TblCommy> commyList = new ArrayList<TblCommy>();
		commyList = tblCommyService.serviceQuest(cardNo);
		if (commyList.get(0).getUserId().equals("")) {
			System.out.println("无此身份证号");
			commyList = new ArrayList<TblCommy>();
			request.setAttribute("list", commyList);
		} else {
			System.out.println("查询成功");
			request.setAttribute("list", commyList);
		}
		request.getRequestDispatcher("commy.jsp").forward(request, response);
	}

}

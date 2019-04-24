package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TblCommyService;

/**
 * Servlet implementation class CommyAddServlet
 */
@WebServlet("/CommyAddServlet")
public class CommyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommyAddServlet() {
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
		System.out.println("commyAddServlet");
		if (request.getParameter("flag").equals("newForm")) {
			response.sendRedirect("commyadd.jsp");
		} else if (request.getParameter("flag").equals("inForm")) {
			String id = request.getParameter("id").trim();
			String createUser = request.getParameter("createUser").trim();
			String userId = request.getParameter("userId").trim();
			String orgId = request.getParameter("orgId").trim();
			String name = request.getParameter("name").trim();
			String cardNo = request.getParameter("cardNo").trim();
			String phone = request.getParameter("phone").trim();
			String addr = request.getParameter("addr").trim();
			String statuss = request.getParameter("statuss").trim();
			String sexx = request.getParameter("sexx").trim();
			String birthday = request.getParameter("birthday").trim();
			String age = request.getParameter("age").trim();
			String bakk = request.getParameter("bakk").trim();
			System.out.println("录入信息为：" + id + "+" + createUser + "+" + userId + "+" + orgId + "+" + name + "+" + cardNo
					+ "+" + phone + "+" + addr + "+" + statuss + "+" + sexx + "+" + birthday + "+" + age + "+" + bakk);
			TblCommyService tblCommyService = new TblCommyService();
			int result = tblCommyService.serviceAdd(id, createUser, userId, orgId, name, cardNo, phone, addr, statuss,
					sexx, birthday, age, bakk);
			if (result == 1) {
				System.out.println("新增成功");
				request.setAttribute("msg", "新增成功");
			} else if (result == -1) {
				System.out.println("ID已存在");
				request.setAttribute("msg", "ID已存在");
			} else if (result == 0) {
				System.out.println("新增失败");
				request.setAttribute("msg", "新增失败");
			}
			request.getRequestDispatcher("commyadd.jsp").forward(request, response);
		}
	}

}

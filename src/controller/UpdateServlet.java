package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TblCommyService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		System.out.println("updateServlet");
		String cardNo = request.getParameter("cardNo").trim();
		System.out.println("修改身份证号：" + cardNo);
		if (request.getParameter("flag").equals("newForm")) {
			request.setAttribute("cardNo", cardNo);
			request.getRequestDispatcher("commyupdate.jsp").forward(request, response);
		} else if (request.getParameter("flag").equals("inForm")) {
			String userId = request.getParameter("userId").trim();
			String orgId = request.getParameter("orgId").trim();
			String name = request.getParameter("name").trim();
			String newCardNo = request.getParameter("newCardNo").trim();
			String phone = request.getParameter("phone").trim();
			String addr = request.getParameter("addr").trim();
			String statuss = request.getParameter("statuss").trim();
			String sexx = request.getParameter("sexx").trim();
			String birthday = request.getParameter("birthday").trim();
			String age = request.getParameter("age").trim();
			String bakk = request.getParameter("bakk").trim();
			System.out.println("修改信息为：" + userId + "+" + orgId + "+" + name + "+" + newCardNo + "+" + phone + "+" + addr
					+ "+" + statuss + "+" + sexx + "+" + birthday + "+" + age + "+" + bakk);
			TblCommyService tblCommyService = new TblCommyService();
			int result = tblCommyService.serviceUpdate(cardNo, userId, orgId, name, newCardNo, phone, addr, statuss,
					sexx, birthday, age, bakk);
			request.setAttribute("cardNo", cardNo);
			if (result == 1) {
				System.out.println("修改成功");
				request.setAttribute("msg", "修改成功");
			} else if (result == -1) {
				System.out.println("身份证号不存在");
				request.setAttribute("msg", "身份号不存在");
			} else if (result == 0) {
				System.out.println("修改失败");
				request.setAttribute("msg", "修改失败");
			}
			request.getRequestDispatcher("commyupdate.jsp").forward(request, response);
		}
	}

}

package Controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CreateDAO;
import utils.HashGenerator;

/**
 * Servlet implementation class createServlet
 */
@WebServlet("/create")
public class createServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public createServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String dpt_id = request.getParameter("dpt_id");
		String position_id = request.getParameter("position_id");
		String login_id = request.getParameter("login_id");
		String login_pw = request.getParameter("login_pw");
		String hashed_pw = "";
		try {
			hashed_pw = HashGenerator.generateHash(login_pw);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}

		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "MEMBER-ADD");
		}
		try {
			CreateDAO dao = new CreateDAO();
			dao.insert(name, Integer.parseInt(dpt_id), Integer.parseInt(position_id), login_id, hashed_pw);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("message", "例外発生");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);
	}

}

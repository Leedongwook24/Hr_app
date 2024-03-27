package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EditDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String dpt_id = request.getParameter("dpt_id");
		String position_id = request.getParameter("position_id");
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "MEMBER-EDIT");
		}
		try {
			EditDAO dao = new EditDAO();
			dao.update(name, Integer.parseInt(dpt_id), Integer.parseInt(position_id), Integer.parseInt(id));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("message", "例外発生");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);

	}
}

package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DeleteDAO;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String del_flag = request.getParameter("del_flag");
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "MEMBER-DELETE");
		}
		try {
			DeleteDAO dao = new DeleteDAO();
			dao.update(Integer.parseInt(id),Integer.parseInt(del_flag));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			request.setAttribute("message", "例外発生");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);

	}

}

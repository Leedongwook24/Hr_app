package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ListDAO;

/**
 * Servlet implementation class listServlet
 */
@WebServlet("/list")
public class listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {
			if(request.getAttribute("message")==null) {
				request.setAttribute("message", "MEMBER-LIST");
			}
			try {
				ListDAO dao =new ListDAO();
				request.setAttribute("rows", dao.select());
			}catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				request.setAttribute("message", "例外発生");
			}
		
		String view="WEB-INF/views/list.jsp";		
		RequestDispatcher dispatcher= request.getRequestDispatcher(view);
 	   	dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {
		if(request.getAttribute("message")==null) {
			request.setAttribute("message", "MEMBER-LIST");
		}
		try {
			ListDAO dao =new ListDAO();
			request.setAttribute("rows", dao.select());
		}catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			request.setAttribute("message", "例外発生");
		}
	String view="WEB-INF/views/list.jsp";		
	RequestDispatcher dispatcher= request.getRequestDispatcher(view);
	   	dispatcher.forward(request,response);
	}

}

package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class moveServlet
 */
@WebServlet("/move")
public class moveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public moveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String goal=request.getParameter("goal");
		String view="";
		if(goal.equals("create")) {
			view="WEB-INF/views/create.jsp";		
		} else if(goal.equals("edit")) {
			String name=request.getParameter("name");
			String id=request.getParameter("id");
			String dpt_id=request.getParameter("dpt_id");
			String position_id=request.getParameter("position_id");
			request.setAttribute("name", name);
			request.setAttribute("id", id);
			request.setAttribute("dpt_id", dpt_id);
			request.setAttribute("position_id", position_id);
			view="WEB-INF/views/edit.jsp";
		} else{
			RequestDispatcher dispatcher= request.getRequestDispatcher("/list");
		   	dispatcher.forward(request,response);							
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher(view);
	   	dispatcher.forward(request,response);							
	}

}

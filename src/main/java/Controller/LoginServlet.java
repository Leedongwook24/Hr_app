package Controller;
	
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.HashGenerator;

@WebServlet("/home")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String view = "/WEB-INF/views/home.jsp";
        req.getRequestDispatcher(view).forward(req, res);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url  = "jdbc:mysql://localhost:3306/employee_db";
        String user = "root";
        String password= "password";
        String login_id = request.getParameter("login_id");
        String login_pw = request.getParameter("login_pw");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String hashedPassword = HashGenerator.generateHash(login_pw);
            String sql = "SELECT * FROM members WHERE login_id=? AND login_pw=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, login_id);
                stmt.setString(2, hashedPassword);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int rank = rs.getInt("position_id");
                    HttpSession session=request.getSession();
                    session.setAttribute("user_id", id);
                    session.setAttribute("user_name", name);
                    session.setAttribute("user_rank", rank);
                    response.sendRedirect("list");
                    return; // 로그인에 성공했으므로 더 이상 진행할 필요가 없음
                } else {
                    String view = "WEB-INF/views/home.jsp";
                    request.setAttribute("Message", "ログイン失敗");
                    request.getRequestDispatcher(view).forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database connection Failed", e);
        } catch (NoSuchAlgorithmException e) {
            throw new ServletException("Generate hash Failed", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException("MySQL JDBC Driver not found", e);
        }

        // 로그인에 실패했을 경우에만 아래 코드가 실행됨
        String view = "WEB-INF/views/home.jsp";
        request.setAttribute("Message", "ログイン失敗:ID/PWを確認してください。");
        request.getRequestDispatcher(view).forward(request, response);
    }
}
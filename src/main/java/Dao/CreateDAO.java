package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreateDAO {
    String url = "jdbc:mysql://localhost:3306/employee_db";
    String user = "root";
    String password = "password";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    
    public void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, user, password);
    }
    
    public void insert(String name, int dpt_id, int position_id, String login_id, String login_pw) throws Exception {
        try {
            connect();
            String sql = "INSERT INTO members (name, dpt_id, position_id, login_id, login_pw) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, dpt_id);
            statement.setInt(3, position_id);
            statement.setString(4, login_id);
            statement.setString(5, login_pw);
            statement.executeUpdate();
        } finally {
            closeResources();
        }
    }
    
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
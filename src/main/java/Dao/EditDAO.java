package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditDAO {
    String url = "jdbc:mysql://localhost:3306/employee_db";
    String user = "root";
    String password = "password";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    
    public void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load JDBC driver", e);
        }
    }

    public void disconnect() throws SQLException {
        try {
            if (statement != null) {
                statement.close();
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void update(String name, int dpt_id, int position_id, int id) throws SQLException {
        try {
            connect();
            String sql = "UPDATE members SET name=?, dpt_id=?, position_id=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, dpt_id);
            statement.setInt(3, position_id);
            statement.setInt(4, id);
            statement.executeUpdate();
        } finally {
            disconnect();
        }
    }
}
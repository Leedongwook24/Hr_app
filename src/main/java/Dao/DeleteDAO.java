package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteDAO {
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

    public void update(int id, int del_flag) throws SQLException {
        try {
            connect();
            String sql = "UPDATE members SET del_flag=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, del_flag);
            statement.setInt(2, id);
            statement.executeUpdate();
        } finally {
            disconnect();
        }
    }
}

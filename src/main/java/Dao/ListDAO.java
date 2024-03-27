package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class ListDAO {

	String url  = "jdbc:mysql://localhost:3306/employee_db";
	String user = "root";
	String password= "password";
	Connection conection=null;
	
	public void conect() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		conection = DriverManager.getConnection(url,user,password);
	}
	public ArrayList<HashMap<String,String>> select() throws Exception{
	PreparedStatement statement =null;
	ResultSet rs = null;
	String sql="select m.id, m.name, d.dpt_name, p.position_name, m.dpt_id, m.position_id from members m\n"
			+ "inner join positions p on m.position_id =p.position_id \n"
			+ "inner join departments d on m.dpt_id = d.dpt_id where del_flag = 0";
	ArrayList<HashMap<String, String>> rows= new
	ArrayList<HashMap<String, String>>();
	conect();
	statement=conection.prepareStatement(sql);
	rs=statement.executeQuery();
	while(rs.next()) {
		HashMap<String, String> columns = new HashMap<String,String>();
		String id=rs.getString("m.id");
		columns.put("id", id);
		String name=rs.getString("m.name");
		columns.put("name", name);
		String department=rs.getString("d.dpt_name");
		columns.put("department", department);
		String position=rs.getString("p.position_name");
		columns.put("position", position);
		String dpt_id=rs.getString("m.dpt_id");
		columns.put("dpt_id",dpt_id);
		String position_id=rs.getString("m.position_id");
		columns.put("position_id",position_id);
		rows.add(columns);
		}
	return rows;
	}
}

package test;

import java.sql.*;

public class JDBCConnection {
	
	public static void main(String[] args)
	{
		String name = jdbccall(1055);
	}
	public static String jdbccall(int id) {
		String name="";
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("before connection");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "sarasu10");

			PreparedStatement pst = con.prepareStatement("SELECT * FROM EMP WHERE ID = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.getInt("id");
			name = rs.getString("Name");
		} catch (Exception e) {
			// 
			e.printStackTrace();
		}
		return name;
	}

}

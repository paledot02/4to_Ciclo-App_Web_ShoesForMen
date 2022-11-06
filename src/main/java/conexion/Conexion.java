package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static String url = "jdbc:mysql://localhost:3306/shoesformen";
	private static String user = "root";
	private static String pass = "12345";
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	Connection conn = null;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Error de Driver: " + e.getMessage());
		}
	}
	
	public Connection getConn() {
		try {
			conn = DriverManager.getConnection(url,user,pass);
		} catch (SQLException e) {
			System.out.println("Error de conexion: " + e.getMessage());
		}
		
		return conn;
	}
	
}

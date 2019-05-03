package dao;

import java.sql.*;

public class ConexionJDBCFactory {
	
	public static Connection getConexion() throws SQLException,ClassNotFoundException{
	Class.forName("com.mysql.jdbc.Driver");
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","admin");
	}
}

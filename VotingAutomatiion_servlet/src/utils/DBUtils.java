package utils;

import java.sql.*;

//import com.mysql.jdbc.Connection;

public class DBUtils{
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/world";
		//loading the database driver class
		Class.forName("com.mysql.jdbc.Driver");
		//fetching connection from the database
		return DriverManager.getConnection(url,"root","Identifyme09");
		
	}
}
package exercise.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnector {
	
	private DBconnector() {}
	
	private static String url = "jdbc:mysql://localhost:3306/jdbcapi";
	private static String user = "root";
	private static String password = "root@mysql";
	
	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, password);

	}
	
}

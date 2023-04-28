import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private DBConnector() {}
	
	private static String url = "jdbc:mysql://localhost:3306/exercise";
	private static String user = "root";
	private static String password = "password";
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException{

		connection = DriverManager.getConnection(url, user, password);
		return connection;
		
	}
	
}

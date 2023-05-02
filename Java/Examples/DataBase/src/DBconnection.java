import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {

	public static void main(String[] args) {

		Connection connection = null;

		try {

			String url = "jdbc:mysql://localhost:3306/exercise";
			String user = "root";
			String password = "root@mysql";

			connection = DriverManager.getConnection(url, user, password);
			
			System.out.println(String.format("Connected to database %s ", connection.getCatalog()));
			
			
			Statement stmt  = connection.createStatement();
			
			String sql = "SELECT sid , name "
						+ "FROM StudentDetails ";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("sid")+ "\t" + rs.getString("name"));
			}
			

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}

	}

}

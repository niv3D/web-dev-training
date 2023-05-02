import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Main {

	public static void main(String[] args) {

		String sql = "INSERT INTO EnrolledSubjects (sid,sub1,sub2,sub3,sub4) VALUES(?,?,?,?,?)";
		ResultSet rs = null;
		try (
				Connection connection = DBConnector.getConnection(); 
				PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		){
			
			statement.setInt(1, 3);
			statement.setString(2,"BIO2");
			statement.setNull(3, Types.NULL);
			statement.setNull(4, Types.NULL);
			statement.setNull(5, Types.NULL);
			
			int rowAffected = statement.executeUpdate();
			
			if (rowAffected > 0) {
				
				rs = statement.getGeneratedKeys();
				
				while(rs.next()) {
					System.out.println(rs.getInt(1));
				}
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				e2.getMessage();
			}
		}

	}

}

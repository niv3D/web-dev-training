package exercise.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBdelete {

	private DBdelete() {
	}

	private static String deleteString = "DELETE FROM StudentDetails WHERE sid = ?";

	public static int studentDetails(int sid) {
		int rowAffected = 0;

		try (Connection connection = DBconnector.getConnection();
				PreparedStatement statement = connection.prepareStatement(deleteString);) {

			statement.setInt(1, sid);
			rowAffected = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("unable to delete values ! ");
		}

		if (rowAffected == 1) {

			System.out.println("student with id - " + sid + " deleted successfully");

		}

		return rowAffected;
	}

}

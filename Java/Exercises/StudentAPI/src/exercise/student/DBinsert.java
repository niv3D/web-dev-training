package exercise.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBinsert {

	private DBinsert() {
	}

	private static String insertInto = "INSERT INTO StudentDetails " + "(sid,name,email,address,dob,year_of_admission) "
			+ "VALUES (?,?,?,?,?,?)";

	public static int studentDetails(Student student) {

		int rowAffected = 0;

		try (Connection connection = DBconnector.getConnection();
				PreparedStatement statement = connection.prepareStatement(insertInto);) {

			statement.setInt(1, student.sid);
			statement.setString(2, student.name);
			statement.setString(3, student.email);
			statement.setString(4, student.address);
			statement.setDate(5, student.dob);
			statement.setInt(6, student.yearOfAdmission);

			rowAffected = statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("unable to insert values ! ");
		}

		if (rowAffected == 1) {
			System.out.println("student with id - " + student.sid + " added successfully");
		}

		return rowAffected;
	}

}

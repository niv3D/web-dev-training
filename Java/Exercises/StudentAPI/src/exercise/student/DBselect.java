package exercise.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBselect {

	private DBselect() {
	}

	private static String selectString = "SELECT sid, name, email, address, dob, year_of_admission FROM StudentDetails";

	public static Student studentDetails(int sid) {

		String sidString = selectString + " WHERE sid = " + sid;
		Student student = null;

		try (Connection connection = DBconnector.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sidString);) {

			if (resultSet.next()) {

				student = new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return student;
	}

	public static List<Student> allStudentDetails() {

		List<Student> students = new ArrayList<>();

		try (Connection connection = DBconnector.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(selectString)) {

			while (resultSet.next()) {

				students.add(new Student(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getDate(5), resultSet.getInt(6)));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return students;

	}
}

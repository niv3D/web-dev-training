package exercise.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBupdate {
	private DBupdate() {
	}
	
	private static String updateString = "UPDATE StudentDetails SET " + 
										 "name = ?, " + "email = ?, " + "address = ?, " + "dob = ?, " + "year_of_admission = ? " +
										 "WHERE sid = ?";
	
	public static int studentDetails(Student student) {
		int rowAffected = 0;
		
		try(
				Connection connection = DBconnector.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateString);
		) {
			
			statement.setString(1, student.name);
			statement.setString(2, student.email);
			statement.setString(3, student.address);
			statement.setDate(4, student.dob);
			statement.setInt(5, student.yearOfAdmission);
			statement.setInt(6, student.sid);
			
			rowAffected = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.getMessage();
			System.out.println("unable to update values ! ");
		}
		
		if (rowAffected == 1) {
			System.out.println("student with id - " + student.sid + " updated successfully");
		}
		
		return rowAffected;
	}
	
	
	
}

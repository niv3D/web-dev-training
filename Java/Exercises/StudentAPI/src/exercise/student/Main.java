package exercise.student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

	private static void printStudent(Student student) {

		System.out.format("%4d | %-20s| %-20s| %-20s| %10s | %4d |%n", student.sid, student.name, student.email,
				student.address, student.dob, student.yearOfAdmission);

	}

	public static void main(String[] args) {

//		Student newStudent = new Student(3, "nived", "nived@gmail.com", "nived address", Date.valueOf("2000-03-11"),
//				2019);
//
//		DBinsert.studentDetails(newStudent);
//
//		Student student = DBselect.studentDetails(3);
//
//		printStudent(student);
//
//		List<Student> students = DBselect.allStudentDetails();
//
//		for (Student st : students) {
//			printStudent(st);
//		}
//
//		student.email = "mmmmmmmm";
//
//		DBupdate.studentDetails(student);
//
//		student = DBselect.studentDetails(3);
//
//		printStudent(student);
//
//		DBdelete.studentDetails(3);
//		
//		String sqlString = "{CALL get_name(?)}";
//		
//		ResultSet resultSet = null;
//		
//		try(	
//				Connection connection = DBconnector.getConnection();
//				CallableStatement statement = connection.prepareCall(sqlString);
//		) {
//			
//			statement.setInt(1, 2);
//			
//			resultSet =  statement.executeQuery();
//			
//			if(resultSet.next()) {
//				System.out.println(resultSet.getString(1));
//			}
//			
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		finally {
//			if(resultSet != null) {
//				try {
//					resultSet.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		
		String sql = "SELECT sid, address FROM StudentDetails";
		
		try (
				Connection connection = DBconnector.getConnection();
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rSet = statement.executeQuery(sql);
			){
				
				rSet.absolute(1);
				rSet.updateString(2, "new address");
				rSet.updateRow();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}

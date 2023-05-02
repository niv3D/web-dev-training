package exercise.student;

import java.util.List;

public class Main {

	private static void printStudent(Student student) {
		
		System.out.println(
				student.sid + " | " +
				student.name + " | " +
				student.email + " | " +
				student.address + " | " +
				student.dob + " | " +
				student.yearOfAdmission + " | "
		);
		
	}
	
	
	public static void main(String[] args) {
		
//		Student student = DBselect.studentDetails(2);
//		
//		printStudent(student);
		
		List<Student> students = DBselect.allStudentDetails();
		
		for (Student st : students) {
			printStudent(st);
		}

	}

}

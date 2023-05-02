package exercise.student;

import java.sql.Date;

public class Student {

	public Student(int sid, String name, String email, String address, Date dob, int yearOfAdmission) {
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.yearOfAdmission = yearOfAdmission;
	}

	int sid;
	String name;
	String email;
	String address;
	Date dob;
	int yearOfAdmission;
}
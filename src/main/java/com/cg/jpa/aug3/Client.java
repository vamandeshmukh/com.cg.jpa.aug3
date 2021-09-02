package com.cg.jpa.aug3;

import com.cg.jpa.aug3.entities.Student;
import com.cg.jpa.aug3.service.StudentService;
import com.cg.jpa.aug3.service.StudentServiceImpl;

public class Client {

	public static void main(String[] args) {

		System.out.println("Start...");

		// Debug this program as Debug -> Debug as Java Application

		StudentService service = new StudentServiceImpl();

		Student student = new Student();
		student.setStudentId(100);
		student.setName("Sachin");
		service.addStudent(student);

		// at this breakpoint, we have added one record to table
		student = service.findStudentById(100);
		System.out.println(student.toString());

		student.setName("Sachin Tendulkar");
		service.updateStudent(student);

		// at this breakpoint, we have updated record added in first section
		student = service.findStudentById(100);
		System.out.println(student.toString());

		// at this breakpoint, record is removed from table
//		service.removeStudent(student);
		System.out.println("End of program...");

	}
}

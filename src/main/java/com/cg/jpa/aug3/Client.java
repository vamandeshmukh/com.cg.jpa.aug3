package com.cg.jpa.aug3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.jpa.aug3.dao.JPAUtil;
import com.cg.jpa.aug3.dao.StudentDao;
import com.cg.jpa.aug3.dao.StudentDaoImpl;
import com.cg.jpa.aug3.entities.Student;
import com.cg.jpa.aug3.service.StudentService;
import com.cg.jpa.aug3.service.StudentServiceImpl;

public class Client {

	public static void main(String[] args) {

		System.out.println("Start...");

		// Debug this program as Debug -> Debug as Java Application

//		StudentService service = new StudentServiceImpl();

		EntityManager entityManager = JPAUtil.getEntityManager();

		String selectAllStudents = "SELECT s FROM Student s";
		TypedQuery<Student> query = entityManager.createQuery(selectAllStudents, Student.class);
		List<Student> studentsList = query.getResultList();

		System.out.println("Get all the students - ");
		for (Student s : studentsList)
			System.out.println(s.toString());

		String selectOneStudent = "SELECT s FROM Student s WHERE s.name = 'Monu'";
		TypedQuery<Student> query2 = entityManager.createQuery(selectOneStudent, Student.class);
		Student st = query2.getSingleResult();

		System.out.println("Get a specific student based on name- ");
		System.out.println(st.toString());
		System.out.println(st.getName());

//		Student student = new Student();
//		student.setStudentId(100);
//		student.setName("Sachin");
//		service.addStudent(student);
//
//		// at this breakpoint, we have added one record to table
//		student = service.findStudentById(100);
//		System.out.println(student.toString());
//
//		student.setName("Sachin Tendulkar");
//		service.updateStudent(student);
//
//		// at this breakpoint, we have updated record added in first section
//		student = service.findStudentById(100);
//		System.out.println(student.toString());
//
//		// at this breakpoint, record is removed from table
//		service.removeStudent(student);
//		System.out.println("End of program...");

	}
}

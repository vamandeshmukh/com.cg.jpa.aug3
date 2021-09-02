package com.cg.jpa.aug3.dao;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.cg.jpa.aug3.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	public StudentDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Student getStudentById(int id) {
		Student student = entityManager.find(Student.class, id);
		System.out.println("getStudentById in StudentDaoImpl");
		return student;
	}

	@Override
	public void addStudent(Student student) throws EntityExistsException {
		entityManager.persist(student);
		// entityManager.
		// CRUD - insert - persist(), select - find(), update - merge(), delete - remove() 
		// select * from students where first_name = "Sachin";
		
	}

	@Override
	public void removeStudent(Student student) {
		entityManager.remove(student);
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

}

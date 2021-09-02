package com.cg.jpa.aug3.service;

import javax.persistence.EntityExistsException;

import com.cg.jpa.aug3.dao.StudentDao;
import com.cg.jpa.aug3.dao.StudentDaoImpl;
import com.cg.jpa.aug3.entities.Student;

public class StudentServiceImpl implements StudentService {

	private StudentDao dao;

	public StudentServiceImpl() {
		dao = new StudentDaoImpl();
	}

	@Override
	public void addStudent(Student student) {
		dao.beginTransaction();
		try {
			dao.addStudent(student);
			dao.commitTransaction();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	public void updateStudent(Student student) {
		dao.beginTransaction();
		dao.updateStudent(student);
		dao.commitTransaction();
	}

	@Override
	public void removeStudent(Student student) {
		dao.beginTransaction();
		dao.removeStudent(student);
		dao.commitTransaction();
	}

	@Override
	public Student findStudentById(int id) {
		Student student;
		student = dao.getStudentById(id);
		System.out.println("findStudentById in StudentServiceImpl");
		return student;
	}
}

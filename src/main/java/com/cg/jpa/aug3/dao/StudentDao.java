package com.cg.jpa.aug3.dao;

import javax.persistence.EntityExistsException;

import com.cg.jpa.aug3.entities.Student;

public interface StudentDao {

	public abstract Student getStudentById(int id);

	public abstract void addStudent(Student student) throws EntityExistsException;

	public abstract void removeStudent(Student student);

	public abstract void updateStudent(Student student);

	public abstract void commitTransaction();

	public abstract void beginTransaction();

}
package com.cg.jpa.aug3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpa.aug3.entities.Address;
import com.cg.jpa.aug3.entities.Student;

/**
 * Please run the below DDL query before you execute this application.
 * 
 * CREATE TABLE address (address_id INT PRIMARY KEY, address_street VARCHAR(30),
 * address_city VARCHAR(30), address_state VARCHAR(20), address_zipcode
 * VARCHAR(6));
 * 
 * DROP TABLE students;
 * 
 * CREATE TABLE students (studentId INT PRIMARY KEY, name VARCHAR(30),
 * address_id INT REFERENCES address(address_id));
 * 
 */

public class Client2 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("abcd");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student();
		student.setName("Sonu");
		Address homeAddress = new Address();
		homeAddress.setStreet("ECIL Road");
		homeAddress.setCity("Hyderabad");
		homeAddress.setState("TS");
		homeAddress.setZipCode("500002");

		System.out.println("inject address into student");
		student.setAddress(homeAddress);

		System.out.println("persist only student, no need to persist Address explicitly");
		em.persist(student);
		em.getTransaction().commit();

		System.out.println("Added one student with address to database.");
		em.close();
		factory.close();
	}
}

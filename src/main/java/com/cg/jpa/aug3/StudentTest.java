package com.cg.jpa.aug3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentTest {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("abcd");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Student student = new Student();
		student.setName("Sonu");

		em.persist(student); // insert a new record 

		em.getTransaction().commit();

		System.out.println("Added one student to database.");

		em.close();
		factory.close();

	}
}

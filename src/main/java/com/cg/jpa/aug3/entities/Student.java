package com.cg.jpa.aug3.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id") // create table students (sid INT, sname varchar(10), address varchar(255)
										// references address(address_id));
	private Address address;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

//@Entity
//@Table(name = "students")
//public class Student implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	private int studentId;
//	private String name;
//
//	public int getStudentId() {
//		return studentId;
//	}
//
//	public void setStudentId(int studentId) {
//		this.studentId = studentId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	@Override
//	public String toString() {
//		return "Student [studentId=" + studentId + ", name=" + name + "]";
//	}
//
//}

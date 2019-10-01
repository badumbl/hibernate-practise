package com.luv2code.hibernate.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
public int id;

@Column(name="first_name")
public String firstName;

@Column(name="last_name")
public String lastName;

@Column(name="company")
public String company;

public Employee() {
	
}

public Employee(String firstName, String lastName, String company) {		
	this.firstName = firstName;
	this.lastName = lastName;
	this.company = company;
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + "]";
}


}

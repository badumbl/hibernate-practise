package com.luv2code.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class GetEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			List<Employee> list = session.createQuery("from Employee").getResultList();
			System.out.println("\nPrinting all employees form the table:");
			printList(list);

			list = session.createQuery("from Employee e where e.lastName = 'Jameson'").getResultList();
			System.out.println("\nPrinting employees who have last name of Jameson:");
			printList(list);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	public static void printList(List<Employee> list) {
		for (Employee e : list) {
			System.out.println(e);
		}
		if (list.isEmpty()) {
			System.out.println("Not found");
		}

	}
}

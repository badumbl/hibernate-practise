package com.luv2code.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class QueryEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Employee theEmployee4 = new Employee("Jame", "Jameson", "Jameland");

			session.beginTransaction();

			session.save(theEmployee4);

			Employee check = session.get(Employee.class, theEmployee4.getId());
			System.out.println(check);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}

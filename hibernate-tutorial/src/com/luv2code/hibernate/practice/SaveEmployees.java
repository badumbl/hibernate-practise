package com.luv2code.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class SaveEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Employee theEmployee1 = new Employee("Vitja", "Vitjunov", "Kompaha1");
			Employee theEmployee2 = new Employee("Petja", "Petjunov", "Kompaha2");
			Employee theEmployee3 = new Employee("Katja", "Katjunova", "Kompaha3");

			session.beginTransaction();

			session.save(theEmployee1);
			session.save(theEmployee2);
			session.save(theEmployee3);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}

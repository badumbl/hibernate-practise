package com.luv2code.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class UpdateEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			session.createQuery("update Employee s set company='HomeOffice' where id=3").executeUpdate();

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

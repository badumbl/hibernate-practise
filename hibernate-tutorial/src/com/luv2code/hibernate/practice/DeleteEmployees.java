package com.luv2code.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fasterxml.classmate.AnnotationConfiguration;

public class DeleteEmployees {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			int id = 1;
			session.beginTransaction();

			Employee theEmployee = session.get(Employee.class, id);
			session.delete(theEmployee);

			session.createQuery("delete from Employee where id='4'").executeUpdate();

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

package com.shivam.Hibernate_JDBC;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shivam.Hibernate_JDBC.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Create SessionFactory
        SessionFactory factory = new Configuration()
        						.configure("hibernate_cfg.xml")
        						.addAnnotatedClass(Student.class)
        						.buildSessionFactory();
        //Create a session
        Session session = factory.getCurrentSession();
        
        try {
        	session.beginTransaction();
        	
        	List<Student> students = session.createQuery("from Student").list();
        	for(int i=0;i<students.size();i++) {
        		System.out.println(students.get(i));
        	}
        	session.getTransaction().commit();
        	System.out.println("Transaction completed");
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
    }
}

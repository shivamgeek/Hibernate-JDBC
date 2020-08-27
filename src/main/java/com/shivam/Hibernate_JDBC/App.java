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
        	System.out.println("Begin Transaction");
        	session.beginTransaction();
        	
        	//Get student with ID 2
        	
        	Student temp = session.get(Student.class, 2);
        	temp.setEmail("fooBar@foba.com");
        	
        	session.createQuery("update Student set email='*@avengers.com' where lastName='man'").executeUpdate();
        	
        	System.out.println("Do commit the transaction");
        	session.getTransaction().commit();
        	System.out.println("Transaction completed");
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
    }

	private static void displayStudents(List<Student> students) {
		System.out.println("Displaying Data +++++");
		for(int i=0;i<students.size();i++) {
			System.out.println(students.get(i));
		}
		System.out.println("Finish Data ----");
	}
    
    
}

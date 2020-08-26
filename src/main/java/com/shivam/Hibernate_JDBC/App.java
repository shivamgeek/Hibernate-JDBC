package com.shivam.Hibernate_JDBC;

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
        	System.out.println("Create a new Student object");
        	Student s = new Student("Shivam", "Aggarwal","shivam@gmail.com");
        	System.out.println("Begin the transaction");
        	session.beginTransaction();
        	System.out.println("Save the Object to DB");
        	session.save(s);
        	System.out.println("Commit the changes");
        	session.getTransaction().commit();
        	System.out.println("Done saving to DB");
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
    }
}

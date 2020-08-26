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
        	Student s = new Student("John", "Wick","John@wick.com");
        	System.out.println("Begin the transaction");
        	session.beginTransaction();
        	System.out.println("Save the Object to DB");
        	session.save(s);
        	System.out.println("Commit the changes");
        	session.getTransaction().commit();
        	System.out.println("Done saving to DB");
        	
        	System.out.println("Object saved to DB with primary key "+s.getId());
        	
        	//Get the data from DB using ID
        	
        	session = factory.getCurrentSession();
        	session.beginTransaction();
        	
        	System.out.println("Trying to get Student with ID "+s.getId());
        	Student tempStud = session.get(Student.class, s.getId());
        	System.out.println("Info from DB, Student - "+tempStud.getFirstName()+" "+tempStud.getLastName());
        	session.getTransaction().commit();
        	System.out.println("Completed");
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        
    }
}

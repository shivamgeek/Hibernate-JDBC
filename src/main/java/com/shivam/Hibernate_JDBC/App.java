package com.shivam.Hibernate_JDBC;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shivam.Hibernate_JDBC.Entity.Instructor;
import com.shivam.Hibernate_JDBC.Entity.InstructorDetail;
import com.shivam.Hibernate_JDBC.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        SessionFactory factory = new Configuration()
        						.configure("hibernate_cfg.xml")
        						.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
        						.buildSessionFactory();
        Session session = factory.getCurrentSession();
        
        try {
        	createAndSaveInstructor(session);
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
    
    static void createAndSaveInstructor(Session session) {
    	Instructor instructor = new Instructor("Iron","man","ironman@hotmail.com");
    	
    	InstructorDetail idetail = new InstructorDetail("youtube.com/maniron","creating, building stuff");
    	
    	instructor.setDetail(idetail);
    	
    	session.beginTransaction();
    	
    	session.save(instructor); //this should save idetail object as well due CASCADING.ALL
    	
    	session.getTransaction().commit();
    	
    	System.out.println("Transaction committed");
    }

    
    
}

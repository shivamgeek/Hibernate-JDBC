package com.shivam.Hibernate_JDBC;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shivam.Hibernate_JDBC.Entity.Course;
import com.shivam.Hibernate_JDBC.Entity.Instructor;
import com.shivam.Hibernate_JDBC.Entity.InstructorDetail;
import com.shivam.Hibernate_JDBC.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	static SessionFactory factory = null;
    public static void main( String[] args )
    {

        factory = new Configuration()
        						.configure("hibernate_cfg.xml")
        						.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
        						.buildSessionFactory();
        //Session session = factory.getCurrentSession();
        
        try {
        	int id = 25;
        	Session session = factory.getCurrentSession();
        	session.beginTransaction();
        	Instructor inst = session.get(Instructor.class, id);
        	
        	System.out.println(inst);
        	System.out.println("$$$$$$$$");
        	System.out.println(inst.getDetail());
        	session.getTransaction().commit();
        	session.close();
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	factory.close();
        }
        
    }
    
    static void deleteInstructor(Instructor inst) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	session.delete(inst);
    	session.getTransaction().commit();
    	System.out.println("Transaction committed");
    }
    
    static void deleteInstructorDetail(InstructorDetail det) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	session.delete(det);
    	session.getTransaction().commit();
    	System.out.println("Transaction committed");
    }
    
    static Instructor getInstructorWithId(int id) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Instructor inst = session.get(Instructor.class, id);
    	session.getTransaction().commit();
    	return inst;
    }
    
    static InstructorDetail getInstructorDetailWithId(int id) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	InstructorDetail det = session.get(InstructorDetail.class, id);
    	session.getTransaction().commit();
    	return det;
    }
    
    static int createAndSaveInstructor() {
    	Session session = factory.getCurrentSession();
    	Instructor instructor = new Instructor("Shivam","Aggarwal","shivam@hotmail.com");
    	InstructorDetail idetail = new InstructorDetail("youtube.com/shiva","creating, fixing stuff");
    	instructor.setDetail(idetail);
    	session.beginTransaction();
    	session.save(instructor); //this should save idetail object as well due CASCADING.ALL
    	session.getTransaction().commit();
    	System.out.println("Transaction committed");
    	return instructor.getId();
    }

    static void addCoursesToInstructor(int inst_id) {
    	Instructor inst = getInstructorWithId(inst_id);
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Course c1 = new Course("Engineering4");
    	Course c2 = new Course("Physics0");
    	inst.addCourse(c1);
    	inst.addCourse(c2);
    	session.save(c1);
    	session.save(c2);
    	session.getTransaction().commit();
    	System.out.println("Transaction committed");
    }
    
    
}

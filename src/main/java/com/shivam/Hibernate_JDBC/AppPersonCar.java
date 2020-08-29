package com.shivam.Hibernate_JDBC;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.shivam.Hibernate_JDBC.Entity.Car;

import com.shivam.Hibernate_JDBC.Entity.Person;

public class AppPersonCar {
	
	static SessionFactory factory = null;
	
    public static void main( String[] args )
    {

        factory = new Configuration()
        						.configure("hibernate_cfg.xml")
        						.addAnnotatedClass(Person.class).addAnnotatedClass(Car.class)
        						.buildSessionFactory();
        
        try {
 
        	
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	factory.close();
        }

	}
    
    static Car getCarWithId(int id) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Car c = session.get(Car.class, id);
    	session.getTransaction().commit();
    	return c;
    }
    
    static int saveCar(String brand) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Car c = new Car(brand);
    	session.save(c);
    	session.getTransaction().commit();
    	System.out.println("Car saved "+brand );
    	return c.getId();
    }
    
    static Person getPersonWithId(int id) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Person p = session.get(Person.class, id);
    	session.getTransaction().commit();
    	return p;
    }
    
    static int savePerson(String name) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Person p = new Person(name);
    	session.save(p);
    	session.getTransaction().commit();
    	System.out.println("Person saved "+name);
    	return p.getId();
    }
    
    static void deleteCar(int id) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Car c = getCarWithId(id);
    	session.delete(c);
    	session.getTransaction().commit();
    	System.out.println("Car deleted with ID "+id);
    }
    
    static void deletePerson(int id) {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	Person p = getPersonWithId(id);
    	session.delete(p);
    	session.getTransaction().commit();
    	System.out.println("Person deleted with ID "+id);
    }

}

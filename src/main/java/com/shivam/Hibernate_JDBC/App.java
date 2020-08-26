package com.shivam.Hibernate_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String jdbcUrl = "jdbc:mysql://localhost:3306/student_database";
        String user = "root", password = "root";
        
        try {
        	System.out.println("Trying to connect to mysql database");
        	Connection c = DriverManager.getConnection(jdbcUrl,user,password);
        	System.out.println("Connection Successful -> "+c);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }
}

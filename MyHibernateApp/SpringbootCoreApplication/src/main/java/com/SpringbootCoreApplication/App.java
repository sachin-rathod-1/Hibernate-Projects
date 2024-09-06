package com.SpringbootCoreApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        @SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringbootCoreApplication/config.xml");
        
        Student student= (Student) context.getBean("stud1");
        System.out.println("Student Id: "+student.getStudID());
        System.out.println("Student Name: "+student.getStudName());
        System.out.println("Student Adress: "+student.getStudAddress());
        System.out.println(student);
        
        Emp emp=(Emp) context.getBean("emp1");
        System.out.println("Employee ID: "+emp.getId());
        System.out.println("Employee Name: "+emp.getName());
    }
}

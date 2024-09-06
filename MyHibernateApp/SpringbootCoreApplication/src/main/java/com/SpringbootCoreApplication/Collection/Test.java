package com.SpringbootCoreApplication.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringbootCoreApplication/Collection/Collectionconfig.xml");
		
		Emp e=(Emp) context.getBean("emp1");
		
		System.out.println("Employee Name: "+e.getEmpName());
		System.out.println("Employee Address: "+e.getAddress());
		System.out.println("Employee Contact: "+e.getPhones());
		System.out.println("Employee Cources: "+e.getCources());
		System.out.println(e);
	}
}

package com.SpringbootCoreApplication.Autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringbootCoreApplication/Autowire/Autowireconfig.xml");
		
		Emp e= context.getBean("emp1",Emp.class);
		System.out.println(e);
	}

}

package com.SpringbootCoreApplication.Constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context=new ClassPathXmlApplicationContext("com/SpringbootCoreApplication/Constructor/Constconfig.xml");
		Stud stud= (Stud) context.getBean("stud1");
		System.out.println(stud);
		
		Addition add=(Addition) context.getBean("add1");
		add.dosum();
	}

}

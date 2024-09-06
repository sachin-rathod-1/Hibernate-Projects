package com.SpringbootCoreApplication.Lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext context=new ClassPathXmlApplicationContext("com/SpringbootCoreApplication/Lifecycle/Lifecycleconfig.xml");
		
		Pepsi p= (Pepsi) context.getBean("p1");
		System.out.println(p);
		
		Example e= (Example) context.getBean("ex");
		System.out.println(e);
		context.registerShutdownHook();
		
	}

}

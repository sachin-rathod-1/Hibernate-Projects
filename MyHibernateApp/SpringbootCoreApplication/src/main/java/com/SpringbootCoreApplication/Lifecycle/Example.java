package com.SpringbootCoreApplication.Lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {

	private String subject;
	
	public Example() {
		
	}

	public Example(String subject) {
		super();
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Example [subject=" + subject + "]";
	}
	
	@PostConstruct
	private void start() {
		System.out.println("Starting Method");
	}
	
	@PreDestroy
	public void end()
	{
	System.out.println("ending method");	
	}
}

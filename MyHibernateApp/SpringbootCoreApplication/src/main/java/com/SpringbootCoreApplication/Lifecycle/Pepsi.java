package com.SpringbootCoreApplication.Lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pepsi implements InitializingBean, DisposableBean {

	private double price;
	
	public Pepsi() {
		
	}
	
	public Pepsi(double price) {
		super();
		this.price = price;
	}

	
	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Pepsi [price=" + price + "]";
	}

	
}

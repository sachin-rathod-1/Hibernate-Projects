package com.SpringbootCoreApplication.Lifecycle;

public class Samosa {

	private double price;
	
	public Samosa() {
		
	}

	public Samosa(double price) {
		super();
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}
	
	
	private void init() {
		System.out.println("Init Method Call: ");
	}
	private void destroy() {
		System.out.println("Distroy Method Call");
	}
}

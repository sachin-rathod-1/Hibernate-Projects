package com.SpringbootCoreApplication.Constructor;

public class Addition {

	private int a;
	private int b;
	public Addition(double a, double b) {
		super();
		this.a = (int) a;
		this.b = (int) b;
		System.out.println("Condtructor : double, double");
	}
	public Addition(int a, int b) {
		super();
		this.a = a;
		this.b = b;
		System.out.println("Condtructor : int, int");

	}
	
	public void dosum() {
		// TODO Auto-generated method stub
		System.out.println("Sum is: "+(this.a+this.b));
	}
}

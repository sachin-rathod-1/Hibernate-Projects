package com.cdac.Pojo;

public class Employee {

	private int id;
	private String empName;
	private String empEmail;
	private String empPassword;
	private String empAddress;
	private int empSalary;
	
	public Employee() {}

	public Employee( String empName, String empEmail, String empPassword, String empAddress, int empSalary) {
		
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.empAddress = empAddress;
		this.empSalary = empSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	
}

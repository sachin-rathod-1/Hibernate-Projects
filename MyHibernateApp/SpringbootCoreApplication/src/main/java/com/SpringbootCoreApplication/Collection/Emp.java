package com.SpringbootCoreApplication.Collection;

import java.util.*;
public class Emp {

	private String empName;
	private List<String> phones;
	private Set<String> address;
	private Map<String, String> cources;
	
	public Emp() {
		
	}

	public Emp(String empName, List<String> phones, Set<String> address, Map<String, String> cources) {
		super();
		this.empName = empName;
		this.phones = phones;
		this.address = address;
		this.cources = cources;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	public Set<String> getAddress() {
		return address;
	}

	public void setAddress(Set<String> address) {
		this.address = address;
	}

	public Map<String, String> getCources() {
		return cources;
	}

	public void setCources(Map<String, String> cources) {
		this.cources = cources;
	}

	@Override
	public String toString() {
		return "Emp [empName=" + empName + ", phones=" + phones + ", address=" + address + ", cources=" + cources + "]";
	}
	
	
}

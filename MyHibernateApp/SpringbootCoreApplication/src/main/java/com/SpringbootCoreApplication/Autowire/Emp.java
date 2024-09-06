package com.SpringbootCoreApplication.Autowire;

public class Emp {

	private Address address;
	
	Emp(){
		
	}

	public Emp(Address address) {
		super();
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Emp [address=" + address + "]";
	}
	
}

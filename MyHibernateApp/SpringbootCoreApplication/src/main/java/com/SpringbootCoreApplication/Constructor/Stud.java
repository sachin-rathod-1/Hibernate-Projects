package com.SpringbootCoreApplication.Constructor;

public class Stud {

	private int stuID;
	private String stuName;
	private String Address;
	Certi certi;
	Stud(){}
	public Stud(int stuID, String stuName, String address, Certi certi) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		Address = address;
		this.certi = certi;
	}
	@Override
	public String toString() {
		return "Stud [stuID=" + stuID + ", stuName=" + stuName + ", Address=" + Address + ", certi=" + certi + "]";
	}
	
	
}

package com.model;

import java.sql.Blob;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Students")
public class UserRegistrationModel {

	@Id
	@GeneratedValue
	private Long id=null;
	private String name="";
	private String email="";
	private String password="";
	private Date dob=null;
	private String mobile = null;
	private String gender="";
	private String qualification="";
	private String address="";
	private Blob photo=null;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		System.out.println("Id from bean file");
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
}

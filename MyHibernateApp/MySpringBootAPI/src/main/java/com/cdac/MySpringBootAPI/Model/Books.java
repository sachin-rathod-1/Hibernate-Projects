package com.cdac.MySpringBootAPI.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Mark class as an Entity
@Entity
//Mark class name as table name
@Table
public class Books {

	//Defining Bookid as Primary key
	@Id
	@Column
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String authorName;
	@Column
	private float price;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	
	
	
}

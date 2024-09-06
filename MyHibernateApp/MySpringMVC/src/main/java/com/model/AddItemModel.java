package com.model;


import javax.persistence.*;


@Entity
@Table(name="additemmodel")
public class AddItemModel {

	@Id
	@GeneratedValue
	private Long id=null;
	private String itemName="";
	private String itemCode="";
	private String itemType="";

	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}
	public String getItemCode() 
	{
		return itemCode;
	}
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}
	public String getItemType() 
	{
		return itemType;
	}
	public void setItemType(String itemType) 
	{
		this.itemType = itemType;
	}
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}
}

package com.alten.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;

@Entity
@Table(name="CUSTOMER")
public class Customer{
	public Customer() {
		super();
	}
	
	@Id
	@Column(name="Customer_ID")
	private int customerID;
	@Column(name="customer_name")
	private String customerName;
	@Column(name="address")
	private String customerAddress;
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Customer(int customerID,String customerName, String customerAddress) {
		this.customerID=customerID;
		this.customerName=customerName;
		this.customerAddress=customerAddress;
		
	}
}
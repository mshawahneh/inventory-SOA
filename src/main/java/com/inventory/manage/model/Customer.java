/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 
 *
 */
@Entity
public class Customer implements Serializable{


	@Id
	private long id;
	private String CustomerID;
	private String CustomerFirstName;
	private String CustomerLastName;
	private Date CustomerBirthDate;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerID, String customerFirstName,
			String customerLastName, Date customerBirthDate) {
		super();
		CustomerID = customerID;
		CustomerFirstName = customerFirstName;
		CustomerLastName = customerLastName;
		CustomerBirthDate = customerBirthDate;
	}
	
	private long getId() {
		return this.id;

	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getCustomerFirstName() {
		return CustomerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		CustomerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return CustomerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		CustomerLastName = customerLastName;
	}
	public Date getCustomerBirthDate() {
		return CustomerBirthDate;
	}
	public void setCustomerBirthDate(Date customerBirthDate) {
		CustomerBirthDate = customerBirthDate;
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", CustomerFirstName="
				+ CustomerFirstName + ", CustomerLastName=" + CustomerLastName
				+ ", CustomerBirthDate=" + CustomerBirthDate + "]";
	}
	
	
	
	

}

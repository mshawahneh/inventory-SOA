/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;


/**
 * @author Rami
 *
 */
//@Entity
public class Employee implements Serializable, Persistable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@Id
	private String id;
	
	private String name;

	private String address;

	private String phone;

	private String email;

	private String companyName;

	private String notes;

	private String website;

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String id, String name, String address, String phone, 
			String email, String companyName, String notes) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.companyName = companyName;
		this.notes = notes;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getType() {
		return "Employee";
	}
	
}

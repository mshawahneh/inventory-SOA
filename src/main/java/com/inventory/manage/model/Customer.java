/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;


/**
 * @author 
 *
 */
//@Entity
public class Customer implements Serializable, Persistable{


	//@Id
	private String id;
//	private String CustomerID;
	private String CustomerFirstName;
	private String CustomerLastName;
	private Date CustomerBirthDate;
	private String email;
	private Long accountBalance;
	private String currency;
	private Payment paymentInfo;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerID, String customerFirstName,
			String customerLastName, Date customerBirthDate) {
		super();
		this.id = customerID;
		CustomerFirstName = customerFirstName;
		CustomerLastName = customerLastName;
		CustomerBirthDate = customerBirthDate;
		
	}
	
	@Override
	public String getId() {
		return String.valueOf(this.id);

	}
	
	public void setId(String id) {
		this.id = id;
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
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the accountBalance
	 */
	public Long getAccountBalance() {
		return accountBalance;
	}
	/**
	 * @param accountBalance the accountBalance to set
	 */
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the paymentInfo
	 */
	public Payment getPaymentInfo() {
		return paymentInfo;
	}
	/**
	 * @param paymentInfo the paymentInfo to set
	 */
	public void setPaymentInfo(Payment paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + id + ", CustomerFirstName="
				+ CustomerFirstName + ", CustomerLastName=" + CustomerLastName
				+ ", CustomerBirthDate=" + CustomerBirthDate + "]";
	}

	@Override
	public String getType() {
		return "Customer";
	}
	
	
	
	

}

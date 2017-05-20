/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author mshawahn
 *
 */
@Entity
public class Payment implements Serializable, Persistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;

	String method;
	String card;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Payment(long id, String method, String card) {
		super();
		this.id = id;
		this.method = method;
		this.card = card;
	}


	public String getMethod() {
		return method;
	}


	public void setMethod(String method) {
		this.method = method;
	}


	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}


	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return String.valueOf(id);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Payment";
	}
	
	
}

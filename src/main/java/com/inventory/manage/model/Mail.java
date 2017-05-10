/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;

/**
 * @author Rami
 *
 */
public class Mail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String message;
	
	private String to;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

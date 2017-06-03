/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;


/**
 * @author mshawahn
 *
 */
//@Entity
public class Payment implements Serializable, Persistable {

	public static int AUTHORIZED = 1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Id
	private String id;

	String method;
	String card;
	
	int state = AUTHORIZED;
	
	String createTime;
	
	String updateTime;
	

	
	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Payment(String id, String method, String card) {
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


	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return String.valueOf(id);
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}


	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}


	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}


	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Payment";
	}
	
	@Override
	public String toString() {
		
		return "Payment id "+id;
	}
}

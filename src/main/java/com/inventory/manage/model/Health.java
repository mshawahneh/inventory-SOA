/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;


/**
 * @author Rami
 *
 */
public class Health implements Serializable, Persistable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String bmi;

	private String healthStatus;

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getId() {
		return userId;
	}

	@Override
	public String getType() {
		return "HealthInfo";
	}
	
}

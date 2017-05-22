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
public class Shipment implements Serializable, Persistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Id
	private String id;
	
	private String address;
	
	private String shipDate;

	private Employee owner;
	
	
	public Shipment(String id, String address, String shipDate, Employee owner) {
		super();
		this.id = id;
		this.address = address;
		this.shipDate = shipDate;
		this.owner = owner;
	}

	public Shipment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getShipDate() {
		return shipDate;
	}

	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getType() {
		
		return "Shipment";
	}
	
	
}

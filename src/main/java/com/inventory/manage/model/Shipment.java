/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Nora
 *
 */
public class Shipment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private long ShipmentId;
	private String ShipmentName;
	private String ShipmentType;
	private Double ShipmentCost;
	public Shipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shipment(long shipmentId, String shipmentName, String shipmentType,
			Double shipmentCost) {
		super();
		ShipmentId = shipmentId;
		ShipmentName = shipmentName;
		ShipmentType = shipmentType;
		ShipmentCost = shipmentCost;
	}
	public long getShipmentId() {
		return ShipmentId;
	}
	public void setShipmentId(long shipmentId) {
		ShipmentId = shipmentId;
	}
	public String getShipmentName() {
		return ShipmentName;
	}
	public void setShipmentName(String shipmentName) {
		ShipmentName = shipmentName;
	}
	public String getShipmentType() {
		return ShipmentType;
	}
	public void setShipmentType(String shipmentType) {
		ShipmentType = shipmentType;
	}
	public Double getShipmentCost() {
		return ShipmentCost;
	}
	public void setShipmentCost(Double shipmentCost) {
		ShipmentCost = shipmentCost;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Shipment [ShipmentId=" + ShipmentId + ", ShipmentName="
				+ ShipmentName + ", ShipmentType=" + ShipmentType
				+ ", ShipmentCost=" + ShipmentCost + "]";
	}
	
	
    
}

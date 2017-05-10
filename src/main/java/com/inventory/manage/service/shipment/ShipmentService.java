/**
 * 
 */
package com.inventory.manage.service.shipment;

import java.util.List;

import com.inventory.manage.model.Shipment;

/**
 * @author mshawahn
 *
 */
public interface ShipmentService {
	Shipment addShipment(Shipment model);
	void updateShipment(Shipment model);
	boolean deleteShipment(Shipment model);
	boolean isExist(Shipment model);
	Shipment findShipmentById(int id);
	List<Shipment> getAllShipments();
}

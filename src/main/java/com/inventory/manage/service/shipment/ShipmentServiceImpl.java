/**
 * 
 */
package com.inventory.manage.service.shipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Shipment;
import com.inventory.manage.repositories.ShipmentRepository;

/**
 * @author mshawahn
 *
 */
@Service("shipmentService")
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Override
	public Shipment addShipment(Shipment model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateShipment(Shipment model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteShipment(Shipment model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(Shipment model) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Shipment findShipmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shipment> getAllShipments() {
		// TODO Auto-generated method stub
		return null;
	}
}

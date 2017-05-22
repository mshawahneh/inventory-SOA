/**
 * 
 */
package com.inventory.manage.service.shipment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Shipment;
import com.inventory.manage.repositories.ShipmentRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author mshawahn
 *
 */
@Service("shipmentService")
//@Transactional
public class ShipmentServiceImpl implements ShipmentService {

//	@Autowired
//	private ShipmentRepository shipmentRepository;

	@Override
	public Shipment addShipment(Shipment model) {
		PersistenceService.save(model);
		return (Shipment)PersistenceService.getById(model.getId());
	}

	@Override
	public void updateShipment(Shipment model) {
		addShipment(model);
	}

	@Override
	public boolean deleteShipment(Shipment model) {
		PersistenceService.delete(model);
		return true;
	}

	@Override
	public boolean isExist(Shipment model) {
		
		return PersistenceService.getById(model.getId()) != null;
	}

	@Override
	public Shipment findShipmentById(int id) {
		return (Shipment) PersistenceService.getById(String.valueOf(id));
	}

	@Override
	public List<Shipment> getAllShipments() {
		
		return PersistenceService.getAllShipments();
	}
}

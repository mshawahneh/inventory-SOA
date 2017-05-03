/**
 * 
 */
package com.inventory.manage.service.shipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

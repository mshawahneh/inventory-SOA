/**
 * 
 */
package com.inventory.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Shipment;
import com.inventory.manage.service.shipment.ShipmentService;

/**
 * @author mshawahn
 *
 */
@RestController
@RequestMapping("/shipment")
public class ShipmentController {

	@Autowired
	ShipmentService shipmentService;
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Shipment> addShipment(@RequestBody  Shipment shipment, 
			HttpServletRequest request) {
		
		if (shipmentService.isExist(shipment)) {
			return new ResponseEntity<Shipment>(HttpStatus.CONFLICT);
		}
		
		Shipment ship = shipmentService.addShipment(shipment);
		
		return new ResponseEntity<Shipment>(shipment, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Shipment>> getAllShipments() {
		List<Shipment> shipments = shipmentService.getAllShipments();
		if(shipments.isEmpty()){
			return new ResponseEntity<List<Shipment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Shipment>>(shipments, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteShipment(@RequestBody  Shipment shipment, 
			HttpServletRequest request) {
		
		boolean result = shipmentService.deleteShipment(shipment);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
}

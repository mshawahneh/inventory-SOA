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

import com.inventory.manage.model.Order;
import com.inventory.manage.service.order.OrderService;

/**
 * @author mshawahn
 *
 */
@RestController
@RequestMapping("api/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Order> addOrder(@RequestBody  Order order, 
			HttpServletRequest request) {
		
		if (orderService.isExist(order.getId())) {
			return new ResponseEntity<Order>(HttpStatus.CONFLICT);
		}
//		if(order.getPurchasedItems() == null || order.getPurchasedItems().isEmpty()){
//			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
//		}
//		
//		if(order.getCustomer() == null){
//			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
//		}
//		
//		if(order.getShipment() == null){
//			return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
//		}
		
		System.out.println("ship "+order.getShipment());
		System.out.println("Payment "+order.getPayment());
		
		Order order1 = orderService.addOrder(order);
		
		return new ResponseEntity<Order>(order1, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> orders = orderService.getAllOrders();
		if(orders.isEmpty()){
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteOrder(@RequestBody  Order order, 
			HttpServletRequest request) {
		
		boolean result = orderService.delete(order);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(method = RequestMethod.PUT,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> updateProduct(@RequestBody  Order order, 
			HttpServletRequest request) {
		
		Order ord = orderService.addOrder(order);
		if (ord != null) {
			return new ResponseEntity<String>("{\"result\":\"Updated Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Update Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
}

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
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Order> addOrder(@RequestBody  Order order, 
			HttpServletRequest request) {
		
		if (orderService.isExist(order.getName())) {
			return new ResponseEntity<Order>(HttpStatus.CONFLICT);
		}
		
		Order payement = orderService.addOrder(order);
		
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllPayaments() {
		List<Order> orders = orderService.getAllOrders();
		if(orders.isEmpty()){
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deletePayement(@RequestBody  Order order, 
			HttpServletRequest request) {
		
		boolean result = orderService.delete(order);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
}

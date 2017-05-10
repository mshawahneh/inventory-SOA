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

import com.inventory.manage.model.Customer;
import com.inventory.manage.service.customer.CustomerService;
import com.inventory.manage.service.customer.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody  Customer customer, 
			HttpServletRequest request) {
		
		if (customerService.isExist(customer.getCustomerFirstName())) {
			return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
		}
		
		Customer payement = customerService.addCustomer(customer);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getAllPayaments() {
		List<Customer> customers = customerService.getAllCustomers();
		if(customers.isEmpty()){
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deletePayement(@RequestBody  Customer customer, 
			HttpServletRequest request) {
		
		boolean result = customerService.delete(customer);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
}

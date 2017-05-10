package pro1;

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
 
 import com.inventory.manage.model.Payment;
 import com.inventory.manage.service.payment.PaymentService;
 
 /**
  * @author Noura
  *
  */
 @RestController
 @RequestMapping("/payments")
 public class PaymentController {
 	
 	@Autowired
 	private PaymentService paymentService;
 	
 	
 	@RequestMapping(value = "/create" ,
 			method = RequestMethod.POST,  
 			consumes = "application/json",
             produces = "application/json")
 	public ResponseEntity<Payment> addItem(@RequestBody  Payment payment, 
 			HttpServletRequest request) {
 		
 		if (paymentService.isExist(payment.getName())) {
 			return new ResponseEntity<Payment>(HttpStatus.CONFLICT);
 		}
 		
 		Payment itemRes = paymentService.addPayment(payment);
 		
 		return new ResponseEntity<Payment>(itemRes, HttpStatus.OK);
 	}
 
 
 	@RequestMapping(method = RequestMethod.GET)
     public ResponseEntity<List<Payment>> getAllItems() {
 		List<Payment> payments = paymentService.getAllPayments();
 		if(payments.isEmpty()){
 			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
 		}
 		return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);		
     }
 	
 	@RequestMapping(method = RequestMethod.DELETE,  
 			consumes = "application/json",
             produces = "application/json")
 	public ResponseEntity<String> deleteItem(@RequestBody  Payment payment, 
 			HttpServletRequest request) {
 		
 		boolean result = paymentService.delete(payment);
 		if (result) {
 			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
 		}
 		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
 	}
 
 }

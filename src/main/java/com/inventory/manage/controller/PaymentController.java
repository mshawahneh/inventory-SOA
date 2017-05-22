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
import com.inventory.manage.model.Product;
import com.inventory.manage.service.payment.PaymentService;
 
 /**
  * @author Noura
  *
  */
 @RestController
 @RequestMapping("api/payment")
 public class PaymentController {
 	
 	@Autowired
 	private PaymentService paymentService;
 	
 	
 	@RequestMapping(method = RequestMethod.POST,  
 			consumes = "application/json",
             produces = "application/json")
 	public ResponseEntity<Payment> addPayment(@RequestBody  Payment payment, 
 			HttpServletRequest request) {
 		
 		if (paymentService.isExist(payment.getId())) {
 			return new ResponseEntity<Payment>(HttpStatus.CONFLICT);
 		}
 		
 		Payment paymentItem = paymentService.addPayment(payment);
 		
 		return new ResponseEntity<Payment>(paymentItem, HttpStatus.OK);
 	}
 
 
 	@RequestMapping(method = RequestMethod.GET)
     public ResponseEntity<List<Payment>> getAllPayments() {
 		List<Payment> payments = paymentService.getAllPayments();
 		if(payments.isEmpty()){
 			return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
 		}
 		return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);		
     }
 	
 	@RequestMapping(method = RequestMethod.DELETE,  
 			consumes = "application/json",
             produces = "application/json")
 	public ResponseEntity<String> deletePayment(@RequestBody  Payment payment, 
 			HttpServletRequest request) {
 		
 		boolean result = paymentService.delete(payment);
 		if (result) {
 			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
 		}
 		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
 	}
 	
 	@RequestMapping(method = RequestMethod.PUT,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> updateProduct(@RequestBody  Payment payment, 
			HttpServletRequest request) {
		
 		Payment pay = paymentService.addPayment(payment);
		if (pay != null) {
			return new ResponseEntity<String>("{\"result\":\"Updated Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Update Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
 
 }

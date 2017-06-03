/**
 * 
 */
package com.inventory.manage.service.customer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.manage.model.Customer;
import com.inventory.manage.model.Payment;
import com.inventory.manage.model.Persistable;
import com.inventory.manage.model.Shipment;
import com.inventory.manage.repositories.CustomerRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author mshawahn
 *
 */
@Service("customerService")
//@Transactional
public class CustomerServiceImpl implements CustomerService {
	
//	@Autowired
//	private CustomerRepository customerRepository;
	
	private static String PAYMENT_SERVICE_URI = "http://31.168.143.199:8080/paymentsService/paymentsServiceDetails";
		
	@Override
	public Customer addCustomer(Customer customer) {
		Payment payment = addPayment(customer.getPaymentInfo());
		if(payment != null){
			customer.setPaymentInfo(payment);
		}
		PersistenceService.save(customer);
		return (Customer) PersistenceService.getById(customer.getId());
	}

	@Override
	public boolean isExist(String id) {
		
		return PersistenceService.getById(id) != null;
	}
	
	private Payment addPayment(Payment payment) {
		RestTemplate paymentService = new RestTemplate();
		HttpEntity<Payment> request = new HttpEntity<>(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity entity = new HttpEntity(headers);
		 
		ResponseEntity<Payment> response = paymentService.exchange(PAYMENT_SERVICE_URI, HttpMethod.POST, request, Payment.class);
		   
		Payment paymentRes = response.getBody();
		System.out.println("Loaded payment "+paymentRes);
		if (!(response.getStatusCode().value() == HttpStatus.OK.value() || 
				response.getStatusCode().value() == HttpStatus.ACCEPTED.value())){
			return null;
		}
		
		return paymentRes;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return PersistenceService.getAllCustomers();
	}

	@Override
	public boolean delete(Customer customer) {
		PersistenceService.delete(customer);
		return true;
	}
}

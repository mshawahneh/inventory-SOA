/**
 * 
 */
package com.inventory.manage.service.customer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Customer;
import com.inventory.manage.model.Persistable;
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

	@Override
	public Customer addCustomer(Customer customer) {
		PersistenceService.save(customer);
		return (Customer) PersistenceService.getById(customer.getId());
	}

	@Override
	public boolean isExist(String id) {
		
		return PersistenceService.getById(id) != null;
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

/**
 * 
 */
package com.inventory.manage.service.customer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Customer;
import com.inventory.manage.repositories.CustomerRepository;

/**
 * @author mshawahn
 *
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		return null;
	}

	@Override
	public boolean delete(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
}

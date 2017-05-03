/**
 * 
 */
package com.inventory.manage.service.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

/**
 * 
 */
package com.inventory.manage.service.customer;

import java.util.List;

import com.inventory.manage.model.Customer;

/**
 * @author mshawahn
 *
 */
public interface CustomerService {
	/**
	 * Add new customer
	 * @param customer
	 * @return An Customer
	 */
	public Customer addCustomer(Customer customer);
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * Get all customers
	 * @return
	 * @throws DAOException
	 */
    public List<Customer> getAllCustomers();

    /**
     * Delete an Customer
     * @param customer
     * @return
     */
	public boolean delete(Customer customer);
}

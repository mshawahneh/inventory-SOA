/**
 * 
 */
package com.inventory.manage.service.order;

import java.util.List;

import com.inventory.manage.model.Order;
/**
 * @author mshawahn
 *
 */
public interface OrderService {
	/**
	 * Add new order
	 * @param order
	 * @return An Order
	 */
	public Order addOrder(Order order);
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * Get all orders
	 * @return
	 * @throws DAOException
	 */
    public List<Order> getAllOrders();

    /**
     * Delete an Order
     * @param order
     * @return
     */
	public boolean delete(Order order);
}

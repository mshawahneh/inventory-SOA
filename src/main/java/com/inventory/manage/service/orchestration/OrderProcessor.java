/**
 * 
 */
package com.inventory.manage.service.orchestration;

import com.inventory.manage.model.Order;

/**
 * @author mshawahn
 *
 */
public interface OrderProcessor {

	public Order processOrder(Order orderToProcess);
	
}

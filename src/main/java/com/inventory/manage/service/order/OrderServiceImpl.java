/**
 * 
 */
package com.inventory.manage.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.repositories.OrderRepository;

/**
 * @author mshawahn
 *
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
}

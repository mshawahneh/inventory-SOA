/**
 * 
 */
package com.inventory.manage.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Order;
import com.inventory.manage.repositories.OrderRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author mshawahn
 *
 */
@Service("orderService")
//@Transactional
public class OrderServiceImpl implements OrderService {
	
//	@Autowired
//	private OrderRepository orderRepository;

	@Override
	public Order addOrder(Order order) {
		PersistenceService.save(order);
		return (Order) PersistenceService.getById(order.getId());
	}

	@Override
	public boolean isExist(String id) {
		
		return PersistenceService.getById(id) != null;
	}

	@Override
	public List<Order> getAllOrders() {
		return PersistenceService.getAllOrders();
	}

	@Override
	public boolean delete(Order order) {
		PersistenceService.delete(order);
		return true;
	}
}

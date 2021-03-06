/**
 * 
 */
package com.inventory.manage.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Item;
import com.inventory.manage.model.Order;
import com.inventory.manage.repositories.OrderRepository;
import com.inventory.manage.service.currency.CurrencyConverterSOAPService;
import com.inventory.manage.service.orchestration.OrderProcessor;
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

	@Autowired
	private CurrencyConverterSOAPService currencyService;
	
	@Autowired
	private OrderProcessor orderProcessor;
	
	@Override
	public Order addOrder(Order order) {
		Order processedOrder = orderProcessor.processOrder(order);
		
		//No items for the order upon processing it, hence return null and excpetion in the REST layer.
		if(processedOrder == null){
			return null;
		}
		
		PersistenceService.save(processedOrder);
		Order calculatedOrder = (Order) PersistenceService.getById(processedOrder.getId());
		if(calculatedOrder.getPurchasedItems() != null){
			long total = 0;
			for(Item item: calculatedOrder.getPurchasedItems()){
				total += (item.getSellingPrice() * item.getQuantity());
			}
			String currency = calculatedOrder.getCustomer().getCurrency();
			
			if("USD".equals(currency)){
				total = currencyService.convertCurrency((int)total, "USD", "ILS");
				
			}
			calculatedOrder.setTotal(total);
		}
		return calculatedOrder;
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

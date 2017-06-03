/**
 * 
 */
package com.inventory.manage.service.orchestration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inventory.manage.model.Item;
import com.inventory.manage.model.Order;
import com.inventory.manage.model.Payment;
import com.inventory.manage.model.Shipment;




/**
 * @author mshawahn
 *
 */
@Service("orderProcessor")
public class OrderProcessorImpl implements OrderProcessor {

	private static String ITEM_SERVICE_URI = "http://31.168.143.199:8080/itemsService/itemsDetails/{itemId}";
	
	private static String WAREHOUSE_SERVICE_URI = "http://31.168.143.199:8080/warehouseService/warehouseDetails/{itemId}";
	
	private static String PAYMENT_SERVICE_URI = "http://31.168.143.199:8080/paymentsService/paymentsServiceDetails";
	
	private static String SHIPMENT_SERVICE_URI = "http://31.168.143.199:8080/shipmentService/shipmentServiceDetails";
	
	/**
	 * @see com.inventory.manage.service.orchestration.OrderProcessor#processOrder(com.inventory.manage.model.Order)
	 */
	@Override
	public Order processOrder(Order orderToProcess) {
		//Get loaded Item from Item service over HTTP calls.
		List<Item> loadedItemsFromItemService = getLoadedItems(orderToProcess.getPurchasedItems());
		Shipment shipmentFromShipmentService = addShipment(orderToProcess.getShipment());
		Payment paymentFromPaymentService = addPayment(orderToProcess.getPayment());
		List<Item> itemsInWarehouseFromWarehouseService = getItemsInWarehouse(loadedItemsFromItemService);
		
		if(itemsInWarehouseFromWarehouseService == null || itemsInWarehouseFromWarehouseService.size() == 0){
			
			return null;
		}
		orderToProcess.setPurchasedItems(itemsInWarehouseFromWarehouseService);
		orderToProcess.setPayment(paymentFromPaymentService);
		orderToProcess.setShipment(shipmentFromShipmentService);
		
		return orderToProcess;
	}

	private List<Item> getItemsInWarehouse(List<Item> purchasedItems) {
		RestTemplate itemService = new RestTemplate();
		List<Item> itemsInWarehouse = new ArrayList<Item>();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		for (Item item : purchasedItems) {
			HttpEntity entity = new HttpEntity(headers);
			
			ResponseEntity<Item> response = itemService.exchange(WAREHOUSE_SERVICE_URI.replace("{itemId}", item.getId()), HttpMethod.GET, entity, Item.class);
			
			if (response.getStatusCode().value() == HttpStatus.NOT_FOUND.value()){
				continue;
			}
			itemsInWarehouse.add(response.getBody());
		}
		return itemsInWarehouse;
		
	}

	/**
	 * Add payment to the system using HTTP calls to the payment service.
	 * @param payment
	 * @return
	 */
	private Payment addPayment(Payment payment) {
		RestTemplate paymentService = new RestTemplate();
		HttpEntity<Payment> request = new HttpEntity<>(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity entity = new HttpEntity(headers);
		 
		System.out.println("Add payment :"+payment);
		System.out.println("Payment URI "+PAYMENT_SERVICE_URI);
		ResponseEntity<Payment> response = paymentService.exchange(PAYMENT_SERVICE_URI, HttpMethod.POST, request, Payment.class);
		   
		Payment paymentRes = response.getBody();
		System.out.println("Loaded payment "+paymentRes);
		if (!(response.getStatusCode().value() == HttpStatus.OK.value() || 
				response.getStatusCode().value() == HttpStatus.ACCEPTED.value())){
			return null;
		}
		
		return paymentRes;
	}

	/**
	 * Add shipment to the system using HTTP calls 
	 * to shipment web service, before using it in the order.
	 * @param shipment
	 * @return
	 */
	private Shipment addShipment(Shipment shipment) {
		RestTemplate shipmentService = new RestTemplate();
		HttpEntity<Shipment> request = new HttpEntity<>(shipment);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		HttpEntity entity = new HttpEntity(headers);
		 
		ResponseEntity<Shipment> response = shipmentService.exchange(SHIPMENT_SERVICE_URI, HttpMethod.POST, request, Shipment.class);
		   
		Shipment shipmentRes = response.getBody();
		System.out.println("Loaded shipment "+shipmentRes);
		if (!(response.getStatusCode().value() == HttpStatus.OK.value() || 
				response.getStatusCode().value() == HttpStatus.ACCEPTED.value())){
			return null;
		}
		
		return shipmentRes;
	}

	/**
	 * Get the loaded item from item service.
	 * This method calls the item service to load reuested items by ID.
	 * @param purchasedItems
	 * @return
	 */
	private List<Item> getLoadedItems(List<Item> purchasedItems) {
		RestTemplate itemService = new RestTemplate();
		List<Item> loadedItems = new ArrayList<Item>();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		for (Item item : purchasedItems) {
			System.out.println("ITM URI "+ITEM_SERVICE_URI.replace("{itemId}", item.getId()));
			ResponseEntity<Item> response = itemService.getForEntity(ITEM_SERVICE_URI.replace("{itemId}", item.getId()), Item.class);
			if(response.getStatusCode() == HttpStatus.OK){
				loadedItems.add(response.getBody());	
			}
			
		}
		return loadedItems;
	}

	//Check existence of item in warehouse by item id. item or error not found
	//add payment
	//add shipment
	

}

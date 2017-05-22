/**
 * 
 */
package com.inventory.manage.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inventory.manage.model.Catalog;
import com.inventory.manage.model.Customer;
import com.inventory.manage.model.Employee;
import com.inventory.manage.model.Item;
import com.inventory.manage.model.ItemStatus;
import com.inventory.manage.model.Order;
import com.inventory.manage.model.Payment;
import com.inventory.manage.model.Persistable;
import com.inventory.manage.model.Product;
import com.inventory.manage.model.Shipment;

/**
 * @author mshawahn
 *
 */
public class PersistenceService {

	private static int id = 1;
	static Map<String, Persistable> persistenceMap = new HashMap<String, Persistable>();

	static{
		initializeData();
	}
	public static void save(Persistable itemToSave) {
		persistenceMap.put(itemToSave.getId(), itemToSave);

	}

	private static String generateId(){
		return String.valueOf(id++);
	}
	private static void initializeData() {
		Employee emp1 = new Employee(generateId(), "Hisham", "Ramallah", "23205555", "hisam@gmail.com", "Easy Inventory", "Effecient");
		Employee emp = new Employee(generateId(), "Anan", "Birzeit", "23205555", "ana@gmail.com", "Easy Inventory", "bad");
		
		Product eatProduct = new Product(generateId(), "Eat", "Lacosta", "No gurantee");
		Product dressProduct = new Product(generateId(), "Dress", "Shaneil", "1 year");
		
		
		Item milkItem = new Item(generateId(), "Milk", 20, "Piece", 80, 50, "Fresh Milk", "0.05");
		milkItem.setProduct(eatProduct);
		milkItem.setQuantity(1000);
		milkItem.setStatus(ItemStatus.IN_STOCK);
		
		Item clothsItem = new Item(generateId(), "T-Shirt", 30, "Piece", 100, 40, "Local T-Shirt", "0.05");
		clothsItem.setProduct(dressProduct);
		clothsItem.setQuantity(100);
		clothsItem.setStatus(ItemStatus.IN_STOCK);
		
		Payment payment = new Payment(generateId(), "Manual", "2050");
		Payment payment1 = new Payment(generateId(), "PayPal", "2051");
		
		Shipment ship = new Shipment(generateId(), "Ramallah", "25-5-2017", emp1);
		Shipment ship1 = new Shipment(generateId(), "Ramallah", "27-5-2017", emp);
		
		Customer customer = new Customer(generateId(), "Mohammad", "Customer");
		customer.setPaymentInfo(payment);
		
		Customer customer1 = new Customer(generateId(), "Rami", "Customer");
		customer1.setPaymentInfo(payment1);
		
		Order order = new Order(generateId(), "1010", 2000, "20-5-2017", "25-5-2017", true, true);
		Order order1 = new Order(generateId(), "1011", 20002, "20-5-2017", "26-5-2017", true, true);
		
		List<Item> itemsToPurchase = new ArrayList<Item>();
		itemsToPurchase.add(milkItem);
		
		order.setPurchasedItems(itemsToPurchase);
		order.setCustomer(customer);
		order.setShipment(ship);
		
		List<Item> itemsToPurchase1 = new ArrayList<Item>();
		itemsToPurchase1.add(clothsItem);
		
		order1.setPurchasedItems(itemsToPurchase1);
		order1.setCustomer(customer1);
		order1.setShipment(ship1);
		
		
		
		Catalog cat1 = new Catalog(generateId(), "Cat Name", 120, 10, 3, "Info cat", 3, "Sup mnee7");
		
		persistenceMap.put(customer.getId(), customer);
		persistenceMap.put(customer1.getId(), customer1);
		persistenceMap.put(order.getId(), order);
		persistenceMap.put(order1.getId(), order1);
		persistenceMap.put(payment.getId(), payment);
		persistenceMap.put(payment1.getId(), payment1);
		persistenceMap.put(eatProduct.getId(), eatProduct);
		persistenceMap.put(dressProduct.getId(), dressProduct);
		persistenceMap.put(ship.getId(), ship);
		persistenceMap.put(ship1.getId(), ship1);
		
		persistenceMap.put(emp1.getId(), emp1);
		persistenceMap.put(emp.getId(), emp);
		persistenceMap.put(milkItem.getId(), milkItem);
		persistenceMap.put(clothsItem.getId(), clothsItem);
		persistenceMap.put(cat1.getId(), cat1);
	}

	public static void update(Persistable itemToSave) {
		save(itemToSave);
	}

	public static void delete(Persistable itemToSave) {
		persistenceMap.remove(itemToSave.getId());
	}

	public static List<Customer> getAllCustomers() {

		Collection<Persistable> items = persistenceMap.values();
		List<Customer> resultSet = new ArrayList<Customer>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Customer")) {
				resultSet.add((Customer) persistable);
			}
		}
		return resultSet;

	}

	public static List<Shipment> getAllShipments() {

		Collection<Persistable> items = persistenceMap.values();
		List<Shipment> resultSet = new ArrayList<Shipment>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Shipment")) {
				resultSet.add((Shipment) persistable);
			}
		}
		return resultSet;

	}
	
	public static List<Order> getAllOrders() {

		Collection<Persistable> items = persistenceMap.values();
		List<Order> resultSet = new ArrayList<Order>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Order")) {
				resultSet.add((Order) persistable);
			}
		}
		
		return resultSet;

	}
	
	public static List<Payment> getAllPayments() {

		Collection<Persistable> items = persistenceMap.values();
		List<Payment> resultSet = new ArrayList<Payment>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Payment")) {
				resultSet.add((Payment) persistable);
			}
		}
		
		return resultSet;

	}

	public static List<Product> getAllProducts() {

		Collection<Persistable> items = persistenceMap.values();
		List<Product> resultSet = new ArrayList<Product>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Product")) {
				resultSet.add((Product) persistable);
			}
		}
		
		return resultSet;

	}
	public static List<Persistable> getAll(String type) {

		Collection<Persistable> items = persistenceMap.values();
		List<Persistable> resultSet = new ArrayList<Persistable>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals(type)) {
				resultSet.add(persistable);
			}
		}
		return resultSet;

	}

	public static Object getById(String id) {
		return persistenceMap.get(id);
	}

	public static List<Employee> getAllEmployees() {
		Collection<Persistable> items = persistenceMap.values();
		List<Employee> resultSet = new ArrayList<Employee>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Employee")) {
				resultSet.add((Employee) persistable);
			}
		}
		return resultSet;

	}

	public static List<Item> getAllItems() {
		Collection<Persistable> items = persistenceMap.values();
		List<Item> resultSet = new ArrayList<Item>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Item")) {
				resultSet.add((Item) persistable);
			}
		}
		return resultSet;
	}

	public static List<Catalog> getAllCatalogs() {
		Collection<Persistable> items = persistenceMap.values();
		List<Catalog> resultSet = new ArrayList<Catalog>();
		for (Persistable persistable : items) {

			if (persistable.getType().equals("Catalog")) {
				resultSet.add((Catalog) persistable);
			}
		}
		return resultSet;
	}
}

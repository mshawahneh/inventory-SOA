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

import com.inventory.manage.model.Customer;
import com.inventory.manage.model.Employee;
import com.inventory.manage.model.Order;
import com.inventory.manage.model.Payment;
import com.inventory.manage.model.Persistable;
import com.inventory.manage.model.Product;

/**
 * @author mshawahn
 *
 */
public class PersistenceService {

	static Map<String, Persistable> persistenceMap = new HashMap<String, Persistable>();

	static{
		initializeData();
	}
	public static void save(Persistable itemToSave) {
		persistenceMap.put(itemToSave.getId(), itemToSave);

	}

	private static void initializeData() {
		Customer customer = new Customer("1010", "test", "Customer", new Date());
		Customer customer1 = new Customer("1011", "test1", "Customer", new Date());
		Order order = new Order(2020, "order1", "2000", new Date(), new Date(), true, true);
		Order order1 = new Order(2021, "order2", "20002", new Date(), new Date(), true, true);
		Payment payment = new Payment(3030, "Manual", "2050");
		Payment payment1 = new Payment(3031, "PayPal", "2051");
		Product product = new Product("4040", "Eat", "Lacosta", "No gurantee");
		Product product1 = new Product("4041", "Dress", "Shaneil", "1 year");
		
		Employee emp1 = new Employee("10", "Mashi el 7al", "Waan ma Kan", "23205555", "email@gmail.com", "ComPany", "Fesh Eshi");
		
		persistenceMap.put(customer.getId(), customer);
		persistenceMap.put(customer1.getId(), customer1);
		persistenceMap.put(order.getId(), order);
		persistenceMap.put(order1.getId(), order1);
		persistenceMap.put(payment.getId(), payment);
		persistenceMap.put(payment1.getId(), payment1);
		persistenceMap.put(product.getId(), product);
		persistenceMap.put(product1.getId(), product1);
		
		persistenceMap.put(emp1.getId(), emp1);
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
}

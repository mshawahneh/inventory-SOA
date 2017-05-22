/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author Noura
 *
 */
//@Entity
public class Order implements Serializable, Persistable {

	private static final long serialVersionUID = 1L;
	
	//@Id
	private String id;
	
	private Customer customer;
	private String number;
	private long quantity;
	private String datePlaced;
	private String dateReceived;
	private boolean outstanding;
	private boolean addedToStock;
	private List<Item> purchasedItems;
	private Payment payment;
	
	private Shipment shipment;
	
	private long total;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String name, long quantity, String dateplaced,
			String dateReceived, boolean outstanding, boolean addedToStock) {
		super();
		this.id = id;
		this.number = name;
		this.quantity = quantity;
		this.datePlaced = dateplaced;
		this.dateReceived = dateReceived;
		this.outstanding = outstanding;
		this.addedToStock = addedToStock;
	}
	
	@Override
	public String getId() {
		return String.valueOf(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String name) {
		this.number = name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getDateplaced() {
		return datePlaced;
	}
	public void setDateStringed(String dateplaced) {
		this.datePlaced = dateplaced;
	}
	public String getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}
	public boolean isOutstanding() {
		return outstanding;
	}
	public void setOutstanding(boolean outstanding) {
		this.outstanding = outstanding;
	}
	public boolean isAddedToStock() {
		return addedToStock;
	}
	public void setAddedToStock(boolean addedToStock) {
		this.addedToStock = addedToStock;
	}
	
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the datePlaced
	 */
	public String getDatePlaced() {
		return datePlaced;
	}
	/**
	 * @param datePlaced the datePlaced to set
	 */
	public void setDatePlaced(String datePlaced) {
		this.datePlaced = datePlaced;
	}
	/**
	 * @return the purchasedItems
	 */
	public List<Item> getPurchasedItems() {
		return purchasedItems;
	}
	/**
	 * @param purchasedItems the purchasedItems to set
	 */
	public void setPurchasedItems(List<Item> purchasedItems) {
		this.purchasedItems = purchasedItems;
	}
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	/**
	 * @return the shipment
	 */
	public Shipment getShipment() {
		return shipment;
	}
	/**
	 * @param shipment the shipment to set
	 */
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", quantity=" + quantity
				+ ", dateplaced=" + datePlaced + ", dateReceived="
				+ dateReceived + ", outstanding=" + outstanding
				+ ", addedToStock=" + addedToStock + "]";
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Order";
	}
	
	
    
}

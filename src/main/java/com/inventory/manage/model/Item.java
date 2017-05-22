/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;


/**
 * @author Rami
 *
 */
//@Entity
public class Item implements Serializable, Persistable {

	private static final long serialVersionUID = 1L;
	
	//@Id
	private String id;
	private String name;
	private long quantity;
	private String unit;
	private int sellingPrice;
	private int purchasePrice;
	private String description;
	private String rate;
	private Product product;
	private ItemStatus status;
	
	public Item(String id, String name, long quantity, String unit, 
			int sellingPrice, int purchasePrice, String description, String rate) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.description = description;
		this.rate=rate;
	}
	
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the status
	 */
	public ItemStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	@Override
	public String getType() {
		return "Item";
	}
    
}


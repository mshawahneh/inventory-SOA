/**
 * 
 */
package com.inventory.manage.model;


/**
 * @author rkhalayl
 *
 */
//@Entity
public class Catalog implements Persistable{
	
	//@Id
	private String id; 
	private String name;
	private double price;
	private long tax;
	private int warranty;
	private String depreciation;
	private float rate; 
	private String supplier;
	
	public Catalog(String id, String name, double price, long tax, int warranty, 
			String depreciation, float rate, String supplier) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.tax = tax;
		this.warranty = warranty;
		this.depreciation = depreciation;
		this.rate = rate;
		this.supplier = supplier;
			
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getTax() {
		return tax;
	}
	public void setTax(long tax) {
		this.tax = tax;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	public String getDepreciation() {
		return depreciation;
	}
	public void setDepreciation(String depreciation) {
		this.depreciation = depreciation;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	@Override
	public String getType() {
		return "Catalog";
	}
}

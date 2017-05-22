/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;


/**
 * @author mshawahn
 *
 */
//@Entity
public class Product implements Serializable, Persistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@Id
	private String id;
	private String category;
	private String supplier;
	private String guaranteeInfo;
	
	public Product(String id, String category, String supplier, String guaranteeInfo) {
		super();
		this.id = id;
		this.category = category;
		this.supplier = supplier;
		this.guaranteeInfo = guaranteeInfo;
	}



	public Product() {
		// TODO Auto-generated constructor stub
	}



	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getGuaranteeInfo() {
		return guaranteeInfo;
	}

	public void setGuaranteeInfo(String guaranteeInfo) {
		this.guaranteeInfo = guaranteeInfo;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Product";
	}
	
	

}

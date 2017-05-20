/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Noura
 *
 */
@Entity
public class Order implements Serializable, Persistable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	private String name;
	private String quantity;
	private Date dateplaced;
	private Date dateReceived;
	private boolean outstanding;
	private boolean addedToStock;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long id, String name, String quantity, Date dateplaced,
			Date dateReceived, boolean outstanding, boolean addedToStock) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.dateplaced = dateplaced;
		this.dateReceived = dateReceived;
		this.outstanding = outstanding;
		this.addedToStock = addedToStock;
	}
	
	@Override
	public String getId() {
		return String.valueOf(id);
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Date getDateplaced() {
		return dateplaced;
	}
	public void setDateplaced(Date dateplaced) {
		this.dateplaced = dateplaced;
	}
	public Date getDateReceived() {
		return dateReceived;
	}
	public void setDateReceived(Date dateReceived) {
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
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", quantity=" + quantity
				+ ", dateplaced=" + dateplaced + ", dateReceived="
				+ dateReceived + ", outstanding=" + outstanding
				+ ", addedToStock=" + addedToStock + "]";
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Order";
	}
	
	
    
}

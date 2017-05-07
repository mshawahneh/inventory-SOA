/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;

/**
 * @author mshawahn
 *
 */
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemName;
	private int itemColor;
	private char itemSymbol;
	private int itemWeight;
   	private int itemValue;
    
    
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Item(String itemName, int itemColor, char itemSymbol,
			int itemWeight, int itemValue) {
		super();
		this.itemName = itemName;
		this.itemColor = itemColor;
		this.itemSymbol = itemSymbol;
		this.itemWeight = itemWeight;
		this.itemValue = itemValue;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public int getItemColor() {
		return itemColor;
	}


	public void setItemColor(int itemColor) {
		this.itemColor = itemColor;
	}


	public char getItemSymbol() {
		return itemSymbol;
	}


	public void setItemSymbol(char itemSymbol) {
		this.itemSymbol = itemSymbol;
	}


	public int getItemWeight() {
		return itemWeight;
	}


	public void setItemWeight(int itemWeight) {
		this.itemWeight = itemWeight;
	}


	public int getItemValue() {
		return itemValue;
	}


	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}


	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemColor=" + itemColor
				+ ", itemSymbol=" + itemSymbol + ", itemWeight=" + itemWeight
				+ ", itemValue=" + itemValue + "]";
	}
	
	
    
    
    
    
}


/**
 * 
 */
package com.inventory.manage.service.item;

import java.util.List;

import com.inventory.manage.model.Item;

/**
 * @author Rami
 *
 */
public interface ItemsService {

	/**
	 * Add new item
	 * @param item
	 * @return An Item
	 */
	public Item addItem(Item item);
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * Get all items
	 * @return
	 * @throws DAOException
	 */
    public List<Item> getAllItems();

    /**
     * Delete an Item
     * @param item
     * @return
     */
	public boolean delete(Item item);
}

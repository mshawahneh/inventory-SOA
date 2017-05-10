/**
 * 
 */
package com.inventory.manage.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Item;
import com.inventory.manage.repositories.ItemRepository;

/**
 * @author Rami
 *
 */
@Service("itemsService")
@Transactional
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item addItem(Item item) {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean isExist(String name) {
		// TODO To be implemented
		return false;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean delete(Item item) {
		// TODO To be implemented
		return false;
	}
}

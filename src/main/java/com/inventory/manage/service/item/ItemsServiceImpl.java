/**
 * 
 */
package com.inventory.manage.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.manage.model.Item;
import com.inventory.manage.repositories.ItemRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author Rami
 *
 */
@Service("itemsService")
//@Transactional
public class ItemsServiceImpl implements ItemsService {

//	@Autowired
//	private ItemRepository itemRepository;

	@Override
	public Item addItem(Item item) {
		PersistenceService.save(item);
		return item;
	}

	@Override
	public Item updateItem(Item item) {
		PersistenceService.save(item);
		return item;
	}

	@Override
	public List<Item> getAllItems() {
		return PersistenceService.getAllItems();
	}

	@Override
	public Item getItemById(String id) {
		return (Item)PersistenceService.getById(id);
	}

	@Override
	public boolean isExist(String id) {
		return PersistenceService.getById(id) != null;
	}

	@Override
	public boolean delete(Item item) {
		PersistenceService.delete(item);
		return true;
	}
}

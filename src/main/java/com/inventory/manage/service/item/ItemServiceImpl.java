/**
 * 
 */
package com.inventory.manage.service.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.repositories.ItemRepository;

/**
 * @author mshawahn
 *
 */
@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
}

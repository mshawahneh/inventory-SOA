/**
 * 
 */
package com.inventory.manage.service.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Catalog;
import com.inventory.manage.repositories.ItemRepository;

/**
 * @author Rami
 *
 */
@Service("itemsService")
@Transactional
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Catalog addCatalog(Catalog catalog) {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean isExist(String name) {
		// TODO To be implemented
		return false;
	}

	@Override
	public List<Catalog> getAllCatalogs() {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean delete(Catalog catalog) {
		// TODO To be implemented
		return false;
	}

	@Override
	public List<Catalog> getAllCatalogsBySupplier(String supplier) {
		// TODO Auto-generated method stub
		return null;
	}

}

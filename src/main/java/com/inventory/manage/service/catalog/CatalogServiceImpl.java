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
import com.inventory.manage.util.PersistenceService;

/**
 * @author Rami
 *
 */
@Service("catalogService")
@Transactional
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Catalog addCatalog(Catalog catalog) {
		PersistenceService.save(catalog);
		return catalog;
	}

	@Override
	public Catalog updateCatalog(Catalog catalog) {
		PersistenceService.save(catalog);
		return catalog;
	}

	@Override
	public List<Catalog> getAllCatalogs() {
		return PersistenceService.getAllCatalogs();
	}

	@Override
	public Catalog getCatalogById(String id) {
		return (Catalog)PersistenceService.getById(id);
	}

	@Override
	public boolean isExist(String id) {
		return PersistenceService.getById(id) != null;
	}

	@Override
	public boolean delete(Catalog catalog) {
		PersistenceService.delete(catalog);
		return true;
	}
	@Override
	public List<Catalog> getAllCatalogsBySupplier(String supplier) {
		// TODO Auto-generated method stub
		return PersistenceService.getAllCatalogs();
	}
}

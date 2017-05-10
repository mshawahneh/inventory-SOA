/**
 * 
 */
package com.inventory.manage.service.catalog;

import java.util.List;

import com.inventory.manage.model.Catalog;

/**
 * @author Rami
 *
 */
public interface CatalogService {

	/**
	 * Add new Catalog
	 * @param Catalog
	 * @return An Catalog
	 */
	public Catalog addCatalog(Catalog catalog);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * Get all Catalogs
	 * @return
	 */
    public List<Catalog> getAllCatalogs();
    
    /**
     * Get all catalogs for specific supplier
     * @return
     */
    public List<Catalog> getAllCatalogsBySupplier(String supplier);

    /**
     * Delete an Item
     * @param item
     * @return
     */
	public boolean delete(Catalog catalog);
}

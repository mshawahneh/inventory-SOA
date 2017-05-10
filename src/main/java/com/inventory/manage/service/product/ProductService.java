/**
 * 
 */
package com.inventory.manage.service.product;

import java.util.List;

import com.inventory.manage.model.Product;

/**
 * @author Noura
 *
 */
public interface ProductsService {

	/**
	 * Add new product
	 * @param product
	 * @return An Product
	 */
	public Product addProduct(Product product);
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	public boolean isExist(String name);
	
	/**
	 * Get all products
	 * @return
	 * @throws DAOException
	 */
    public List<Product> getAllProducts();

    /**
     * Delete an Product
     * @param product
     * @return
     */
	public boolean delete(Product product);
}

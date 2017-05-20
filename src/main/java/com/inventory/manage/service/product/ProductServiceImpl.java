/**
 * 
 */
package com.inventory.manage.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Product;
import com.inventory.manage.repositories.ProductRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author Noura
 *
 */
@Service("productsService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		PersistenceService.save(product);
		return (Product) PersistenceService.getById(product.getId());
	}

	@Override
	public boolean isExist(String id) {
		return PersistenceService.getById(id) != null;
	}

	@Override
	public List<Product> getAllProducts() {
		return PersistenceService.getAllProducts();
	}

	@Override
	public boolean delete(Product product) {
		PersistenceService.delete(product);
		return true;
	}
}

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
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean isExist(String name) {
		// TODO To be implemented
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean delete(Product product) {
		// TODO To be implemented
		return false;
	}
}

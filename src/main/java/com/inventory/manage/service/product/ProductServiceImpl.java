/**
 * 
 */
package com.inventory.manage.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.repositories.ProductRepository;

/**
 * @author mshawahn
 *
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
}

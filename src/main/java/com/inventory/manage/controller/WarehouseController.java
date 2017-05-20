/**
 * 
 */
package com.inventory.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Product;
import com.inventory.manage.service.product.ProductService;

/**
 * @author mshawahn
 *
 */
@RestController
@RequestMapping("api/product")
public class WarehouseController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Product> addProduct(@RequestBody  Product product, 
			HttpServletRequest request) {
		
		if (productService.isExist(product.getCategory())) {
			return new ResponseEntity<Product>(HttpStatus.CONFLICT);
		}
		
		Product product1 = productService.addProduct(product);
		
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		if(products.isEmpty()){
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteProduct(@RequestBody  Product product, 
			HttpServletRequest request) {
		
		boolean result = productService.delete(product);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@RequestMapping(method = RequestMethod.PUT,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> updateProduct(@RequestBody  Product product, 
			HttpServletRequest request) {
		
		Product prod = productService.addProduct(product);
		if (prod != null) {
			return new ResponseEntity<String>("{\"result\":\"Updated Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Update Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}
}

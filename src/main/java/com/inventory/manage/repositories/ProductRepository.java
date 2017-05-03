/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Product;

/**
 * @author mshawahn
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}

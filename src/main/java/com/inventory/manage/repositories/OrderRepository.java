/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Order;

/**
 * @author mshawahn
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}

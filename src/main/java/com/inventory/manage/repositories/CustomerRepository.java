/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.manage.model.Customer;

/**
 * @author mshawahn
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

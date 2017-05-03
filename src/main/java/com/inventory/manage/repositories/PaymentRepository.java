/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Payment;

/**
 * @author mshawahn
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Shipment;

/**
 * @author mshawahn
 *
 */
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

}

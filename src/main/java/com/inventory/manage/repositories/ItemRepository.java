/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Item;

/**
 * @author mshawahn
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}

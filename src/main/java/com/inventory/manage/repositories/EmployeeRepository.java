/**
 * 
 */
package com.inventory.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.manage.model.Employee;

/**
 * @author mshawahn
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

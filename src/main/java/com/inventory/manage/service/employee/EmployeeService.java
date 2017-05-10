/**
 * 
 */
package com.inventory.manage.service.employee;

import java.util.List;

import com.inventory.manage.model.Employee;

/**
 * @author Rami
 *
 */
public interface EmployeeService {

	/**
	 * Add new employee
	 * @param employee
	 * @return
	 */
	public Employee addEmployee(Employee employee);
	
	/**
	 * Update employee
	 * @param employee
	 * @return
	 */
	public Employee updateEmployee(Employee employee);
	
	/**
	 * Get all employees
	 * @return
	 */
    public List<Employee> getAllEmployees();
 
	/**
	 * Get employee by Id
	 * @return
	 */
    public Employee getEmployeeById(long id);
 
	/**
	 * @return boolean
	 */
	public boolean isExist(String name);

	/**
	 * Delete employee entity
	 * @param employee
	 * @return boolean
	 */
	public boolean delete(Employee employee);

}

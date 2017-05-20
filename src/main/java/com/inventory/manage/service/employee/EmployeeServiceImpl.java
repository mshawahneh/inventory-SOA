/**
 * 
 */
package com.inventory.manage.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.manage.model.Employee;
import com.inventory.manage.repositories.EmployeeRepository;
import com.inventory.manage.util.PersistenceService;

/**
 * @author Rami
 *
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		PersistenceService.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		PersistenceService.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return PersistenceService.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(String id) {
		return (Employee)PersistenceService.getById(id);
	}

	@Override
	public boolean isExist(String id) {
		return PersistenceService.getById(id) != null;
	}

	@Override
	public boolean delete(Employee employee) {
		PersistenceService.delete(employee);
		return true;
	}
	
}

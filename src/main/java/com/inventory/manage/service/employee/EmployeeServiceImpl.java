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
		// TODO To be implemented
		return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO To be implemented
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO To be implemented
		return null;
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO To be implemented
		return null;
	}

	@Override
	public boolean isExist(String name) {
		// TODO To be implemented
		return false;
	}

	@Override
	public boolean delete(Employee employee) {
		// TODO To be implemented
		return false;
	}
	
}

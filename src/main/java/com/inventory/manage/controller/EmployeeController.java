/**
 * 
 */
package com.inventory.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Employee;
import com.inventory.manage.service.employee.EmployeeService;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Employee> addItem(@RequestBody  Employee employee, 
			HttpServletRequest request) {
		
		if (employeeService.isExist(employee.getName())) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
		
		Employee itemRes = employeeService.addEmployee(employee);
		
		return new ResponseEntity<Employee>(itemRes, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllItems() {
		List<Employee> employees = employeeService.getAllEmployees();
		if(employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);		
    }
	
	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteItem(@RequestBody  Employee employee, 
			HttpServletRequest request) {
		
		boolean result = employeeService.delete(employee);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}

}

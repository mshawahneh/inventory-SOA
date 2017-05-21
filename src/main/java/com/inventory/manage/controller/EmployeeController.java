/**
 * 
 */
package com.inventory.manage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.manage.model.Employee;
import com.inventory.manage.model.Health;
import com.inventory.manage.service.employee.EmployeeService;
import com.inventory.manage.service.orchestration.HealthInfo;
import com.inventory.manage.service.orchestration.HealthInfoImpl;

import io.swagger.annotations.ApiOperation;

/**
 * @author Rami
 *
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private HealthInfo healthInfo = new HealthInfoImpl();
	
	@RequestMapping(value = "/create" ,
			method = RequestMethod.POST,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee, 
			HttpServletRequest request) {
		
		if (employeeService.isExist(employee.getName())) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
		
		Employee EmployeeRes = employeeService.addEmployee(employee);
		
		return new ResponseEntity<Employee>(EmployeeRes, HttpStatus.OK);
	}


	@ApiOperation(value = "Get the health information for a person",
			    notes = "This API calls an external web service to get health information for a person.",
			    response = Health.class,
			    responseContainer = "Entity")
	@RequestMapping(value = "/healthInfo/{id}",
			method = RequestMethod.GET)
    public ResponseEntity<Health> getAllEmployeeHealthInfo(@PathVariable("id") String id) {
		Health healthIn = healthInfo.getEmployeeHealthInfo(id);
		if(healthIn == null){
			return new ResponseEntity<Health>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Health>(healthIn, HttpStatus.OK);		
    }

	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		if(employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);		
    }

	@RequestMapping(method = RequestMethod.DELETE,  
			consumes = "application/json",
            produces = "application/json")
	public ResponseEntity<String> deleteEmployee(@RequestBody  Employee employee, 
			HttpServletRequest request) {
		
		boolean result = employeeService.delete(employee);
		if (result) {
			return new ResponseEntity<String>("{\"result\":\"Deleted Successfully!\"}", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Deleted Failed!", HttpStatus.METHOD_NOT_ALLOWED);
	}

}

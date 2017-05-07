/**
 * 
 */
package com.inventory.manage.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mshawahn
 *
 */
public class Employee implements Serializable{




	private String EmployeeID;
	private String EmployeeFirstName;
	private String EmployeeLastName;
	private Date EmployeeBirthDate;
	private Date EmployeeHireDate;
	private double salary;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeID, String employeeFirstName,
			String employeeLastName, Date employeeBirthDate,
			Date employeeHireDate, double salary) {
		super();
		EmployeeID = employeeID;
		EmployeeFirstName = employeeFirstName;
		EmployeeLastName = employeeLastName;
		EmployeeBirthDate = employeeBirthDate;
		EmployeeHireDate = employeeHireDate;
		this.salary = salary;
	}
	public String getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}
	public String getEmployeeFirstName() {
		return EmployeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		EmployeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return EmployeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		EmployeeLastName = employeeLastName;
	}
	public Date getEmployeeBirthDate() {
		return EmployeeBirthDate;
	}
	public void setEmployeeBirthDate(Date employeeBirthDate) {
		EmployeeBirthDate = employeeBirthDate;
	}
	public Date getEmployeeHireDate() {
		return EmployeeHireDate;
	}
	public void setEmployeeHireDate(Date employeeHireDate) {
		EmployeeHireDate = employeeHireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", EmployeeFirstName="
				+ EmployeeFirstName + ", EmployeeLastName=" + EmployeeLastName
				+ ", EmployeeBirthDate=" + EmployeeBirthDate
				+ ", EmployeeHireDate=" + EmployeeHireDate + ", salary="
				+ salary + "]";
	}
	
	
	
}

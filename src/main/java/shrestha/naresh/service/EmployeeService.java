package shrestha.naresh.service;

import java.util.List;

import shrestha.naresh.entity.Employee;

public interface EmployeeService {

	//Add and Update Employee
		public void addEmployee(Employee employee);
		public void updateEmployee(Employee employee);
	
	//Read Employee;
		public List<Employee> listEmployees();
		public Employee getEmployee(int id);
		
	//Delete Employee
		public void deleteEmployee(int id);
}

package shrestha.naresh.dao;

import java.util.List;

import shrestha.naresh.entity.Employee;

public interface EmployeeDao {

	/*void insertEmployee(Employee employee);

	Employee getEmployeeById(int employeeId);

	List<Employee> getEmployeeByFirstName(String firstName);

	List<Employee> getAllEmployees();
	*/
	
	//Add and Update Employee
		public void addEmployee(Employee employee);
		public void updateEmployee(Employee employee);
	
	//Read Employee
	public List<Employee> listEmployees();
	public Employee getEmployee(int id);
	
	//Delete Employee
	public void deleteEmployee(int id);

}

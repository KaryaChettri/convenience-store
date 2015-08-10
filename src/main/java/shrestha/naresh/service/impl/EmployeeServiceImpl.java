package shrestha.naresh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shrestha.naresh.dao.EmployeeDao;
import shrestha.naresh.entity.Employee;
import shrestha.naresh.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public void addEmployee(Employee employee) {
           employeeDao.addEmployee(employee);
    }
    @Transactional
    public void updateEmployee(Employee employee) {
           employeeDao.updateEmployee(employee);
    }
    

    @Transactional( readOnly = true)
    public List<Employee> listEmployees() {
           return employeeDao.listEmployees();
    }

    @Transactional( readOnly = true)
    public Employee getEmployee(int id) {
           return employeeDao.getEmployee(id);
    }

    @Transactional
    public void deleteEmployee(int id) {
    	employeeDao.deleteEmployee(id);

    }
    
}

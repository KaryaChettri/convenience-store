package shrestha.naresh.dao.impl;

import java.util.List;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shrestha.naresh.dao.EmployeeDao;
import shrestha.naresh.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	 public void addEmployee(Employee employee) {
         
         getCurrentSession().save(employee);
  }
	@Override
	 public void updateEmployee(Employee employee) {
         
         getCurrentSession().update(employee);
  }

  @SuppressWarnings("unchecked")
public List<Employee> listEmployees() {

         return getCurrentSession().createQuery("From Employee").list();
  }

  public Employee getEmployee(int id) {
	  Employee employee = (Employee)getCurrentSession().get(Employee.class,id);
	  
         return employee;
  }

  public void deleteEmployee(int id) {

         Employee employee = getEmployee(id);
         getCurrentSession().delete(employee);   
	
}
  
}



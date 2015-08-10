package shrestha.naresh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shrestha.naresh.config.HibernateConfig;
import shrestha.naresh.dao.EmployeeDao;
import shrestha.naresh.dao.ScheduleDao;
import shrestha.naresh.entity.Employee;
import shrestha.naresh.service.EmployeeService;

/**
 * 
 * This Test Case demonstrates the basic CRUD:Delete operation
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext context=new ClassPathXMLApplicationContext
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:dispatcher-servlet-test.xml" })
public class DeleteEmployeeTest {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	EmployeeService employeeService;
	
		
	@Before
	public  void initializeSessionFactory() {
		sessionFactory = HibernateConfig.getSessionAnnotationFactory();
	}

	/**
	 * CRUD: Delete 
	 * Remove Ignore if you want to delete
	 */
	@Ignore
	
	@Test
	public void deleteTest() {
		Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        @SuppressWarnings("unchecked")
		List<Employee> employees = employeeService.listEmployees();//(List<Employee>)session.createCriteria(Employee.class).list();
        for (Employee emp : employees) {
        	System.out.println("**EMP**" +  emp);
        	if ("Test".equals(emp.getFirstName())) {
        		session.delete(emp);
        	}
        }
        //Commit transaction
        session.getTransaction().commit();
        //session.close();
	}
	
	@After
	public void closeSessionFactory() {
		//terminate session factory, otherwise program won't end
        sessionFactory.close();
	}
}

package shrestha.naresh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shrestha.naresh.config.HibernateConfig;
import shrestha.naresh.entity.Employee;
import shrestha.naresh.service.EmployeeService;

/**
 * 
 * This Test Case demonstrates the basic CRUD:Update operation
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext context=new ClassPathXMLApplicationContext
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:dispatcher-servlet-test.xml" })
public class UpdateEmployeeTest {
	
	private  SessionFactory sessionFactory;

	@Autowired
	EmployeeService employeeService;
	
	@Before
	public  void initializeSessionFactory() {
		sessionFactory = HibernateConfig.getSessionAnnotationFactory();
	}

	/**
	 * CRUD: Update
	 */
	@Ignore
	@Test
	public void updateTest() {
		/*Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();*/
        //Save the Model object
        @SuppressWarnings("unchecked")
		List<Employee> employees = employeeService.listEmployees(); //(List<Employee>)session.createCriteria(Employee.class).list();
        //write a named query and get that particular object .. firstName = Naresh .. 
        //from Employee where firstName = ?
        //employeeService.updateEmployee(employee);
        
        for (Employee emp : employees) {
        	if (emp.getFirstName().equals("Naresh")) {
        		System.out.println("Updating Naresh");
        		Assert.assertEquals("Operator", emp.getTitle());
        		emp.setTitle("Operator2");
        		employeeService.updateEmployee(emp);
        		Assert.assertEquals("Operator2", emp.getTitle());
        	}
        }
       /* //Commit transaction
        session.getTransaction().commit();
        //session.close();
*/	}
	
	@After
	public void closeSessionFactory() {
		//terminate session factory, otherwise program won't end
        sessionFactory.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

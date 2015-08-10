package shrestha.naresh;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
import shrestha.naresh.service.impl.EmployeeServiceImpl;

/**
 * 
 * This Test Case demonstrates the basic CRUD:Retrieve operation
 *
 */
public class RetrieveEmployeeTest {
	
	private static SessionFactory sessionFactory;
	
	private Session session;
	
	
	@BeforeClass
	public static void initializeSessionFactory() {
		sessionFactory = HibernateConfig.getSessionAnnotationFactory();
	}
	
	@Before
	public void initializeSession () {
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
	}
	
	@After
	public void cleanUpSession() {
		session.close();
	}

	/**
	 * CRUD: Retrieve
	 */
	//@Ignore
	@Test
	public void selectTest() {
        //start transaction
        //Save the Model object
        @SuppressWarnings("unchecked")
		List<Employee> employees = (List<Employee>)session.createCriteria(Employee.class).list();
        for (Employee emp : employees) {
        	System.out.println("EMP**" +  emp);
        }
        //Commit transaction
        //session.getTransaction().commit();
        //session.close();
	}
	
	@AfterClass
	public static void closeSessionFactory() {
		//terminate session factory, otherwise program won't end
        sessionFactory.close();
	}
}

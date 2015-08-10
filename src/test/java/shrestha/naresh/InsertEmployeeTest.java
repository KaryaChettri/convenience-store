package shrestha.naresh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shrestha.naresh.config.HibernateConfig;
import shrestha.naresh.entity.Employee;

/**
 * 
 * This Test Case demonstrates the basic CRUD:Create operation
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext context=new ClassPathXMLApplicationContext
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:dispatcher-servlet-test.xml" })
public class InsertEmployeeTest {
	
	private SessionFactory sessionFactory;
	
	@Before
	public void initializeSessionFactory() {
		sessionFactory = HibernateConfig.getSessionAnnotationFactory();
	}

	/**
	 * CRUD: Create
	 */

	@Ignore
	@Test
	public void insertTest() {
		Employee emp = new Employee();
        emp.setFirstName("Naresh");
        emp.setLastName("Shrestha");
        emp.setTitle("Manager");
        emp.setAddress("Denver, CO");
        emp.setPhoneNumber("720-720-7207");
        emp.setScheduleTime("10:am");
		
        //Get session
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
	}

	@After
	public void closeSessionFactory() {
		//terminate session factory, otherwise program won't end
        sessionFactory.close();
	}
}

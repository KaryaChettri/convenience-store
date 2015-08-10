package shrestha.naresh.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import shrestha.naresh.entity.Employee;
import shrestha.naresh.service.EmployeeService;

public class TestSpring {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		EmployeeService service = (EmployeeService) ctx.getBean("storeServiceImpl");
		Employee employee = service.getEmployee(8);
		System.out.println(employee);
	}

}

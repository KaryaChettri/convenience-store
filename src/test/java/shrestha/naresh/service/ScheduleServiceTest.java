package shrestha.naresh.service;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shrestha.naresh.dto.ScheduleDTO;


@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext context=new ClassPathXMLApplicationContext
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:dispatcher-servlet-test.xml" })
public class ScheduleServiceTest {
	
	@Autowired
	ScheduleService scheduleService;

	@SuppressWarnings("deprecation")
	@Ignore
	@Test
	public void test() {
		
		ScheduleDTO scheduleDTO = scheduleService.createScheduleDTO();
		System.out.println(scheduleDTO);
		for (Map<String, String> map : scheduleDTO.getListDateColorMap()) {
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (entry.getKey().equals("1;1")) {
					Assert.assertEquals("YELLOW", entry.getValue());
				}
			}
		}
		
		Assert.assertNotNull(scheduleDTO.toString(), scheduleDTO);
		
	}

}

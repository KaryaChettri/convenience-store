package shrestha.naresh.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import shrestha.naresh.service.ScheduleService;

@Controller
public class ScheduleController {
	
	private static Logger logger = Logger.getLogger(ScheduleController.class);
	
	@Autowired
	ScheduleService scheduleService;
	
	@ModelAttribute("schedulerModel")
	public List<Map<String, String>> createScheduleDTO() {
		return scheduleService.createScheduleDTO().getListDateColorMap();
	}

	
	@RequestMapping("/scheduler")
	public ModelAndView getSchedule() {
		ModelAndView mv = new ModelAndView("scheduler");
		return mv;
	}
}

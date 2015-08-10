package shrestha.naresh.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shrestha.naresh.dto.SchedulerDTO;
import shrestha.naresh.dto.SchedulerModel;
import shrestha.naresh.entity.Employee;
import shrestha.naresh.service.EmployeeService;
import shrestha.naresh.service.ScheduleService;

@Controller
public class EmployeeController {
	
	private static Logger logger = Logger.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ScheduleService scheduleService;
	
	@ModelAttribute("schedulerModel")
	public SchedulerModel createSchedulerModel() {
		List<Employee> employeelist = employeeService.listEmployees();
		SchedulerModel schedulerModel = new SchedulerModel();
		List<SchedulerDTO> schedulerDTOs = new ArrayList<SchedulerDTO>();
		for (Employee emp : employeelist) {
			SchedulerDTO schedulerDTO = new SchedulerDTO();
			schedulerDTO.setEmpId(Integer.valueOf(emp.getId()).toString());
			schedulerDTO.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
			schedulerDTOs.add(schedulerDTO);
		}
		schedulerModel.setSchedulerDTOs(schedulerDTOs);
		return schedulerModel;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Employee> employeelist = employeeService.listEmployees();
		model.addAttribute("employeelist", employeelist);
		logger.debug("from own controler mv: "+ employeelist);
		return "employeeList";
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public ModelAndView scheduleTime(@RequestParam String mm,
			@RequestParam String yyyy,
			@RequestParam String dd) {
		String date = mm+"/"+dd+"/"+yyyy;
		System.out.println("date(mm/dd/yyyy): "+mm+"/"+dd+"/"+yyyy);
		ModelAndView mv = new ModelAndView("timeScheduler");
		List<Employee> employeelist = employeeService.listEmployees();
		SchedulerModel schedulerModel = new SchedulerModel();
		List<SchedulerDTO> schedulerDTOs = new ArrayList<SchedulerDTO>();
		for (Employee emp : employeelist) {
			SchedulerDTO schedulerDTO = new SchedulerDTO();
			schedulerDTO.setEmpId(Integer.valueOf(emp.getId()).toString());
			schedulerDTO.setEmployeeName(emp.getFirstName() + " " + emp.getLastName());
			scheduleService.setStartAndEndTime(emp.getId(), date, schedulerDTO);
			schedulerDTOs.add(schedulerDTO);
		}
		schedulerModel.setSchedulerDTOs(schedulerDTOs);
		schedulerModel.setDisplayDate(date);
		mv.addObject("schedulerModel", schedulerModel);
		return mv;
	}
	
	@RequestMapping(value = "/saveSchedule", method = RequestMethod.POST)
	public String saveSchedule(@ModelAttribute("schedulerModel") SchedulerModel schedulerModel) {
		//System.out.println("#########################"+ schedulerModel.getDisplayDate() + "######################");
		List<SchedulerDTO> schedulerDTOs = schedulerModel.getSchedulerDTOs();
		for (SchedulerDTO schedulerDTO : schedulerDTOs) {
			scheduleService.saveSchedule(schedulerDTO, schedulerModel.getDisplayDate());
		}
		return "redirect:scheduler";
	}

	@RequestMapping("/add")
	public ModelAndView getEmployeeForm() {
		System.out.println("inside add emp");
		return new ModelAndView("addEmployee", "command", new Employee());
	}

	@RequestMapping(value = "/insertEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee,
			BindingResult result) {
		System.out.println("Inside insert emp = " + employee);
		Employee emp = new Employee();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setAddress(employee.getAddress());
		emp.setTitle(employee.getTitle());
		emp.setPhoneNumber(employee.getPhoneNumber());
		employeeService.addEmployee(emp);
		return "redirect:list";
	}
	@RequestMapping(value = "/insertSchedule", method = RequestMethod.POST)
	public String addSchedule(@ModelAttribute("employee") Employee employee,
			BindingResult result) {
		System.out.println("Inside insert emp = " + employee);
		Employee emp = new Employee();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setScheduleTime(employee.getScheduleTime());
		return "redirect:scheduler";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployeeForm(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("edit-employee-form");
		Employee employee = employeeService.getEmployee(id);
		mv.addObject("employee", employee);
		return mv;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute Employee employee,
			@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView("home");
		employeeService.updateEmployee(employee);
		String message = "Employee was successfully edited.";
		mv.addObject("message", message);
		return mv;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/list";
	}

}




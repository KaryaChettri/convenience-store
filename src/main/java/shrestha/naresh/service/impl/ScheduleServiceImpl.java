package shrestha.naresh.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shrestha.naresh.dao.ScheduleDao;
import shrestha.naresh.dto.ScheduleDTO;
import shrestha.naresh.dto.SchedulerDTO;
import shrestha.naresh.entity.Employee;
import shrestha.naresh.entity.Schedule;
import shrestha.naresh.service.EmployeeService;
import shrestha.naresh.service.ScheduleService;
import shrestha.naresh.util.SchedulerUtil;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	private static Logger logger = Logger.getLogger(ScheduleServiceImpl.class);
	
	private enum COLOR {
		RED, GREEN, YELLOW
	}
	
	@Autowired
    private ScheduleDao scheduleDao;
	
	@Autowired
	EmployeeService employeeService;

    @Transactional
    public void saveSchedule(SchedulerDTO schedulerDTO, String displayDate) {
    	String empId = schedulerDTO.getEmpId();
		int eID = Integer.parseInt(empId);
		Employee emp = employeeService.getEmployee(eID);
		Date scheduledDate = SchedulerUtil.convertStringToDate(displayDate);
		Schedule schedule =  scheduleDao.getScheduleByEmpIdAndDate(eID, scheduledDate);
		if (schedule == null) {
			schedule = new Schedule();
		}
		schedule.setEmployee(emp);
		schedule.setStartTime(schedulerDTO.getStartTime());
		schedule.setEndTime(schedulerDTO.getEndTime());
		schedule.setScheduledDate(scheduledDate);
    	scheduleDao.saveSchedule(schedule);
    }

    @Transactional( readOnly = true)
    public List<Schedule> listSchedules() {
           return scheduleDao.listSchedules();
    }

    @Transactional( readOnly = true)
    public Schedule getSchedule(int id) {
           return scheduleDao.getSchedule(id);
    }

    @Transactional
    public void deleteSchedule(int id) {
    	scheduleDao.deleteSchedule(id);

    }

	@Override
	@Transactional(readOnly = true)
	public ScheduleDTO createScheduleDTO() {
		return getScheduleDTO();
	}
	
	
	private int getDayOfMonth(Date date) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date);
		return cal1.get(cal1.DAY_OF_MONTH);
	}
	
	private Date getDate(Calendar cal, int dayOfMonth) {
		cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return cal.getTime();
	}

	
	public ScheduleDTO getScheduleDTO() {
		ScheduleDTO scheduleDTO = new ScheduleDTO();
		Calendar cal0 = Calendar.getInstance();
		scheduleDTO.setCurrentMonth(cal0.MONTH);
		scheduleDTO.setCurrentYear(cal0.YEAR);
		List<Map<String, String>> listDateColorMap = new ArrayList<Map<String, String>>();
		int noOfMonthsInAYear = 12;
		Map<String, Long> completeScheduledDaysMap = new HashMap<String, Long>();
		for (int j = 0; j < noOfMonthsInAYear; j++) {
			Map<String, String> dateColorMap = new HashMap<String, String>();
			StringBuffer sb = new StringBuffer();
			sb.append(String.valueOf(j+1));
			sb.append(";");
			Calendar cal = Calendar.getInstance();
			cal.set(2015, j, 1);
			int noOfDays = cal.getActualMaximum(cal.DAY_OF_MONTH);
			Date startOfMonth = getDate(cal, cal.getActualMinimum(cal.DAY_OF_MONTH)), endOfMonth = getDate(cal, noOfDays);
			List<Schedule> schedules = scheduleDao.getScheduleForMonth(startOfMonth, endOfMonth);
			if (schedules != null) {
				for (Schedule schedule : schedules) {
					int dayOfMonth = getDayOfMonth(schedule.getScheduledDate());
					String day = sb.toString() + String.valueOf(dayOfMonth);
					String startTime = schedule.getStartTime().split(":")[0];
					String endTime = schedule.getEndTime().split(":")[0];
					Long totalHours = Long.valueOf(endTime) - Long.valueOf(startTime);
					if (completeScheduledDaysMap.get(day) != null) {
						totalHours += completeScheduledDaysMap.get(day);
					}
					completeScheduledDaysMap.put(day, totalHours);
				}
				for (int i = 1; i <= noOfDays; i++) {
					String monthDay = sb.toString() + String.valueOf(i);
					if (completeScheduledDaysMap.get(monthDay) != null) {
						if (completeScheduledDaysMap.get(monthDay) < 12L) {
							dateColorMap.put(monthDay, COLOR.YELLOW.name());
						}else {
							dateColorMap.put(monthDay, COLOR.GREEN.name());
						}
					} else {
						dateColorMap.put(monthDay, COLOR.RED.name());
					}
					listDateColorMap.add(dateColorMap);
				}
				scheduleDTO.setListDateColorMap(listDateColorMap);
			}
		}
		logger.debug("from own controler mv: "+ scheduleDTO);
		return scheduleDTO;
	}

	@Override
	@Transactional( readOnly = true)
	public void setStartAndEndTime(int empId, String date, SchedulerDTO schedulerDTO) {
		Date scheduledDate = SchedulerUtil.convertStringToDate(date);
		Schedule schedule = scheduleDao.getScheduleByEmpIdAndDate(empId, scheduledDate);
		if (schedule != null) {
			schedulerDTO.setStartTime(schedule.getStartTime());
			schedulerDTO.setEndTime(schedule.getEndTime());
		}
	}
	
}

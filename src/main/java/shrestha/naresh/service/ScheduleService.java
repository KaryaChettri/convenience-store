package shrestha.naresh.service;

import java.util.List;

import shrestha.naresh.dto.ScheduleDTO;
import shrestha.naresh.dto.SchedulerDTO;
import shrestha.naresh.entity.Schedule;

public interface ScheduleService {
	//Create and Update Schedule
	public void saveSchedule(SchedulerDTO schedulerDTO, String displayDate);

	//Read Schedule
	public List<Schedule> listSchedules();
	public Schedule getSchedule(int id);

	//Delete Schedule
	public void deleteSchedule(int id);

	ScheduleDTO createScheduleDTO();

	void setStartAndEndTime(int empId, String date, SchedulerDTO schedulerDTO);
}

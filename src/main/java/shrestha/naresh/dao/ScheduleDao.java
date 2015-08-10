package shrestha.naresh.dao;

import java.util.Date;
import java.util.List;

import shrestha.naresh.entity.Schedule;

public interface ScheduleDao {

	//Create and Update Schedule
		public void saveSchedule(Schedule schedule);
		
		//Read Schedule
		public List<Schedule> listSchedules();
		public Schedule getSchedule(int id);
		
		//Delete Schedule
		public void deleteSchedule(int id);
		
		List<Schedule> getScheduleForMonth(Date startOfMonth, Date endOfMonth);
		
		Schedule getScheduleByEmpIdAndDate(int empId, Date scheduledDate);

}

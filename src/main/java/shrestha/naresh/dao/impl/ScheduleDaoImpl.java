package shrestha.naresh.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import shrestha.naresh.dao.ScheduleDao;
import shrestha.naresh.entity.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {
	
	
		@Autowired
		private SessionFactory sessionFactory;
		 public void saveSchedule(Schedule schedule) {
	         
	         getSession().merge(schedule);
	  }

	  @SuppressWarnings("unchecked")
	public List<Schedule> listSchedules() {

	         return getSession().createCriteria(Schedule.class).list();
	  }

	  public Schedule getSchedule(int id) {
	         return (Schedule) getSession().get(Schedule.class, id);
	  }

	  public void deleteSchedule(int id) {

		  Schedule schedule = getSchedule(id);

	         if (null != schedule) {
	                getSession().delete(schedule);
	         }
	  }

	  private Session getSession() {
	         Session sess = getSessionFactory().getCurrentSession();
	         if (sess == null) {
	                sess = getSessionFactory().openSession();
	         }
	         return sess;
	  }

	  private SessionFactory getSessionFactory() {
	         return sessionFactory;
	  }

	@Override
	public List<Schedule> getScheduleForMonth(Date startOfMonth, Date endOfMonth) {
		Query query = getSession().getNamedQuery("findSchedulesByStartAndEndOfMonth")
				.setDate("startOfMonth", startOfMonth)
				.setDate("endOfMonth", endOfMonth);
		List<Schedule> schedules = (List<Schedule>)query.list();
		return schedules;
	}

	@Override
	public Schedule getScheduleByEmpIdAndDate(int empId, Date scheduledDate) {
		Query query = getSession().getNamedQuery("findSchedulesByEmpIdAndDate")
				.setInteger("empId", empId)
				.setDate("scheduledDate", scheduledDate);
		List<Schedule> schedules = (List<Schedule>)query.list();
		return (schedules != null && !schedules.isEmpty()) ? schedules.get(0) : null;
	}
}

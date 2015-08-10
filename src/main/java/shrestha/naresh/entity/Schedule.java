package shrestha.naresh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;

@NamedQueries({
	@NamedQuery(
			name = "findSchedulesByStartAndEndOfMonth",
			query = "from Schedule s where s.scheduledDate between :startOfMonth and :endOfMonth order by s.scheduledDate asc"
	),
	@NamedQuery(
			name = "findSchedulesByEmpIdAndDate",
			query = "from Schedule s where s.employee.id =:empId and s.scheduledDate =:scheduledDate"
	)
})
@Entity
@Table(name="Schedule", 
       uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Schedule {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	
	@Column(name="start_time", length=10, nullable=false)
	private String startTime;
	
	@Column(name="end_time", length=10, nullable=false)
	private String endTime;
	
	@Column(name="scheduled_date", length=10, nullable=false)
	@Type(type="date")
	private Date scheduledDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="employee_id", nullable=false)
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", startTime=" + startTime + ", endTime="
				+ endTime + ", scheduledDate=" + scheduledDate + ", employee="
				+ employee + "]";
	}

}
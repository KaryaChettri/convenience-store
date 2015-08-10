package shrestha.naresh.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="Employee", 
       uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Employee {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	
	@Column(name="first_name", length=20, nullable=true)
	private String firstName;
	
	@Column(name="last_name", length=20, nullable=true)
	private String lastName;
	
	@Column(name="job_title", length=20, nullable=true)
	private String title;
	
	@Column(name="address", length=20, nullable=true)
	private String address;
	
	@Column(name="phone", length=20, nullable=true)
	private String phoneNumber;
	
	@Column(name = "schedule_time", length=20, nullable=true)
	private String scheduleTime;
	
	@OneToMany
	@JoinColumn(name="employee_id")
	@Cascade({CascadeType.ALL})
	private List<Schedule> schedules;

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", title=" + title + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", scheduleTime=" + scheduleTime + "]";
	}
	
}

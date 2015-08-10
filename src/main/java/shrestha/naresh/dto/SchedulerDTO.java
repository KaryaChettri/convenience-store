package shrestha.naresh.dto;



public class SchedulerDTO {

	private String employeeName;
	private String empId;
	private String startTime;
	private String endTime;
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
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
	
	@Override
	public String toString() {
		return "SchedulerDTO [employeeName=" + employeeName + ", empId="
				+ empId + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
	
}

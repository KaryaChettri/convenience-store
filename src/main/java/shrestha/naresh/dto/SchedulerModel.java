package shrestha.naresh.dto;

import java.util.List;

public class SchedulerModel {

	List<SchedulerDTO> schedulerDTOs;
	private String displayDate;

	public List<SchedulerDTO> getSchedulerDTOs() {
		return schedulerDTOs;
	}

	public void setSchedulerDTOs(List<SchedulerDTO> schedulerDTOs) {
		this.schedulerDTOs = schedulerDTOs;
	}
	
	public String getDisplayDate() {
		return displayDate;
	}
	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	@Override
	public String toString() {
		return "SchedulerModel [schedulerDTOs=" + schedulerDTOs
				+ ", displayDate=" + displayDate + "]";
	}
	
}

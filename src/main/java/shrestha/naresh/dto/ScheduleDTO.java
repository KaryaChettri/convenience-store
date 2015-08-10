package shrestha.naresh.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScheduleDTO {

	private Map<String, String> dateColorMap = new HashMap<String, String>();
	private List<Map<String, String>> listDateColorMap = new ArrayList<Map<String, String>>();
	private int currentMonth;
	private int currentYear;

	public Map<String, String> getDateColorMap() {
		return dateColorMap;
	}

	public void setDateColorMap(Map<String, String> dateColorMap) {
		this.dateColorMap = dateColorMap;
	}

	public List<Map<String, String>> getListDateColorMap() {
		return listDateColorMap;
	}

	public void setListDateColorMap(List<Map<String, String>> listDateColorMap) {
		this.listDateColorMap = listDateColorMap;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	@Override
	public String toString() {
		return "ScheduleDTO [dateColorMap=" + dateColorMap
				+ ", listDateColorMap=" + listDateColorMap + ", currentMonth="
				+ currentMonth + ", currentYear=" + currentYear + "]";
	}
	
}

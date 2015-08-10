package shrestha.naresh.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

import shrestha.naresh.service.ScheduleService;

public final class SchedulerUtil {
	
	public static Date convertStringToDate(final String stringDate){
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date date = null;
		try {
			date = df.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return date;
	}
	
	public final static Calendar zeroOutTime(Calendar cal) {
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

}

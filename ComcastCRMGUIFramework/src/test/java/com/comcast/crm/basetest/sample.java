package com.comcast.crm.basetest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class sample {

	public static void main(String[] args) {
		Date dateobj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		sdf.format(dateobj);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,31);
		String reqDate= sdf.format(cal.getTime());
		System.out.println(reqDate); 
		}
}

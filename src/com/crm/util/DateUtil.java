/**
 * 
 */
package com.crm.util;

import java.util.Date;

/**
 * @author lenovo
 * 
 */
public class DateUtil {
    @SuppressWarnings("deprecation")
    public static Date toDateFormat(String strDate) {
	String[] dates = strDate.split("/");
	if (dates.length == 3) {
	    try {
		int month = Integer.parseInt(dates[0]);
		int day = Integer.parseInt(dates[1]);
		int year = Integer.parseInt(dates[2]);

		Date date = new Date();
		date.setYear(year - 1900);
		date.setMonth(month - 1);
		date.setDate(day);

		return date;
	    } catch (NumberFormatException nfe) {
		return null;
	    }

	} else {
	    return null;
	}
    }
}

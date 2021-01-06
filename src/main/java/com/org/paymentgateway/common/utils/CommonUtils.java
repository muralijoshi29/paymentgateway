/**
 * 
 */
package com.org.paymentgateway.common.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;



/**
 * @author 7000018390
 *
 */
public class CommonUtils {
	

	CommonUtils() {
		
	}
	
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	public static Date convertStringToDate(String strDate) {
		DateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		try {
			return format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date convertStringToDate(String strDate, String inFormat) {
		DateFormat format = new SimpleDateFormat(inFormat);
		try {
			return format.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String formatDateStr(String strDate, String inFormat, String outFormat) {
		Date dt = convertStringToDate(strDate,inFormat);
		return convertDateToString(dt,outFormat);
	}
	
	public static String convertMonthAndYearAsString(Date getDate,String format) {
		Format formatter = new SimpleDateFormat(format);
		return formatter.format(getDate);
		
	}
	
	public static String convertDateToString(Date date, String outFormat) {
		DateFormat format;
		if(outFormat!=null) {
			format = new SimpleDateFormat(outFormat);
		}else {
			format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		}
		try {
			return format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String convertDateToString(Date date) {
		DateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		try {
			return format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isEmpty(String str) {
		boolean isEmpty = false;
		if (str == null || str.trim().equals("") || str.isEmpty()) {
			isEmpty =  true;
		} else {
			isEmpty =  false;
		}
		return isEmpty;
	}
	
	public static <T> boolean isEmpty(List<T> list) {
		boolean isEmptyLst = false;
		if (list == null || list.isEmpty()) {
			isEmptyLst = true;
		} else {
			isEmptyLst =  false;
		}
		return isEmptyLst;
	}

	/**
	 * @param values
	 * @return
	 */
	public static <T> String buildCommaSeparatedString(T[] values) {
		StringBuilder sb = new StringBuilder();
		for (T n : values) {
			if (sb.length() > 0)
				sb.append(',');
			sb.append("'").append(n).append("'");
		}

		return sb.toString();
	}
	
	public static List<String> buildListFromString(String list) {
		return buildListFromString(list,null);
	}
	
	public static List<String> buildListFromString(String list, String delimeter) {
		if(isEmpty(delimeter)) {
			delimeter = ",";
		}
		if(isEmpty(list)) {
			return new ArrayList<>();
		}
		return Arrays.asList(list.split("\\s*"+delimeter+"\\s*"));
	}
	public static Date addDays(Date date, Integer numberOfDays) {
		if(null == date) {
			new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, numberOfDays); 
		return cal.getTime();
	}
	
	public static String[] buildStringArrayFromList(List<String> list) {
		if(isEmpty(list)) {
			return new String[] {};
		}else {
			return list.stream().toArray(String[]::new);
		}
	}
}

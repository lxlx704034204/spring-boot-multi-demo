package org.springboot.module.self;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {
	public final static String YYYY_MM_DD_HH_MM_DD = "yyyy-MM-dd HH:mm:ss";
	
	private DateUtils() {
		
	}
	public final static String TZ_CN ="Asia/Shanghai";
	public final static String US_CN ="America/New_York";
	
	public static TimeZone getCNTZ() {
		TimeZone tz = TimeZone.getTimeZone(TZ_CN);
		return tz;
	}
	public static TimeZone getUSTZ() {
		TimeZone tz = TimeZone.getTimeZone(US_CN);
		return tz;
	}
	
	public static String getCnDateTime(Date date, String pattern) {
		if(date == null)return null;
		Locale locale =new Locale("zh","CN"); 
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		sdf.setTimeZone(getCNTZ());
		return sdf.format(date);
	};
	
	public static String getUsDateTime(Date date, String pattern) {
		if(date == null)return null;
		Locale locale =new Locale("en","US"); 
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
		sdf.setTimeZone(getUSTZ());
		return sdf.format(date);
	};

}

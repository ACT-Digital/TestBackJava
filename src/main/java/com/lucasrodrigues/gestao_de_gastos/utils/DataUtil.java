package com.lucasrodrigues.gestao_de_gastos.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataUtil {

	private static SimpleDateFormat sdf;
	public static String DDMMYYY = "dd/MM/yyyy";
	public static String UTC = "yyyy-MM-dd'T'HH:mm:ss 'Z'";
	
	public static Date convert(String str, String format) {
		sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String format(Date date, String format) {
		sdf = new SimpleDateFormat(format);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		return sdf.format(date);
	}
}

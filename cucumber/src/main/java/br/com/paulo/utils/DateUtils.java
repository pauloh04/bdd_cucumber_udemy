package br.com.paulo.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static Date obterDiferencaDias(int dias) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, dias);
		return cal.getTime();
	}
}

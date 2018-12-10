/**
 * 
 */
package com.hungit.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kashiwagi
 *
 */
public class NumberUtil {

	public static boolean isNumber(String number) {

		String pattern = "\\d+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(number);

		return m.matches();
	}

	public static long parseLong(String number) {
		return Long.parseLong(number);
	}

}

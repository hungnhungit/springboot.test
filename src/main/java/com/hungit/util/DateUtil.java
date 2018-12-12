/**
 * 
 */
package com.hungit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kashiwagi
 *
 */
public final class DateUtil {
	public static String getDateFormat() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String strDate = sdf.format(now);
		return strDate;

	}
}

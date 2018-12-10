/**
 * 
 */
package com.hungit.util;

/**
 * @author Kashiwagi
 *
 */
public class StringUtil {
	public static boolean isEmpty(String name) {
		if(name != "" && name.length() > 0) {
			return false;
		}
		return true;
		
	}
	
	public static boolean isNull(Object object) {
		if(object == null) {
			return true;
		}
		return false;
		
	}
	
}

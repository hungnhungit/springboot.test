/**
 * 
 */
package com.hungit.util;

import java.util.*;

/**
 * @author Kashiwagi
 *
 */
public class ArrayUtil {
	public static <T> HashSet<T> asArrayList(T... values) {
		return new HashSet<T>(Arrays.asList(values));
	}
}

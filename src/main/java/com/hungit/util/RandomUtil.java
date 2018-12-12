/**
 * 
 */
package com.hungit.util;

import java.util.UUID;

/**
 * @author Kashiwagi
 *
 */
public final class RandomUtil {
	public static String getRandomStr() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}

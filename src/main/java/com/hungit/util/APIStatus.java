/**
 * 
 */
package com.hungit.util;

/**
 * @author Kashiwagi
 *
 */
public enum APIStatus {
	OK(200, null);

	private final int code;
	private final String description;

	private APIStatus(int s, String v) {
		code = s;
		description = v;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}

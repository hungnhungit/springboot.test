/**
 * 
 */
package com.hungit.service;

/**
 * @author Kashiwagi
 *
 */
public interface AuthService {

	String findLoggedInUsername();

	void autologin(String username, String password);
}

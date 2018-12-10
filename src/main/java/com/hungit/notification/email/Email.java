/**
 * 
 */
package com.hungit.notification.email;


import java.util.Set;
/**
 * @author Kashiwagi
 *
 */


public interface Email {

	String getFromAddress();
	
	Set<String> getToAddresses();
	
	Set<String> getCcAddresses();
	
	Set<String> getBccAddresses();
	
	Set<String> getAttachments();
	
	String getSubject();
	
	String getBody();
}
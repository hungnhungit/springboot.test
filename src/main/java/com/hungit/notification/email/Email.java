/**
 * 
 */
package com.hungit.notification.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Kashiwagi
 *
 */

@Getter
@Setter
@AllArgsConstructor
public class Email {

	private String to;
	private String subject;
	private String text;

}
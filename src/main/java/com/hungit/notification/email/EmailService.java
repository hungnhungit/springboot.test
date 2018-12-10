/**
 * 
 */
package com.hungit.notification.email;

import org.springframework.mail.SimpleMailMessage;

/**
 * @author Kashiwagi
 *
 */
public interface EmailService {
	void sendSimpleMessage(Email email);

	void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template, String... templateArgs);

	void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);
}

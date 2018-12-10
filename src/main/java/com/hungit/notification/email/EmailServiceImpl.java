/**
 * 
 */
package com.hungit.notification.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Kashiwagi
 *
 */
@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(Email mail) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mail.getTo());
			message.setSubject(mail.getSubject());
			message.setText(mail.getText());

			emailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}
	}

//	@Override
//	public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template,
//			String... templateArgs) {
//		String text = String.format(template.getText(), templateArgs);
//		sendSimpleMessage(to, subject, text);
//	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			// pass 'true' to the constructor to create a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);

			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment("Invoice", file);

			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.hungit.notification.email.EmailService#sendSimpleMessageUsingTemplate(java.lang.String, java.lang.String, org.springframework.mail.SimpleMailMessage, java.lang.String[])
	 */
	@Override
	public void sendSimpleMessageUsingTemplate(String to, String subject, SimpleMailMessage template,
			String... templateArgs) {
		// TODO Auto-generated method stub
		
	}
}
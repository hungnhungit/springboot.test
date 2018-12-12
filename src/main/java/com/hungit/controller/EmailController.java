/**
 * 
 */
package com.hungit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungit.notification.email.Email;
import com.hungit.notification.email.EmailService;

/**
 * @author Kashiwagi
 *
 */
@Controller
public class EmailController {

	@Autowired
	EmailService emailService;

	@RequestMapping(value = { "/sendmail" })
	@ResponseBody
	public String sendMail() {
		Email email = new Email("hungnhungit123@gmail.com", "toi la hung", "toi la hung");
		emailService.sendSimpleMessage(email);
		return "done";

	}

}

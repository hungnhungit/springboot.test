/**
 * 
 */
package com.hungit.facebook;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

import com.hungit.entity.User;
import com.hungit.repository.UserRepository;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String execute(Connection<?> connection) {
		System.out.println("signup === ");
		final User user = new User();
		user.setUsername(connection.getDisplayName());
		user.setPassword(randomAlphabetic(8));
		userRepository.save(user);
		return user.getUsername();
	}

}
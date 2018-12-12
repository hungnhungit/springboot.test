/**
 * 
 */
package com.hungit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;

/**
 * @author Kashiwagi
 *
 */
@Configuration
public class SocialConfiguration {

	private static boolean securityEnabled = isSocialSecurityAvailable();

//	@Bean
//	public ConnectionFactoryLocator connectionFactoryLocator() {
//		if (securityEnabled) {
//			SecurityEnabledConnectionFactoryConfigurer cfConfig = new SecurityEnabledConnectionFactoryConfigurer();
//			for (SocialConfigurer socialConfigurer : socialConfigurers) {
//				socialConfigurer.addConnectionFactories(cfConfig, environment);
//			}
//			return cfConfig.getConnectionFactoryLocator();
//		} else {
//			DefaultConnectionFactoryConfigurer cfConfig = new DefaultConnectionFactoryConfigurer();
//			for (SocialConfigurer socialConfigurer : socialConfigurers) {
//				socialConfigurer.addConnectionFactories(cfConfig, environment);
//			}
//			return cfConfig.getConnectionFactoryLocator();
//		}
//	}

	private static boolean isSocialSecurityAvailable() {
		try {
			Class.forName("org.springframework.social.security.SocialAuthenticationServiceLocator");
			return true;
		} catch (ClassNotFoundException cnfe) {
			return false;
		}
	}

}

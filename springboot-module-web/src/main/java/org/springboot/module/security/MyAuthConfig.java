package org.springboot.module.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

@Configuration
public class MyAuthConfig {
	
	@Bean
	public RequestHeaderAuthenticationFilter siteminderFilter() {
		RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
		filter.setPrincipalRequestHeader("SM_USER");
		AuthenticationManager authenticationManager= new AuthenticationManager() {
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		filter.setAuthenticationManager(authenticationManager);
		return filter;
	}
	
	@SuppressWarnings("rawtypes")
	@Bean
	public PreAuthenticatedAuthenticationProvider preauthAuthProvider() {
		PreAuthenticatedAuthenticationProvider preauthAuthProvider = new PreAuthenticatedAuthenticationProvider();
		UserDetailsByNameServiceWrapper uds = new UserDetailsByNameServiceWrapper<>();
		UserDetailsService aUserDetailsService = new UserDetailsService() {	
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		uds.setUserDetailsService(aUserDetailsService);
		
		preauthAuthProvider.setPreAuthenticatedUserDetailsService(uds);
		return preauthAuthProvider;
	}

}

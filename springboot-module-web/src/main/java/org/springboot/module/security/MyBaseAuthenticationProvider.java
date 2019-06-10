package org.springboot.module.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class MyBaseAuthenticationProvider implements AuthenticationProvider {

	private UserDetailsService userDetailsService;

	public MyBaseAuthenticationProvider() {
		System.out.println("### MyBaseAuthenticationProvider.MyBaseAuthenticationProvider()");
		this.userDetailsService = new MyBaseUserService();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("### MyBaseAuthenticationProvider.authenticate()");
		String username = (String) authentication.getPrincipal();
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
		if (!(userDetails instanceof MybaseUser)) {
			return null;
		}
		MybaseUser user = (MybaseUser) userDetails;
		if (user.getUsername() != null) {
			return new MyBaseAuthentication(user.getUsername(),user.getPassword());
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.getName().equals(MyBaseAuthentication.class.getName());
	}

}

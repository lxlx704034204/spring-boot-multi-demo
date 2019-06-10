package org.springboot.module.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyBaseAuthenticationManager implements AuthenticationManager{
	
	private AuthenticationProvider provider;
	
	public MyBaseAuthenticationManager() {
		System.out.println("### MyBaseAuthenticationManager.MyBaseAuthenticationManager()");
		this.provider = new MyBaseAuthenticationProvider();
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("### MyBaseAuthenticationManager.authenticate()");
		return provider.authenticate(authentication);
	}

}

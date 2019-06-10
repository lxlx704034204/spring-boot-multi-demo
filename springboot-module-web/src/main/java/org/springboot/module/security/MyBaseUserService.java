package org.springboot.module.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyBaseUserService implements UserDetailsService {
	
	public MyBaseUserService() {
		System.out.println("### MyBaseUserService.MyBaseUserService()");
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("### MyBaseUserService.loadUserByUsername(): " + username);
		MybaseUser user = new MybaseUser();
		if ("cch".equals(username)) {
			user.setUsername("cch");
			user.setPassword("123456");
		}
		return user;
	}

}

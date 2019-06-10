package org.springboot.module.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//@Component
public class MyBaseFilter extends AbstractAuthenticationProcessingFilter {
	public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
	public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
	
	
	public MyBaseFilter() {
		 super(new AntPathRequestMatcher("/login","POST"));
		 System.out.println("### MyBaseFilter.MyBaseFilter()");
		 authenticationManager = new MyBaseAuthenticationManager();
		 //super.setAuthenticationManager(authenticationManager);
	}
	
	private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
	private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;
	
	private AuthenticationManager authenticationManager;
	
	public AuthenticationManager getAuthenticationManager() {
		return authenticationManager;
	}
	
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		System.out.println("### MyBaseFilter.doFilter()");
//		chain.doFilter(req,res); 
//	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		System.out.println("### MyBaseFilter.attemptAuthentication()");


		String username = request.getParameter(usernameParameter);
		String password = request.getParameter(passwordParameter);
		
		System.out.println("userName: " + username);
		System.out.println("password: " + password);
		
		//UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		MyBaseAuthentication authRequest = new MyBaseAuthentication(username, password);
		Authentication authenticate = this.getAuthenticationManager().authenticate(authRequest);
		System.out.println("authenticate is not null: " + authenticate != null);
		return authenticate;
	}

	private boolean flag;
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean getFlag() {
		return flag;
	}
}

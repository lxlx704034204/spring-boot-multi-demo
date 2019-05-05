package org.springboot.module.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service("authenticationFailHandler")
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// this.returnJson(response, exception);
		log.error("### user not authrized.");
		super.onAuthenticationFailure(request, response, exception);
		//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
		//response.sendRedirect("/login");
	}

	protected void returnJson(HttpServletResponse response, AuthenticationException exception) throws IOException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().println("{\"exceptionId\":\"null\",\"messageCode\":\"401\"," + "\"message\": \""
				+ exception.getMessage() + "\",\"serverTime\": " + System.currentTimeMillis() + "}");
	}
}

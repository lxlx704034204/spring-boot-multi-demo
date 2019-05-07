package org.springboot.module.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法级别的权限认证
public class WebSecuerityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationSuccessHandler")
	private AuthenticationSuccessHandler successHandler;

	@Autowired
	@Qualifier("authenticationFailHandler")
	private AuthenticationFailureHandler failHandler;

	@Autowired
	@Qualifier("authenticationEntryPointImpl")
	private AuthenticationEntryPoint entryPoint;

	// @Autowired
	// private IUserService userService;

	/**
	 * 重写该方法，设定用户访问权限
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().and()
				.httpBasic();
		
//		super.configure(http);

		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		// http.cors().and().csrf().disable();// 关闭csrf
//				.authorizeRequests()
//				.antMatchers("/orders/**").hasRole("USER")    //用户权限
//			    .antMatchers("/users/**").hasRole("ADMIN")    //管理员权限
//			    .antMatchers("/").permitAll()// 不需要限制的用permitAll()放行即可
//				.antMatchers("/login").permitAll()
//				.anyRequest().authenticated()// 其他所有请求均需要认证
//				
//				.and().formLogin()
//				//.loginPage("/login_page.html")//跳转登录页面
//				.loginPage("/login")//跳转登录页面
//			    .permitAll()
//				//.and().formLogin().loginPage("/api/user/login")
//				//.loginProcessingUrl("/api/user/login")// 配置登录
//				//.successHandler(successHandler)// 配置登录成功时的处理
//				//.failureHandler(failHandler)// 配置登录失败时的处理
//				
//				.and().logout().permitAll()
//				.and().exceptionHandling().authenticationEntryPoint(entryPoint);// 配置异常处理（没有登录就请求资源时）
	}

	/**
	 * 重写该方法，添加自定义用户
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// type 1 simply use memory authentication
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication().passwordEncoder(bCryptEncoder).withUser("admin")
				.password(bCryptEncoder.encode("admin")).roles("ADMIN").and().withUser("cch")
				.password(bCryptEncoder.encode("123456")).roles("USER");

		// type 2 use database authentication
		// auth.userDetailsService(userService).passwordEncoder(new
		// BCryptPasswordEncoder());
	}

	/**
	 * 配置CORS it not work well
	 * 
	 * @return
	 */
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("POST", "GET"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("http://localhost:3000");
//		config.addAllowedHeader(CorsConfiguration.ALL);
//		config.addAllowedMethod(CorsConfiguration.ALL);
//		source.registerCorsConfiguration("/**", config);
//		CorsFilter corsFilter = new CorsFilter(source);
//		return corsFilter;
//	}

	/**
	 * 配置CORS it can work
	 * 
	 * @return
	 */
	// @Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");
		source.registerCorsConfiguration("/**", config); // CORS 配置对所有接口都有效
		return new CorsFilter(source);
	}
}

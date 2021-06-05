package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	static String AUTH_GV = "ROLE_GV";
	static String AUTH_SV= "ROLE_SV";
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomAuthenticationSuccessHandler();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).
		passwordEncoder(passwordEncoder());

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
		.ignoring()
		.antMatchers("/resources/**", "/static/**","/vendor/**","/fonts/**", "/css/**", "/js/**", "/images/**", "/icon/**","/error");
	}


	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(900);
		http
		.authorizeRequests()
	//	.antMatchers("/**").permitAll()
			.antMatchers("/","/login").permitAll()
			.antMatchers("/lichhoc").hasAuthority(AUTH_SV)
			.antMatchers("/bangdiem").hasAuthority(AUTH_SV)
			.and()
		.formLogin()
		.loginProcessingUrl("/j_spring_security_login")
		.loginPage("/login")
		.successHandler(authenticationSuccessHandler())
		.failureHandler(authenticationFailureHandler())
		.usernameParameter("tentaikhoan")
		.passwordParameter("matkhau")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/j_spring_security_logout")
		.logoutSuccessUrl("/login").invalidateHttpSession(true)
		.deleteCookies("remember-me","JSESSIONID")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/401")
		;
	}
}

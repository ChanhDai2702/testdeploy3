package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.model.TaiKhoan;
import com.example.demo.service.TaiKhoanService;



@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler 
										implements AuthenticationSuccessHandler{
	static String RETURN_HOME = "/dkLHPChoSV";
	static String RETURN_DASHBOARD="/dashboard";
	static String AUTH_ADMIN = "ROLE_ADMIN";
	@Autowired
	private TaiKhoanService taiKhoanService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
        String redirectURL = RETURN_HOME;
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(AUTH_ADMIN))) {
        	redirectURL = RETURN_DASHBOARD;
        }
		super.setDefaultTargetUrl(redirectURL);
        super.onAuthenticationSuccess(request, response, authentication);
	}

}

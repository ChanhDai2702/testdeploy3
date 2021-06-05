package com.example.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import com.example.demo.model.TaiKhoan;
import com.example.demo.service.TaiKhoanService;



@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler{
	static String LOGIN_ERROR = "Đăng nhập thất bại vui lòng thử lại!";
	static String LOCKED_ACCOUNT = "Tài khoản đã bị khóa!";

	
	@Autowired
	private TaiKhoanService taiKhoanService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		TaiKhoan user = taiKhoanService.findByTaiKhoan(request.getParameter("tentaikhoan"));
		String redirectURL = "/login?error";
		exception = new SessionAuthenticationException(LOGIN_ERROR);
		if(user != null) {
			System.out.println(new BCryptPasswordEncoder().matches(request.getParameter("matkhau"),user.getMatkhau()));
		}
		super.setDefaultFailureUrl(redirectURL);
		super.onAuthenticationFailure(request, response, exception);
	}

}

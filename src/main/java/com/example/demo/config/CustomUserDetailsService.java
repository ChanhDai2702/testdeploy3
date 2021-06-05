package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.TaiKhoan;
import com.example.demo.service.TaiKhoanService;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService{
	static String NOT_FIND_USER = "không tìm thấy user";
	static String LOCKED_ACCOUNT = "Tài khoản đã bị khóa!";
	@Autowired
	private TaiKhoanService taiKhoanService;

	@Override
	public UserDetails loadUserByUsername(String tentaikhoan) throws UsernameNotFoundException,ExceptionInInitializerError {
		TaiKhoan user = taiKhoanService.findByTaiKhoan(tentaikhoan);
		if(user == null) {
			throw new UsernameNotFoundException(NOT_FIND_USER);
		}
//		System.out.println(new BCryptPasswordEncoder().matches(param,user.getPasswordHash()));
		
		return new User(String.valueOf(user.getTentaikhoan()), user.getMatkhau(), getAuthorities(user));
	}
	private static Collection<? extends GrantedAuthority> getAuthorities(TaiKhoan user) {
//		String[] userRoles = {user.getRoles().stream().findFirst().get().getName().toString()} ;
//		
//		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
	    
		    authorities.add(new SimpleGrantedAuthority(String.valueOf(user.getPhanloai())));
		
		return authorities;
	}
}

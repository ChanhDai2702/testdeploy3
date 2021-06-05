package com.example.demo.controller.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.TaiKhoanService;

@Controller
public class TaiKhoanWebController {
	static String FORM_LOGIN = "loginPage";
	
	@Autowired
	private TaiKhoanService taiKhoanService;
	
	@GetMapping(value = "/login")
    public String showFormLogin(Principal principal,Model model) {
		return principal!=null? "redirect:/" : FORM_LOGIN;
    }
}

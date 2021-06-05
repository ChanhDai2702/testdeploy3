package com.example.demo.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.ChuyenNganh;
import com.example.demo.model.Khoa;
import com.example.demo.service.ChuyenNganhService;
import com.example.demo.service.KhoaService;

@Controller
public class KhoaControllerWeb {
	@Autowired
	private KhoaService khoaService; 
	@Autowired
	private ChuyenNganhService chuyenNganhService;
	
	@RequestMapping(value = "/QLKhoa",method = RequestMethod.GET)
	public String getAllSVien(Model model) {
		List<Khoa> dssv = khoaService.getAllKhoa();
		model.addAttribute("listkhoa", dssv);
		
		
		return "QLKhoa";
	}
	@RequestMapping(value = "/them",method = RequestMethod.GET)
	public String getAllSVien1(Model model) {
		
		List<Khoa> dssv = khoaService.getAllKhoa();
		Khoa chuyenNganh = new Khoa();
		for(Khoa cn : dssv) {
			if(cn.getMakhoa()==123) {
				chuyenNganh = cn;
			}
		}
		
		model.addAttribute("ds", chuyenNganh);
		return "them";
	}
	@PostMapping(value = "luu")
	public String getAll(Khoa chuyenNganh) {
		System.out.println(chuyenNganh);
		khoaService.editKhoa(chuyenNganh);
		return "redirect:/QLKhoa";
		
	}
}

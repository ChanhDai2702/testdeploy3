package com.example.demo.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.SinhVien;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.ThoiGianHocService;

@Controller
public class LichHocSinhVienControllerWeb {
@Autowired
ThoiGianHocService thoiGianHocService;
@Autowired
SinhVienService sinhVienService;
@RequestMapping(value = "/lichhocsinhvien",method = RequestMethod.GET)
public String getAllSViens1(Model model) {
	SinhVien sv=sinhVienService.getSVbyID(Long.valueOf(17083471));
	model.addAttribute("sv",sv);
	
	return "lichhocsinhvien";
}
}

package com.example.demo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Khoa;
import com.example.demo.model.SinhVien;
import com.example.demo.service.KhoaService;

import lombok.Getter;


@Controller
@RestController
public class KhoaController {
	@Autowired
	private KhoaService khoaService;
	@RequestMapping(value = "/dskhoa",method = RequestMethod.GET)
	public List<Khoa> getAllKhoa(){
		return khoaService.getAllKhoa();
	}
	@RequestMapping(value = "/khoa/add",method = RequestMethod.POST)
	public boolean addKhoa(@RequestBody Khoa k) {
		return khoaService.addKhoa(k);
	}
	@RequestMapping(value = "/khoa/edit",method = RequestMethod.PUT)
	public boolean editKhoa(@RequestBody Khoa k) {
		return khoaService.editKhoa(k);
	}
//	@RequestMapping(value = "QLKhoa")
//	public ModelAndView getAllSVien() {
//		ModelAndView modelAndView = new ModelAndView();
//		List<Khoa> dssv = khoaService.getAllKhoa();
//	modelAndView.addObject("listkhoa",dssv);
//		modelAndView.setViewName("QLKhoa");
//		
//		return modelAndView;
//	}
//	@RequestMapping(value = "them")
//	public ModelAndView add() {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("dskhoa", new Khoa());
//		modelAndView.setViewName("them");
//		return modelAndView;
//	}
//	
//	
//	@PostMapping(value = "luu")
//	public ModelAndView luu( Khoa k,BindingResult bindingResult,HttpSession session) {
//		ModelAndView modelAndView = new ModelAndView();
//		if(bindingResult.hasErrors()) {
//			modelAndView.setViewName("them");
//			modelAndView.addObject("listkhoa",khoaService.getAllKhoa());
//			return modelAndView;
//		}
//		System.out.println("-----------------------------------------------");
//		
//		System.out.println(k);
//		modelAndView.setViewName("redirect:/QLKhoa");
//		return modelAndView;
//	}
//	 
//     public Khoa messages(@ModelAttribute("dskhoa") Khoa k) {
//		 System.out.println(k);
//         return k;
//     }
}

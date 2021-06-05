package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LopHoc;
import com.example.demo.service.LopHocService;

@RestController
public class LopHocController {
	@Autowired
	private LopHocService lopHocService;
	@RequestMapping(value = "/lophoc/add",method = RequestMethod.POST)
boolean addLopHoc(LopHoc hoc) {
	return lopHocService.addLopHoc(hoc);
}
	@RequestMapping(value = "/lophoc/edit",method = RequestMethod.PUT)
	boolean editLopHoc(LopHoc hoc) {
		return lopHocService.editLopHoc(hoc);
	}
	@RequestMapping(value = "/dslophoc/{id}",method = RequestMethod.GET)
	Optional<LopHoc> getLopHocByidSV(@PathVariable("id")Long id){
		return lopHocService.getLopHocByidSV(id);
	}
	@RequestMapping(value = "/dslophoc",method = RequestMethod.GET)
	 public List<LopHoc> getAllLopHoc(){
		 return lopHocService.getAllLopHoc();
	 }
}

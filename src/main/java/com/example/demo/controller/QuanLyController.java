package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.QuanLy;
import com.example.demo.service.QuanLyService;

@RestController
public class QuanLyController {
	@Autowired
	QuanLyService quanlyService;
	@RequestMapping(value = "/quanly/add",method = RequestMethod.POST)
boolean addQL(QuanLy ql) {
	return quanlyService.addQL(ql);
}
	@RequestMapping(value = "/quanly/edit",method = RequestMethod.PUT)
	boolean editQL(QuanLy ql) {
		return quanlyService.editQL(ql);
	}
	@RequestMapping(value = "/quanly/delete/{id}",method = RequestMethod.DELETE)
	boolean removeQL(@PathVariable("id")Long id) {
		return quanlyService.removeQL(id);
	}
	@RequestMapping(value = "/dsquanly",method = RequestMethod.GET)
	List<QuanLy> getAllQL(){
		return quanlyService.getAllQL();
	}
	@RequestMapping(value = "/dsquanly/getbyname",method = RequestMethod.GET)
	QuanLy getQLbyName(String name) {
		return quanlyService.getQLbyName(name);
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ChuyenNganh;
import com.example.demo.service.ChuyenNganhService;

@RestController
public class ChuyenNganhController {
	@Autowired
	private ChuyenNganhService chuyennganhservice;
	@RequestMapping(value = "/chuyennganh/add",method = RequestMethod.POST)
	public boolean addChuyenNganh(ChuyenNganh cn) {
		return chuyennganhservice.addChuyenNganh(cn);
	}
	@RequestMapping(value = "/chuyennganh/edit",method = RequestMethod.PUT)
public boolean editChuyenNganh(ChuyenNganh cn) {
		return chuyennganhservice.editChuyenNganh(cn);
	}
	@RequestMapping(value = "/dschuyennganh",method = RequestMethod.GET)
public List<ChuyenNganh> getAllChuyenNganh() {
	return chuyennganhservice.getAllChuyenNganh();
}
	@RequestMapping(value = "/dschuyennganh/byname",method = RequestMethod.GET)
public List<ChuyenNganh> getChuyenNganhByName(String name) {
	return chuyennganhservice.getChuyenNganhByName(name);
}
}

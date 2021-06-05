package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Phong;
import com.example.demo.service.PhongService;

@RestController
public class PhongController {
	@Autowired
	PhongService phongService;
	@RequestMapping(value = "/phong/add",method = RequestMethod.POST)
	boolean addPhong(Phong p) {
		return phongService.addPhong(p);
	}
	@RequestMapping(value = "/phong/add",method = RequestMethod.PUT)
	boolean editPhong(Phong p) {
		return phongService.editPhong(p);
	}
	@RequestMapping(value = "/phong/delete/byname",method = RequestMethod.DELETE)
	boolean removePhongByName(String name) {
		return phongService.removePhongByName(name);
	}
	@RequestMapping(value = "/dsphong",method = RequestMethod.GET)
	List<Phong> getAllPhong(){
		return phongService.getAllPhong();
	}
	@RequestMapping(value = "/dsphong/getttphong",method = RequestMethod.GET)
	List<Phong> getTTPhong(String tt){
		return phongService.getTTPhong(tt);
	}
	@RequestMapping(value = "/dsphong/getnha",method = RequestMethod.GET)
	List<Phong> getNhaPhong(String nha){
		return phongService.getNhaPhong(nha);
	}
}

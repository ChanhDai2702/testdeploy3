package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaiKhoan;
import com.example.demo.service.TaiKhoanService;

@RestController
public class TaiKhoanController {
	@Autowired
	TaiKhoanService taiKhoanService;
	@RequestMapping(value = "/taikhoan/add",method = RequestMethod.POST)
	boolean addTaiKhoan(TaiKhoan tk) {
		return taiKhoanService.addTaiKhoan(tk);
	}
	@RequestMapping(value = "/taikhoan/edit",method = RequestMethod.PUT)
	boolean editTaiKhoan(TaiKhoan tk) {
		return taiKhoanService.editTaiKhoan(tk);
	}
	@RequestMapping(value = "/dstaikhoan",method = RequestMethod.GET)
	List<TaiKhoan> getAllTK(){
		return taiKhoanService.getAllTK();
	}
	@RequestMapping(value = "/dstaikhoan/getbyID/{id}",method = RequestMethod.GET)
	Optional<TaiKhoan> getTKbyID(@PathVariable("id")Long id){
		return taiKhoanService.getTKbyID(id);
	}
}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.SinhVien;
import com.example.demo.service.SinhVienService;

@RestController
public class SinhVienController {
	@Autowired
	SinhVienService sinhVienService;
	@RequestMapping(value = "/sinhvien/add",method = RequestMethod.POST)
	boolean addSV(SinhVien sv) {
		return sinhVienService.addSV(sv);
	}
	@RequestMapping(value = "/sinhvien/edit",method = RequestMethod.PUT)
	boolean editSV(SinhVien sv) {
		return sinhVienService.editSV(sv);
	}
	@RequestMapping(value = "/dssinhvien",method = RequestMethod.GET)
	List<SinhVien> getAllSV(){
		return sinhVienService.getAllSV();
	}
	@RequestMapping(value = "/dssinhvien/getbyIDOptional/{id}",method = RequestMethod.GET)
	Optional<SinhVien>	getSVbyIDOptional(@PathVariable("id") Long id){
		return sinhVienService.getSVbyIDOptional(id);
	}
	@RequestMapping(value = "/dssinhvien/getbyname",method = RequestMethod.GET)
	List<SinhVien> getSVbyName(String name){
		return sinhVienService.getSVbyName(name);
	}
	@RequestMapping(value = "/dssinhvien/getbytt",method = RequestMethod.GET)
	List<SinhVien> getSVbyTT(String tt){
		return sinhVienService.getSVbyTT(tt);
	}
	@RequestMapping(value = "/dssinhvien/getbyID/{id}",method = RequestMethod.GET)
	public SinhVien getSVbyID(@PathVariable("id") Long id) {
		return sinhVienService.getSVbyID(id);
	}
}

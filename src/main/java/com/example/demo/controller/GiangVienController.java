package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GiangVien;
import com.example.demo.service.GiangVienService;

@RestController
public class GiangVienController {
	@Autowired
	GiangVienService giangVienService;
	@RequestMapping(value = "/giangvien/add",method = RequestMethod.POST)
boolean addGV(@RequestBody GiangVien gv) {
	return giangVienService.addGV(gv);
}
	@RequestMapping(value = "/giangvien/edit",method = RequestMethod.PUT)
	boolean edit(@RequestBody GiangVien gv) {
		return giangVienService.edit(gv);
	}
	@RequestMapping(value = "/dsgiangvien",method = RequestMethod.GET)
	ResponseEntity<List<GiangVien>> getAllGV(){
		try {
			 return new ResponseEntity<List<GiangVien>>(giangVienService.getAllGV(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<List<GiangVien>>(HttpStatus.BAD_REQUEST);
		}
		
	}
/*	@RequestMapping(value = "/dsgiangvien/idoptional",method = RequestMethod.GET)
	Optional<GiangVien> getGVbyIDOptional(Long id){
		return giangVienService.getGVbyIDOptional(id);
	}*/
	@RequestMapping(value = "/dsgiangvien/dsgiangvienbyname",method = RequestMethod.GET)
	List<GiangVien> getGVbyName(String name){
		return giangVienService.getGVbyName(name);
	}
	@RequestMapping(value = "/dsgiangvien/dsgiangvienbytt",method = RequestMethod.GET)
	List<GiangVien> getGVbyTT(String tt){
		return giangVienService.getGVbyTT(tt);
	}
	@RequestMapping(value = "/dsgiangvien/{id}",method = RequestMethod.GET)
	GiangVien getGVbyID(@PathVariable("id")Long id) {
		return giangVienService.getGVbyID(id);
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DiemThanhPhan;
import com.example.demo.service.ChiTietDiemService;

@RestController
public class ChiTietDiemController {
	@Autowired
	private ChiTietDiemService chitietdiemservice;
	@RequestMapping(value = "/dschitietdiem/{id}",method = RequestMethod.GET)
	public List<DiemThanhPhan> getAllChiTietDiembyidBangDiem(@PathVariable("id")Long id){
		return chitietdiemservice.getAllChiTietDiembyidBangDiem(id);
	}
	@RequestMapping(value = "/chitietdiem/add",method = RequestMethod.POST)
	public boolean addChiTietDiem(DiemThanhPhan ctd) {
		return chitietdiemservice.addChiTietDiem(ctd);
	}
	@RequestMapping(value = "/chitietdiem/edit",method = RequestMethod.PUT)
	public boolean editChiTietDiem(DiemThanhPhan ctd) {
		return chitietdiemservice.editChiTietDiem(ctd);
	}
}

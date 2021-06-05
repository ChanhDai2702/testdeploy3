package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LichThi;
import com.example.demo.service.ThoiGianThiService;

@RestController
public class ThoiGianThiController {
	@Autowired
	ThoiGianThiService thoiGianThiService;
	@RequestMapping(value = "/thoigianthi/add",method = RequestMethod.POST)
	boolean addThoiGianThi(LichThi t) {
		return thoiGianThiService.addThoiGianThi(t);
	}
	@RequestMapping(value = "/thoigianthi/edit",method = RequestMethod.PUT)
	boolean editThoiGianThi(LichThi t) {
		return thoiGianThiService.editThoiGianThi(t);
	}
	@RequestMapping(value = "/thoigianthi/delete",method = RequestMethod.DELETE)
	boolean removeThoiGianThi(LocalDate time) {
		return thoiGianThiService.removeThoiGianThi(time);
	}
	@RequestMapping(value = "/dsthoigianthi/getbyID/{id}",method = RequestMethod.POST)
	LichThi getThoiGianThi(@PathVariable("id")Long id) {
		return thoiGianThiService.getThoiGianThi(id);
	}
}

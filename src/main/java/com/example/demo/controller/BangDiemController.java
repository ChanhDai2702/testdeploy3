package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BangDiem;
import com.example.demo.model.SinhVien;
import com.example.demo.service.BangDiemService;

@RestController
public class BangDiemController {
	@Autowired
	private BangDiemService bangdiemService;
	@RequestMapping(value = "/dsbangdiem",method = RequestMethod.GET)
	public List<BangDiem> getAllBangDiembyIDSV(Long sv) {
		return bangdiemService.getAllBangDiembyIDSV(sv);
	}
	@RequestMapping(value = "/bangdiem/add",method = RequestMethod.POST)
	public boolean addBangDiem(BangDiem b) {
		return bangdiemService.addBangDiem(b);
	}
	@RequestMapping(value = "/bangdiem/edit",method = RequestMethod.PUT)
	public boolean  editBangDiem(BangDiem bd) {
		return bangdiemService.editBangDiem(bd);
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.HocKy;
import com.example.demo.service.HocKyService;

@RestController
public class HocKyController {
	@Autowired
	HocKyService hockyService;
	@RequestMapping(value = "hocky/add",method = RequestMethod.POST)
	boolean addHK(HocKy hk) {
		return hockyService.addHK(hk);
	}
	@RequestMapping(value = "hocky/delete/{id}",method = RequestMethod.DELETE)
	boolean deleteHK(@PathVariable("id")Long idhk) {
		return hockyService.deleteHK(idhk);
	}
	@RequestMapping(value = "hocky/update",method = RequestMethod.PUT)
	boolean updateHK(HocKy hk) {
		return hockyService.updateHK(hk);
	}
	@RequestMapping(value = "dshocky",method = RequestMethod.GET)
	List<HocKy> getAllHocKy(){
		return hockyService.getAllHocKy();
	}
	@RequestMapping(value = "hocky/getByIdNienKhoa/{id}")
	HocKy getAllHocKyByIdNienKhoa(@PathVariable("id")Long id){
		return hockyService.getAllHocKyByIdNienKhoa(id);
	}
}

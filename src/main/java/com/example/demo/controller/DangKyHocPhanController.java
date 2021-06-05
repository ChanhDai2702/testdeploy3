package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DangKyLopHocPhan;
import com.example.demo.service.DangKyLopHocPhanService;

@RestController
public class DangKyHocPhanController {
	@Autowired
	private DangKyLopHocPhanService dkhpservice;
	@RequestMapping(value = "/dsdkhp/add",method = RequestMethod.POST)
	public boolean addDKHP(DangKyLopHocPhan dkhp) {
		return dkhpservice.addDKHP(dkhp);
	}
	@RequestMapping(value = "/dkhp/{id}",method = RequestMethod.DELETE)
	public boolean huyDKHP(Long id) {
		return dkhpservice.huyDKHP(id);
	}
	@RequestMapping(value = "/dkhp",method = RequestMethod.GET)
	public List<DangKyLopHocPhan> getAllDKHP(){
		return dkhpservice.getAllDKHP();
	}
	@RequestMapping(value = "/dkhp/getBySV/{id}")
	public List<DangKyLopHocPhan> getAllDKHPBySVID(@PathVariable("id")Long id) {
		return dkhpservice.findAllLHPBySVID(id);
	}
	@RequestMapping(value = "/dsdkhp/{id}/{nienKhoaid}")
	List<DangKyLopHocPhan> getAllLHPBYSVIDandNienKhoa(@PathVariable("id")Long id,@PathVariable("nienKhoaid")Long nienKhoaid){
		return dkhpservice.getAllLHPBYSVIDandNienKhoa(id, nienKhoaid);
	}
}

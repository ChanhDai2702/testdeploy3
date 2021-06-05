package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LichHoc;
import com.example.demo.service.ThoiGianHocService;

@RestController
public class ThoiGianHocController {
	@Autowired
	ThoiGianHocService thoiGianHocService;
	@RequestMapping(value = "/thoigianhoc/add",method = RequestMethod.POST)
	boolean addThoiGianHoc(LichHoc t) {
		return thoiGianHocService.addThoiGianHoc(t);
	}
	@RequestMapping(value = "/thoigianhoc/edit",method = RequestMethod.PUT)
	boolean editThoiGianHoc(LichHoc t) {
		return thoiGianHocService.editThoiGianHoc(t);
	}
	@RequestMapping(value = "/thoigianhoc/delete",method = RequestMethod.DELETE)
	boolean removeThoiGianHoc(LocalDate ngayhoc) {
		return thoiGianHocService.removeThoiGianHoc(ngayhoc);
	}
	@RequestMapping(value = "/dsthoigianhoc/getbyID/{id}",method = RequestMethod.GET)
	List<LichHoc> getThoiGianHoc(@PathVariable("id")Long id) {
		return thoiGianHocService.getThoiGianHoc(id);
	}
	@RequestMapping(value = "/dsthoigianhoc/getbyIDLHP/{id}",method = RequestMethod.GET)
	List<LichHoc> getLichHocByLHPID(@PathVariable("id")Long id){
		return thoiGianHocService.getLichHocByLHPID(id);
	}
	@RequestMapping(value = "/dsthoigianhoc/getbyIDSV/{id}",method = RequestMethod.GET)
	List<LichHoc> getLichHocBySVID(@PathVariable("id") Long id){
		return thoiGianHocService.getLichHocBySVID(id);
	}
	@RequestMapping(value = "/dsthoigianhoc/getbyIDSVandNK/{id}/{idNienKhoa}",method = RequestMethod.GET)
	public List<LichHoc> getLichHocBySVIDandNK(@PathVariable("id")Long id,@PathVariable("idNienKhoa")Long idNienKhoa) {
		return thoiGianHocService.getLichHocBySVIDandNK(id, idNienKhoa);
	}
}

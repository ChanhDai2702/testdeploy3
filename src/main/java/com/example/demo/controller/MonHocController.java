package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LopHocPhan;
import com.example.demo.model.MonHoc;
import com.example.demo.service.MonHocService;

@RestController
public class MonHocController {
	@Autowired
	private MonHocService monHocService;
	@RequestMapping(value = "/monhoc/add",method = RequestMethod.POST)
	boolean addMonHoc(MonHoc hoc) {
		return monHocService.addMonHoc(hoc);
	}	
	@RequestMapping(value = "/monhoc/edit",method = RequestMethod.PUT)
	boolean editMonHoc(MonHoc monhoc) {
		return monHocService.editMonHoc(monhoc);
	}
	@RequestMapping(value = "/dsmonhoc",method = RequestMethod.GET)
	List<MonHoc> getAllMonHoc(){
		return monHocService.getAllMonHoc();
	}
	@RequestMapping(value = "/dsmonhoc/byname",method = RequestMethod.GET)
	MonHoc getMonHocbyName(String name) {
		return monHocService.getMonHocbyName(name);
	}
	@RequestMapping(value = "/dsmonhoc/byid/{id}",method = RequestMethod.GET)
	MonHoc getMonHocbyID(@PathVariable("id")Long id) {
		return monHocService.getMonHocbyID(id);
	}
	@RequestMapping(value = "/dsmonhoc/getnull")
	MonHoc getMHNullValue(Long id) {
		return monHocService.getMHNullValue();
	}
	@RequestMapping(value = "/dsmonhoc/getBySVID/{id}")
	List<MonHoc> getMHBySVID(@PathVariable("id")Long id){
		return monHocService.getAllMHBySVID(id);
	}
	@RequestMapping(value = "/dsmonhoc/getBySVIDandNienKhoaId/{id}/{nienKhoaid}")
	public List<MonHoc> getMHBySVIDandNienKhoa(@PathVariable("id")Long id,@PathVariable("nienKhoaid")Long nienKhoaid) {
				return monHocService.getMHBySVIDandNienKhoa(id, nienKhoaid);
	}
	@RequestMapping(value = "/dsmonhoc/getMHByHocKy/{id}")
	List<MonHoc> getMhByHocKi(@PathVariable("id")Long idHocKy){
		return monHocService.getMhByHocKi(idHocKy);
	}
		

}

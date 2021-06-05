package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LopHocPhan;
import com.example.demo.service.LopHocPhanService;

@RestController
public class LopHocPhanController {
	@Autowired
	LopHocPhanService lopHocPhanService;
	@RequestMapping(value = "/lophocphan/add",method = RequestMethod.POST)
	boolean addLHP(LopHocPhan lhp) {
		return lopHocPhanService.addLHP(lhp);
	}
	@RequestMapping(value = "/lophocphan/edit",method = RequestMethod.PUT)
	boolean editLHP(LopHocPhan lhp) {
		return lopHocPhanService.editLHP(lhp);
	}
	@RequestMapping(value = "/lophocphan/deletebyidLHP/{id}",method = RequestMethod.DELETE)
	boolean removebyIdLHP(Long id) {
		return lopHocPhanService.removebyIdLHP(id);
	}
	@RequestMapping(value = "/lophocphan/deletebytenLHP",method = RequestMethod.DELETE)
	boolean removebyTenLHP(String name) {
		return lopHocPhanService.removebyTenLHP(name);
	}
	@RequestMapping(value = "/dslophocphan",method = RequestMethod.GET)
	List<LopHocPhan> getAllLHP(){
		return lopHocPhanService.getAllLHP();
	}
	@RequestMapping(value = "/dslophocphan/getbyid/{id}",method = RequestMethod.GET)
	LopHocPhan getLHPbyID(@PathVariable("id") Long id) {
		return lopHocPhanService.getLHPbyID(id);
	}
	@RequestMapping(value = "/lophocphan/{}",method = RequestMethod.GET)
	LopHocPhan getLHPbyName(String id) {
		return lopHocPhanService.getLHPbyName(id);
	}
	@RequestMapping(value = "/dslophocphanbyidmonhoc/{id}",method = RequestMethod.GET)
	List<LopHocPhan> getAllLHPByMonHoc(@PathVariable("id") Long id){
		return lopHocPhanService.getAllLHPByMonHoc(id);
	}
	@RequestMapping(value = "/getnullvalue")
	LopHocPhan getLHPNullValue() {
		return lopHocPhanService.getLHPNullValue();
	}
	@RequestMapping(value = "/dslophocphan/getbyIDSV/{id}")
	List<LopHocPhan> getLHPBySVID(@PathVariable("id")Long id){
		return lopHocPhanService.getAllLHPBySVID(id);
	}
	@RequestMapping(value = "/dslophocphan/getbyIDSVandNK/{id}/{idNienKhoa}")
	public List<LopHocPhan> getAllLHPByMonHocAndNK(@PathVariable("id")Long id,@PathVariable("idNienKhoa") Long idNienKhoa) {
		// TODO Auto-generated method stub
		return lopHocPhanService.getAllLHPByMonHocAndNK(id, idNienKhoa);
	}
}

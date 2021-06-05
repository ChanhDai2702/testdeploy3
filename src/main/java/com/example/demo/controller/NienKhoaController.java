package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.NienKhoa;
import com.example.demo.service.NienKhoaService;

@RestController
public class NienKhoaController {
@Autowired
NienKhoaService nienkhoaService;
@RequestMapping(value = "nienKhoa/addNK",method = RequestMethod.POST)
boolean addNK(NienKhoa nk) {
	return nienkhoaService.addNK(nk);
}
@RequestMapping(value = "nienKhoa/editNK",method = RequestMethod.PUT)
boolean editNK(NienKhoa nk) {
	return nienkhoaService.editNK(nk);
}
@RequestMapping(value = "nienKhoa/deleteById/{id}",method = RequestMethod.POST)
boolean deleteNK(@PathVariable("id")Long id) {
	return nienkhoaService.deleteNK(id);
}
@RequestMapping(value = "/dsnienKhoa",method = RequestMethod.GET)
List<NienKhoa> getAllNienKhoa(){
	return nienkhoaService.getAllNienKhoa();
}
@RequestMapping(value = "/dsnienkhoa/getById/{id}",method = RequestMethod.GET)
public NienKhoa getNienKhoaByID(Long id) {
	// TODO Auto-generated method stub
	return nienkhoaService.getNienKhoaByID(id);
}
}

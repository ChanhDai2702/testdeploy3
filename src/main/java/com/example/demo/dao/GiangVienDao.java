package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.GiangVien;

public interface GiangVienDao {
boolean addGV(GiangVien gv);
	
	boolean edit(GiangVien gv);
	
	List<GiangVien> getAllGV();
	
	GiangVien getGVbyID(Long id);
	
	List<GiangVien> getGVbyName(String name);
	
	List<GiangVien> getGVbyTT(String tt);
}

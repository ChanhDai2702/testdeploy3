package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.GiangVien;

public interface GiangVienService {
	boolean addGV(GiangVien gv);
	
	boolean edit(GiangVien gv);
	
	List<GiangVien> getAllGV();
	
	Optional<GiangVien> getGVbyIDOptional(Long id);
	
	List<GiangVien> getGVbyName(String name);
	
	List<GiangVien> getGVbyTT(String tt);
	GiangVien getGVbyID(Long id);
}

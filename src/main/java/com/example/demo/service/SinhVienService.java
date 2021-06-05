package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.SinhVien;

public interface SinhVienService {
	boolean addSV(SinhVien sv);
	
	boolean editSV(SinhVien sv);
	
	List<SinhVien> getAllSV();
	
	Optional<SinhVien>	getSVbyIDOptional(Long id);
	
	List<SinhVien> getSVbyName(String name);
	
	List<SinhVien> getSVbyTT(String tt);
	public SinhVien getSVbyID(Long id);
}

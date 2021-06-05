package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.SinhVien;

public interface SinhVienDao {
boolean addSV(SinhVien sv);
	
	boolean editSV(SinhVien sv);
	boolean deleteSV(Long id);
	List<SinhVien> getAllSV();
	
	Optional<SinhVien>	getSVbyID(Long id);
	
	List<SinhVien> getSVbyName(String name);
	
	List<SinhVien> getSVbyTT(String tt);
	public SinhVien getSVbyIDInApp(Long id);
}

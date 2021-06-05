package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.DiemThanhPhan;

public interface ChiTietDiemDao {
boolean addChiTietDiem(DiemThanhPhan ctd);
	
	boolean editChiTietDiem(DiemThanhPhan ctd);
	
	List<DiemThanhPhan> getAllChiTietDiembyidBangDiem(Long id);
}

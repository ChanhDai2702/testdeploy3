package com.example.demo.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.model.LichHoc;

public interface ThoiGianHocDao {
boolean addThoiGianHoc(LichHoc t);
	
	boolean editThoiGianHoc(LichHoc t);
	
	boolean removeThoiGianHoc(LocalDate ngayhoc);
	
	LichHoc getThoiGianHoc(Long id);
	boolean removeThoiGianHocByID(Long id);
	List<LichHoc> getALLTGH();
	List<LichHoc> getTGHbyIDLHP(Long id);
}

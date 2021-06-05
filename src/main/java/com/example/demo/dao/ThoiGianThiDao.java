package com.example.demo.dao;

import java.time.LocalDate;

import com.example.demo.model.LichThi;

public interface ThoiGianThiDao {
	boolean addThoiGianThi(LichThi t);
	
	boolean editThoiGianThi(LichThi t);
	
	boolean removeThoiGianThi(LocalDate time);
	
	LichThi getThoiGianThi(Long id);
}

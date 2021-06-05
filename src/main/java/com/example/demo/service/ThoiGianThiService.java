package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.model.LichThi;

public interface ThoiGianThiService {
	boolean addThoiGianThi(LichThi t);
	
	boolean editThoiGianThi(LichThi t);
	
	boolean removeThoiGianThi(LocalDate time);
	
	LichThi getThoiGianThi(Long id);
}

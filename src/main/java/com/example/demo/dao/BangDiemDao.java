package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.BangDiem;

public interface BangDiemDao {
boolean addBangDiem(BangDiem bd);
	
	boolean editBangDiem(BangDiem bd);
	
	List<BangDiem> getAllBangDiembyIDSV(Long sv);
	
	BangDiem getBangDiembyIDMon(Long mon);
}

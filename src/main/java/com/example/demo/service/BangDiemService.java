package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DiemTichLuyDTO;
import com.example.demo.model.BangDiem;

public interface BangDiemService {
boolean addBangDiem(BangDiem bd);
	
	boolean editBangDiem(BangDiem bd);
	
	List<BangDiem> getAllBangDiembyIDSV(Long sv);
	
	BangDiem getBangDiembyIDMon(Long mon);
	
	List<DiemTichLuyDTO> getAllHocKyCoDiemID(long id);
}

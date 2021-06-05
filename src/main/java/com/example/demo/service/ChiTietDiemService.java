package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.DiemThanhPhan;

public interface ChiTietDiemService {
	boolean addChiTietDiem(DiemThanhPhan ctd);
	
	boolean editChiTietDiem(DiemThanhPhan ctd);
	
	List<DiemThanhPhan> getAllChiTietDiembyidBangDiem(Long id);
}

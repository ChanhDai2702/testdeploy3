package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.LopHoc;

public interface LopHocService {
	boolean addLopHoc(LopHoc hoc);
	
	boolean editLopHoc(LopHoc hoc);
	
	Optional<LopHoc> getLopHocByidSV(Long id);
	 public List<LopHoc> getAllLopHoc();
}

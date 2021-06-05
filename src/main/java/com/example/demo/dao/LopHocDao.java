package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.LopHoc;

public interface LopHocDao {
boolean addLopHoc(LopHoc hoc);
	
	boolean editLopHoc(LopHoc hoc);
	LopHoc getLopHocbyIDLopHoc(Long id);
	LopHoc getLopHocByidSV(Long id);
	 public List<LopHoc> getAllLopHoc();
}

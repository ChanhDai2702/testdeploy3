package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.MonHoc;

public interface MonHocDao {
boolean addMonHoc(MonHoc hoc);
	
	boolean editMonHoc(MonHoc monhoc);
	
	List<MonHoc> getAllMonHoc();
	
	MonHoc getMonHocbyName(String name);
	
	MonHoc getMonHocbyID(Long id);
}

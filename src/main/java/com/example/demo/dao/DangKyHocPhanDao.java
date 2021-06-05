package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.DangKyLopHocPhan;

public interface DangKyHocPhanDao {
boolean addDKHP(DangKyLopHocPhan dkhp);
	
	boolean huyDKHP(Long id);
	
	List<DangKyLopHocPhan> getAllDKHP();
}

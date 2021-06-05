package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.DangKyLopHocPhan;

public interface DangKyLopHocPhanService {
	boolean addDKHP(DangKyLopHocPhan dkhp);
	
	boolean huyDKHP(Long id);
	
	List<DangKyLopHocPhan> getAllDKHP();
	List<DangKyLopHocPhan> findAllLHPBySVID(Long id);
	
	List<DangKyLopHocPhan> getAllLHPBYSVIDandNienKhoa(Long id,Long nienKhoaid);
}

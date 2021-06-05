package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.LopHocPhan;
import com.example.demo.model.MonHoc;

public interface MonHocService {
	boolean addMonHoc(MonHoc hoc);
	
	boolean editMonHoc(MonHoc monhoc);
	
	List<MonHoc> getAllMonHoc();
	
	MonHoc getMonHocbyName(String name);
	
	MonHoc getMonHocbyID(Long id);
	MonHoc getMHNullValue();
	List<MonHoc> getAllMHBySVID(Long id);
	
	List<MonHoc> getMHBySVIDandNienKhoa(Long id,Long nienKhoaid);
	List<MonHoc> getMhByHocKi(Long idHocKy);
}

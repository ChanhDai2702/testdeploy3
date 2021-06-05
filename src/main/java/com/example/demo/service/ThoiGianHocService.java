package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.LichHoc;

public interface ThoiGianHocService {
	boolean addThoiGianHoc(LichHoc t);
	
	boolean editThoiGianHoc(LichHoc t);
	
	boolean removeThoiGianHoc(LocalDate ngayhoc);
	
	List<LichHoc> getThoiGianHoc(Long id);
	List<LichHoc> getLichHocByLHPID(Long id);
	List<LichHoc> getLichHocBySVID(Long id);
	List<LichHoc> getLichHocBySVIDandNK(Long id,Long idNienKhoa);
	List<LichHoc> getLichdaybyGV(Long id);
}

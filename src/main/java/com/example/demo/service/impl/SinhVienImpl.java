package com.example.demo.service.impl;


import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.SinhVien;
import com.example.demo.repository.SinhVienRepository;
import com.example.demo.service.SinhVienService;
@Service
public class SinhVienImpl implements SinhVienService {
	@Autowired
	SinhVienRepository sinhVienRepo;
	@Override
	public boolean addSV(SinhVien sv) {
		try {
			if(sv!=null) {
				sinhVienRepo.save(sv);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editSV(SinhVien sv) {
		try {
			if(sv!=null) {
				sinhVienRepo.save(sv);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<SinhVien> getAllSV() {
		// TODO Auto-generated method stub
		//Iterable<SinhVien> iterable=sinhVienRepo.findAll();
		//List<SinhVien> listSinhVien=StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
		return sinhVienRepo.findAll();
	}

	@Override
	public Optional<SinhVien> getSVbyIDOptional(Long id) {
		
		return sinhVienRepo.findById(id);
	}

	@Override
	public List<SinhVien> getSVbyName(String name) {
		
		
		return sinhVienRepo.getSvbyname(name);
	}

	@Override
	public List<SinhVien> getSVbyTT(String tt) {
		// TODO Auto-generated method stub
		return sinhVienRepo.getSvbytrangthai(tt);
	}

	@Override
	public SinhVien getSVbyID(Long id) {
		// TODO Auto-generated method stub
		Optional<SinhVien> sinhvien=sinhVienRepo.findById(id);
		if(sinhvien.isPresent()) {
			return sinhvien.get();
		}
		return null;
	}

}

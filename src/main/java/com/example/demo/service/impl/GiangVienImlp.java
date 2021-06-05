package com.example.demo.service.impl;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GiangVien;

import com.example.demo.repository.GiangVienRepository;
import com.example.demo.service.GiangVienService;
@Service
public class GiangVienImlp implements GiangVienService{
	@Autowired
	GiangVienRepository giangVienRepo;
	@Override
	public boolean addGV(GiangVien gv) {
		// TODO Auto-generated method stub
		try {
			if(gv!=null) {
				giangVienRepo.save(gv);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(GiangVien gv) {
		// TODO Auto-generated method stub
		try {
			if(gv!=null) {
				giangVienRepo.save(gv);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<GiangVien> getAllGV() {
		// TODO Auto-generated method stub
		return giangVienRepo.findAll();
	}

	@Override
	public Optional<GiangVien> getGVbyIDOptional(Long id) {
		// TODO Auto-generated method stub
		return giangVienRepo.findById(id);
	}

	@Override
	public List<GiangVien> getGVbyName(String name) {
		// TODO Auto-generated method stub
		return giangVienRepo.getGiangVienByName(name);
	}

	@Override
	public List<GiangVien> getGVbyTT(String tt) {
		// TODO Auto-generated method stub
		return giangVienRepo.getGiangVienByTT(tt);
	}

	@Override
	public GiangVien getGVbyID(Long id) {
		// TODO Auto-generated method stub
		Optional<GiangVien> giangVien=giangVienRepo.findById(id);
		if(giangVien.isPresent()) {
			return giangVien.get();
		}
		return null;
	}
	

}

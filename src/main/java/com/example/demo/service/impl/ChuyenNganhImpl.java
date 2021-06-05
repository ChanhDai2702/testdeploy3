package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChuyenNganh;
import com.example.demo.repository.ChuyenNganhRepository;
import com.example.demo.service.ChuyenNganhService;
@Service
public class ChuyenNganhImpl implements ChuyenNganhService {
	@Autowired
	ChuyenNganhRepository chuyenRepository;

	@Override
	public boolean addChuyenNganh(ChuyenNganh cn) {
		try {
			if(cn!=null) {
				chuyenRepository.save(cn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean editChuyenNganh(ChuyenNganh cn) {
		try {
			if(cn!=null) {
				chuyenRepository.save(cn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<ChuyenNganh> getAllChuyenNganh() {
		// TODO Auto-generated method stub
		return chuyenRepository.findAll();
	}

	@Override
	public List<ChuyenNganh> getChuyenNganhByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

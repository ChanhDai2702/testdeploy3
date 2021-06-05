package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.ChuyenNganh;

public interface ChuyenNganhService {
	boolean addChuyenNganh(ChuyenNganh cn);
	
	boolean editChuyenNganh(ChuyenNganh cn);
	
	List<ChuyenNganh> getAllChuyenNganh();
	
	List<ChuyenNganh> getChuyenNganhByName(String name);
}

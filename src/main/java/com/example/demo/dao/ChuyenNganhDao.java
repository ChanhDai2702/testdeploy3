package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.ChuyenNganh;

public interface ChuyenNganhDao {
	boolean addChuyenNganh(ChuyenNganh cn);
	
	boolean editChuyenNganh(ChuyenNganh cn);
	
	List<ChuyenNganh> getAllChuyenNganh();
	
	List<ChuyenNganh> getChuyenNganhByName(String name);
}

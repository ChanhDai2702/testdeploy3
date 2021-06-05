package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.QuanLy;

public interface QuanLyDao {
boolean addQL(QuanLy ql);
	
	boolean editQL(QuanLy ql);
	
	boolean removeQL(Long id);
	
	List<QuanLy> getAllQL();
	
	QuanLy getQLbyName(String name);
}

package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.QuanLy;

public interface QuanLyService {
	boolean addQL(QuanLy ql);
	
	boolean editQL(QuanLy ql);
	
	boolean removeQL(Long id);
	
	List<QuanLy> getAllQL();
	
	QuanLy getQLbyName(String name);
}

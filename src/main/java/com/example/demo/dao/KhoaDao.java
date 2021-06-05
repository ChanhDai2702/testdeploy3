package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Khoa;

public interface KhoaDao {
	boolean addKhoa(Khoa k);
	
	boolean editKhoa(Khoa k);
	
	List<Khoa> getAllKhoa();
}

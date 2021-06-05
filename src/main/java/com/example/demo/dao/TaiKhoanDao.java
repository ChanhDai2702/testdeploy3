package com.example.demo.dao;

import java.util.List;


import com.example.demo.model.TaiKhoan;

public interface TaiKhoanDao {
	
	boolean addTaiKhoan(TaiKhoan tk);
	
	boolean editTaiKhoan(TaiKhoan tk);
	
	List<TaiKhoan> getAllTK();
	
	TaiKhoan getTKbyID(Long id);

	TaiKhoan getTKbyID1(Long id);
}

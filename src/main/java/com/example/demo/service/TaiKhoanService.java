package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.TaiKhoan;

public interface TaiKhoanService {
	boolean addTaiKhoan(TaiKhoan tk);
	
	boolean editTaiKhoan(TaiKhoan tk);
	
	List<TaiKhoan> getAllTK();
	
	Optional<TaiKhoan> getTKbyID(Long id);
	TaiKhoan findByTaiKhoan(String tk);
}

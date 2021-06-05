package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaiKhoan;
import com.example.demo.repository.TaiKhoanRepository;
import com.example.demo.service.TaiKhoanService;
@Service
public class TaiKhoanImpl implements TaiKhoanService {
	@Autowired
	TaiKhoanRepository taikhoan;
	
	@Override
	public boolean addTaiKhoan(TaiKhoan tk) {
		try {
			if(tk!=null) {
				taikhoan.save(tk);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editTaiKhoan(TaiKhoan tk) {
		try {
			if(tk!=null) {
				taikhoan.save(tk);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TaiKhoan> getAllTK() {
		
		return (List<TaiKhoan>) taikhoan.findAll();
	}

	@Override
	public Optional<TaiKhoan> getTKbyID(Long id) {
		
		return taikhoan.findById(id);
	}

	@Override
	public TaiKhoan findByTaiKhoan(String tk) {
		Optional<TaiKhoan> optional = taikhoan.findByTaiKhoan(tk);
		if(!optional.isPresent())
			return null;
		return optional.get();
	}

}

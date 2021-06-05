package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Khoa;
import com.example.demo.repository.KhoaRepository;
import com.example.demo.service.KhoaService;
@Service
public class KhoaImpl implements KhoaService{
	@Autowired
	KhoaRepository khoarepo;
	@Override
	public boolean addKhoa(Khoa k) {
		// TODO Auto-generated method stub
		try {
			if(k!=null) {
				khoarepo.save(k);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editKhoa(Khoa k) {
		// TODO Auto-generated method stub
		try {
			if(k!=null) {
				khoarepo.save(k);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Khoa> getAllKhoa() {
		// TODO Auto-generated method stub
		return khoarepo.findAll();
	}

}

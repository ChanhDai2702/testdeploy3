package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.QuanLy;
import com.example.demo.repository.QuanLyRepository;
import com.example.demo.service.QuanLyService;
@Service
public class QuanLyImpl implements QuanLyService{
	@Autowired
	QuanLyRepository quanLyRepo;
	@Override
	public boolean addQL(QuanLy ql) {
		// TODO Auto-generated method stub
		try {
			if(ql!=null) {
				quanLyRepo.save(ql);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editQL(QuanLy ql) {
		// TODO Auto-generated method stub
		try {
			if(ql!=null) {
				quanLyRepo.save(ql);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeQL(Long id) {
		// TODO Auto-generated method stub
		try {
			if(!id.equals("")) {
				quanLyRepo.deleteById(id);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<QuanLy> getAllQL() {
		// TODO Auto-generated method stub
		return quanLyRepo.findAll();
	}

	@Override
	public QuanLy getQLbyName(String name) {
		// TODO Auto-generated method stub
		return quanLyRepo.getQLbyname(name);
	}

}

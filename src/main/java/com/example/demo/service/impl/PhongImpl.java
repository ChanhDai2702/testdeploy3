package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Phong;
import com.example.demo.repository.PhongRepository;
import com.example.demo.service.PhongService;
@Service
public class PhongImpl implements PhongService{
	@Autowired
	PhongRepository phongRepo;
	@Override
	public boolean addPhong(Phong p) {
		// TODO Auto-generated method stub
		try {
			if(p!=null) {
				phongRepo.save(p);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editPhong(Phong p) {
		// TODO Auto-generated method stub
		try {
			if(p!=null) {
				phongRepo.save(p);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removePhongByName(String name) {
		// TODO Auto-generated method stub
		try {
			if(!name.equals("")) {
				//phongRepo.delete;
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Phong> getAllPhong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phong> getTTPhong(String tt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phong> getNhaPhong(String nha) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DangKyLopHocPhan;
import com.example.demo.model.HocKy;
import com.example.demo.repository.HocKyRepository;
import com.example.demo.service.HocKyService;
@Service
public class HocKyImpl implements HocKyService{

	@Autowired
	HocKyRepository hockyRepo;

	@Override
	public List<HocKy> getAllHocKy() {

		return hockyRepo.getAllHocKy();
	}

	@Override
	public boolean addHK(HocKy hk) {

		try {
			if(hk!=null) {
				hockyRepo.save(hk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteHK(Long idhk) {

		try {
			if(!idhk.equals("")) {
				hockyRepo.deleteById(idhk);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateHK(HocKy hk) {
		try {
			if(hk!=null) {
				hockyRepo.save(hk);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public HocKy getAllHocKyByIdNienKhoa(Long id) {
		// TODO Auto-generated method stub
		return hockyRepo.getAllHocKyByIdNienKhoa(id);
	}

	@Override
	public List<HocKy> getAllHocKybySV(long id) {
		// TODO Auto-generated method stub
		return hockyRepo.getAllHocKybySV(id);
	}




}

package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DangKyLopHocPhan;
import com.example.demo.repository.DangKyLopHocPhanRepository;
import com.example.demo.service.DangKyLopHocPhanService;
@Service
public class DangKyLopHocPhanImpl implements DangKyLopHocPhanService{
	@Autowired
	DangKyLopHocPhanRepository dkhpRepo;
	@Override
	public boolean addDKHP(DangKyLopHocPhan dkhp) {
		// TODO Auto-generated method stub
		try {
			if(dkhp!=null) {
				dkhpRepo.saveAndFlush(dkhp);
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean huyDKHP(Long id) {
		// TODO Auto-generated method stub
		try {
			if(!id.equals("")) {
				dkhpRepo.deleteById(id);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DangKyLopHocPhan> getAllDKHP() {
		// TODO Auto-generated method stub
		return dkhpRepo.findAll();
	}

	@Override
	public List<DangKyLopHocPhan> findAllLHPBySVID(Long id) {
		// TODO Auto-generated method stub
		return dkhpRepo.findAllLHPBySVID(id);
	}

	@Override
	public List<DangKyLopHocPhan> getAllLHPBYSVIDandNienKhoa(Long id, Long nienKhoaid) {
		// TODO Auto-generated method stub
		return dkhpRepo.getAllLHPBYSVIDandNienKhoa(id, nienKhoaid);
	}

}

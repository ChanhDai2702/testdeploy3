package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LopHocPhan;
import com.example.demo.model.MonHoc;
import com.example.demo.repository.MonHocRepository;
import com.example.demo.service.MonHocService;
@Service
public class MonHocImpl implements MonHocService{
	@Autowired
	MonHocRepository monHocRepo;
	@Override
	public boolean addMonHoc(MonHoc hoc) {
		// TODO Auto-generated method stub
		try {
			if(hoc!=null) {
				monHocRepo.save(hoc);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean editMonHoc(MonHoc monhoc) {
		// TODO Auto-generated method stub
		try {
			if(monhoc!=null) {
				monHocRepo.save(monhoc);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<MonHoc> getAllMonHoc() {
		// TODO Auto-generated method stub
		return monHocRepo.findAll();
	}

	@Override
	public MonHoc getMonHocbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonHoc getMonHocbyID(Long id) {
		// TODO Auto-generated method stub
		return monHocRepo.getMHById(id);
	}

	@Override
	public MonHoc getMHNullValue() {
		// TODO Auto-generated method stub
		return monHocRepo.getMHNullValue();
	}

	@Override
	public List<MonHoc> getAllMHBySVID(Long id) {
		// TODO Auto-generated method stub
		return monHocRepo.getMHBySVID(id);
	}

	@Override
	public List<MonHoc> getMHBySVIDandNienKhoa(Long id, Long nienKhoaid) {
		// TODO Auto-generated method stub
		return monHocRepo.getMHBySVIDandNienKhoa(id, nienKhoaid);
	}

	@Override
	public List<MonHoc> getMhByHocKi(Long idHocKy) {
		// TODO Auto-generated method stub
		return monHocRepo.getMhByHocKi(idHocKy);
	}




}

package com.example.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DiemThanhPhan;
import com.example.demo.repository.ChiTietDiemRepository;
import com.example.demo.service.ChiTietDiemService;
@Service
public class ChiTietDiemImpl implements ChiTietDiemService{
	@Autowired
	ChiTietDiemRepository chitietdiemrep;
	@Override
	public boolean addChiTietDiem(DiemThanhPhan ctd) {
		// TODO Auto-generated method stub
		try {
			if(ctd!=null) {
				chitietdiemrep.save(ctd);
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editChiTietDiem(DiemThanhPhan ctd) {
		// TODO Auto-generated method stub
		try {
			if(ctd!=null) {
				chitietdiemrep.save(ctd);
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DiemThanhPhan> getAllChiTietDiembyidBangDiem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

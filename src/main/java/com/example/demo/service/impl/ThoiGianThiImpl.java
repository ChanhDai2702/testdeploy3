package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LichThi;
import com.example.demo.repository.ThoiGianThiRepository;
import com.example.demo.service.ThoiGianThiService;
@Service
public class ThoiGianThiImpl implements ThoiGianThiService{
	@Autowired
	ThoiGianThiRepository thoigianThiRepo;
	@Override
	public boolean addThoiGianThi(LichThi t) {
		// TODO Auto-generated method stub
		try {
			if(t!=null) {
				thoigianThiRepo.save(t);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editThoiGianThi(LichThi t) {
		// TODO Auto-generated method stub
		try {
			if(t!=null) {
				thoigianThiRepo.save(t);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeThoiGianThi(LocalDate time) {
		// TODO Auto-generated method stub
		try {
			if(!time.equals("")) {
				thoigianThiRepo.deleteByDate(time);
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public LichThi getThoiGianThi(Long id) {
		// TODO Auto-generated method stub
		Optional<LichThi> thoOptional=thoigianThiRepo.findById(id);
		if(thoOptional.isPresent()) {
			return thoOptional.get();
		}
		return null;
	}

}

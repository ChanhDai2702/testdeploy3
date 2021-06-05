package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LichHoc;
import com.example.demo.repository.LichHocRepository;
import com.example.demo.service.ThoiGianHocService;
@Service
public class ThoiGianHocImpl implements ThoiGianHocService{
	@Autowired
	LichHocRepository thoigianHocRepo;
	@Override
	public boolean addThoiGianHoc(LichHoc t) {
		// TODO Auto-generated method stub
		try {
			if(t!=null) {
				thoigianHocRepo.save(t);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editThoiGianHoc(LichHoc t) {
		// TODO Auto-generated method stub
		try {
			if(t!=null) {
				thoigianHocRepo.save(t);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeThoiGianHoc(LocalDate ngayhoc) {
		// TODO Auto-generated method stub
	try {
		if(!ngayhoc.equals("")) {
			thoigianHocRepo.deleteByDate(ngayhoc);
			return true;
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public List<LichHoc> getThoiGianHoc(Long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<LichHoc> getLichHocByLHPID(Long id) {
		// TODO Auto-generated method stub
		return thoigianHocRepo.getLichHocByLHPID(id);
	}

	@Override
	public List<LichHoc> getLichHocBySVID(Long id) {
		// TODO Auto-generated method stub
		return thoigianHocRepo.getLichHocBySVID(id);
	}

	@Override
	public List<LichHoc> getLichHocBySVIDandNK(Long id, Long idNienKhoa) {
		// TODO Auto-generated method stub
		return thoigianHocRepo.getLichHocBySVIDandNK(id, idNienKhoa);
	}

	@Override
	public List<LichHoc> getLichdaybyGV(Long id) {
		// TODO Auto-generated method stub
		return thoigianHocRepo.getLichdaybyGV(id);
	}

}

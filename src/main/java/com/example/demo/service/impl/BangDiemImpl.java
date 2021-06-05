package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DiemTichLuyDTO;
import com.example.demo.model.BangDiem;
import com.example.demo.repository.BangDiemRepository;
import com.example.demo.service.BangDiemService;
@Service
public class BangDiemImpl implements BangDiemService {
	@Autowired
	BangDiemRepository bangdiemRep;
	@Override
	public boolean addBangDiem(BangDiem bd) {
		try {
			if(bd!=null) {
				bangdiemRep.save(bd);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public boolean editBangDiem(BangDiem bd) {
		try {
			if(bd!=null) {
				bangdiemRep.save(bd);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public List<BangDiem> getAllBangDiembyIDSV(Long id) {
		// TODO Auto-generated method stub
		return bangdiemRep.getAllBangDiemByID(id);
	}

	@Override
	public BangDiem getBangDiembyIDMon(Long mon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiemTichLuyDTO> getAllHocKyCoDiemID(long id) {
		// TODO Auto-generated method stub
		return bangdiemRep.getAllHocKyCoDiemID(id);
	}

}

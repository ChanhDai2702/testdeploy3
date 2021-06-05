package com.example.demo.service.impl;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LopHoc;
import com.example.demo.repository.LopHocRepository;
import com.example.demo.service.LopHocService;
@Service
public class LopHocImpl implements LopHocService {
	
	@Autowired
	LopHocRepository lophocRep;
	@Override
	public boolean addLopHoc(LopHoc hoc) {
		try {
			if(hoc!=null) {
				lophocRep.save(hoc);
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean editLopHoc(LopHoc hoc) {
		try {
			if(hoc!=null) {
				lophocRep.save(hoc);
				return true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Optional<LopHoc> getLopHocByidSV(Long id) {
		// TODO Auto-generated method stub
		return lophocRep.findById(id);
	}

	@Override
	public List<LopHoc> getAllLopHoc() {
		// TODO Auto-generated method stub
		return lophocRep.findAll();
	}
	
	

}

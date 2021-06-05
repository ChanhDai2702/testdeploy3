package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.NienKhoa;
import com.example.demo.repository.NienKhoaRepository;
import com.example.demo.service.NienKhoaService;
@Service
public class NienKhoaImpl implements NienKhoaService{

	@Autowired
	NienKhoaRepository nienkhoaRepo;
	@Override
	public boolean addNK(NienKhoa nk) {

		try {
			if(nk!=null) {
				nienkhoaRepo.save(nk);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editNK(NienKhoa nk) {

		try {
			if(nk!=null) {
				nienkhoaRepo.save(nk);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteNK(Long id) {
		try {
			if(!id.equals("")) {
				nienkhoaRepo.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<NienKhoa> getAllNienKhoa() {
	
		return nienkhoaRepo.getAllNienKhoa();
	}

	@Override
	public NienKhoa getNienKhoaByID(Long id) {
		// TODO Auto-generated method stub
		return nienkhoaRepo.getNienKhoaByID(id);
	}

	@Override
	public List<NienKhoa> getAllNienKhoabyIdSV(long id) {
		// TODO Auto-generated method stub
		return nienkhoaRepo.getAllNienKhoabyIdSV(id);
	}

}

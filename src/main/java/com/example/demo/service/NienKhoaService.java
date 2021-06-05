package com.example.demo.service;

import java.util.List;

import com.example.demo.model.NienKhoa;

public interface NienKhoaService {

	boolean addNK(NienKhoa nk);
	boolean editNK(NienKhoa nk);
	boolean deleteNK(Long id);
	List<NienKhoa> getAllNienKhoa();
	NienKhoa getNienKhoaByID(Long id);
	List<NienKhoa> getAllNienKhoabyIdSV(long id);
}

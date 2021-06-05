package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.HocKy;

public interface HocKyService {
	boolean addHK(HocKy hk);
	boolean deleteHK(Long idhk);
	boolean updateHK(HocKy hk);
	List<HocKy> getAllHocKy();
	HocKy getAllHocKyByIdNienKhoa(Long id);
	List<HocKy> getAllHocKybySV(long id);
}

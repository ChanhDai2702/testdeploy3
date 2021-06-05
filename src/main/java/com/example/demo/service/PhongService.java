package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Phong;

public interface PhongService {
	boolean addPhong(Phong p);
	
	boolean editPhong(Phong p);
	
	boolean removePhongByName(String name);
	
	List<Phong> getAllPhong();
	
	List<Phong> getTTPhong(String tt);
	
	List<Phong> getNhaPhong(String nha);
}

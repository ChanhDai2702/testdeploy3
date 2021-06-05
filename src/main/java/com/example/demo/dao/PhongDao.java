package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Phong;

public interface PhongDao {
boolean addPhong(Phong p);
	
	boolean editPhong(Phong p);
	
//	boolean removePhongByName(String name);
	
	List<Phong> getAllPhong();
	
	List<Phong> getTTPhong(String tt);
	
	List<Phong> getNhaPhong(String nha);
	 boolean removePhongByMaPhong(Long maphong);
}

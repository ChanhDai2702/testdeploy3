package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.LopHocPhan;
import com.example.demo.model.SinhVien;

public interface LopHocPhanDao {
boolean addLHP(LopHocPhan lhp);
	
	boolean editLHP(LopHocPhan lhp);
	
	boolean removebyIdLHP(Long id);
	
	boolean removebyTenLHP(String name);
	
	List<LopHocPhan> getAllLHP();
	
	LopHocPhan getLHPbyID(Long id);
	
	LopHocPhan getLHPbyName(String id);
	List<SinhVien> getSVByLHP(Long id);
}

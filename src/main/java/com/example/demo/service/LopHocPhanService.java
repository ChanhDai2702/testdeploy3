package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.LopHocPhan;

public interface LopHocPhanService {
	boolean addLHP(LopHocPhan lhp);
	
	boolean editLHP(LopHocPhan lhp);
	
	boolean removebyIdLHP(Long id);
	
	boolean removebyTenLHP(String name);
	
	List<LopHocPhan> getAllLHP();
	
	LopHocPhan getLHPbyID(Long id);
	LopHocPhan getLHPNullValue();
	LopHocPhan getLHPbyName(String id);
	List<LopHocPhan> getAllLHPByMonHoc(Long id);
	List<LopHocPhan> getAllLHPBySVID(Long id);
	List<LopHocPhan> getAllLHPByMonHocAndNK(Long id,Long idNienKhoa);
	List<LopHocPhan> getAllLHPByGVID(Long id);
	List<LopHocPhan> getAllLHPbyidGVandNK(long idgv, long idnk);
}

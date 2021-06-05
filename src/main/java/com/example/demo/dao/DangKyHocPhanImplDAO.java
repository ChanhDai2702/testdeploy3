package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.DangKyLopHocPhan;
	
public class DangKyHocPhanImplDAO implements DangKyHocPhanDao{
	private EntityManager em;
	public DangKyHocPhanImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addDKHP(DangKyLopHocPhan dkhp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean huyDKHP(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DangKyLopHocPhan> getAllDKHP() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.BangDiem;

public class BangDiemImplDao implements BangDiemDao{
	private EntityManager em ;
	public BangDiemImplDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addBangDiem(BangDiem bd) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean editBangDiem(BangDiem bd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BangDiem> getAllBangDiembyIDSV(Long sv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BangDiem getBangDiembyIDMon(Long mon) {
		// TODO Auto-generated method stub
		return null;
	}

}

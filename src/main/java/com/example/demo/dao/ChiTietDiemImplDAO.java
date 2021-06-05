package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.DiemThanhPhan;
import com.example.demo.service.ChiTietDiemService;

public class ChiTietDiemImplDAO implements ChiTietDiemDao{
	private EntityManager em ;
	public  ChiTietDiemImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addChiTietDiem(DiemThanhPhan ctd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editChiTietDiem(DiemThanhPhan ctd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DiemThanhPhan> getAllChiTietDiembyidBangDiem(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

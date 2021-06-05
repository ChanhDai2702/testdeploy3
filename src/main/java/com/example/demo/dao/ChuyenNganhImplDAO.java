package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.ChuyenNganh;
import com.example.demo.service.ChuyenNganhService;

public class ChuyenNganhImplDAO implements ChuyenNganhDao {
	private EntityManager em ;
	public ChuyenNganhImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addChuyenNganh(ChuyenNganh cn) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(cn);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editChuyenNganh(ChuyenNganh cn) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(cn);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ChuyenNganh> getAllChuyenNganh() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM chuyennganhs",ChuyenNganh.class).getResultList();
	}

	@Override
	public List<ChuyenNganh> getChuyenNganhByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.MonHoc;

public class MonHocImplDAO implements MonHocDao{
	private EntityManager em ;
	public  MonHocImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addMonHoc(MonHoc hoc) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hoc);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editMonHoc(MonHoc monhoc) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(monhoc);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<MonHoc> getAllMonHoc() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM monhocs",MonHoc.class).getResultList();
	}

	@Override
	public MonHoc getMonHocbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MonHoc getMonHocbyID(Long id) {
		// TODO Auto-generated method stub
		return em.find(MonHoc.class, id);
	}

}

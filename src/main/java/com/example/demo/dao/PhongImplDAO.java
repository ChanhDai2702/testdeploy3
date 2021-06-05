package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.Phong;

public class PhongImplDAO implements PhongDao{
	private EntityManager em;
	public PhongImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addPhong(Phong p) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(p);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean editPhong(Phong p) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(p);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removePhongByMaPhong(Long maphong) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(Phong.class, maphong));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Phong> getAllPhong() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM phongs",Phong.class).getResultList();
	}

	@Override
	public List<Phong> getTTPhong(String tt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phong> getNhaPhong(String nha) {
		// TODO Auto-generated method stub
		return null;
	}

}

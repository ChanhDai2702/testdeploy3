package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.QuanLy;

public class QuanLyImplDAO implements QuanLyDao{
	private EntityManager em;
	public QuanLyImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addQL(QuanLy ql) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(ql);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editQL(QuanLy ql) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(ql);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeQL(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(id);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<QuanLy> getAllQL() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM quanlys",QuanLy.class).getResultList();
	}

	@Override
	public QuanLy getQLbyName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

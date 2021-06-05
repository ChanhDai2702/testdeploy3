package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.Khoa;

public class KhoaImplDAO implements KhoaDao {
	private EntityManager em;
	
	public KhoaImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addKhoa(Khoa k) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(k);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editKhoa(Khoa k) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(k);
			tr.commit();
			return true;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Khoa> getAllKhoa() {
		return em.createNativeQuery("SELECT * FROM khoas",Khoa.class).getResultList();
	}
	
}

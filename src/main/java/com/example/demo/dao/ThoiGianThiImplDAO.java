package com.example.demo.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.LichThi;

public class ThoiGianThiImplDAO implements ThoiGianThiDao{
	private EntityManager em;
	public ThoiGianThiImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addThoiGianThi(LichThi t) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(t);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean editThoiGianThi(LichThi t) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(t);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeThoiGianThi(LocalDate time) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public LichThi getThoiGianThi(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

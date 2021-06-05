package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.LopHoc;
import com.example.demo.service.LopHocService;

public class LopHocImplDAO implements LopHocDao{
	private EntityManager em;
	public LopHocImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addLopHoc(LopHoc hoc) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(hoc);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean editLopHoc(LopHoc hoc) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(hoc);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public LopHoc getLopHocbyIDLopHoc(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public LopHoc getLopHocByidSV(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LopHoc> getAllLopHoc() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM lophocs",LopHoc.class).getResultList();
	}
	

}

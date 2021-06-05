package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.SinhVien;
import com.example.demo.service.SinhVienService;

public class SinhVienImplDAO implements SinhVienDao {
	private EntityManager em;
	public SinhVienImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addSV(SinhVien sv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(sv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editSV(SinhVien sv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(sv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<SinhVien> getAllSV() {
		List<SinhVien> dssv = new ArrayList<SinhVien>();
		List<?> temp = em.createNativeQuery("select * from sinhviens",SinhVien.class).getResultList();
		temp.forEach(x->{
			SinhVien sv = (SinhVien) x;
			dssv.add(sv);
		});
		return dssv;
	}

	@Override
	public SinhVien getSVbyIDInApp(Long id) {
		return em.find(SinhVien.class, id);
	}

	@Override
	public List<SinhVien> getSVbyName(String name) {
		List<SinhVien> dssv = new ArrayList<SinhVien>();
		List<?> temp = em.createNativeQuery("select * from sinhviens where tensv like '"+name+"' ",SinhVien.class).getResultList();
		temp.forEach(x->{
			SinhVien sv = (SinhVien) x;
			dssv.add(sv);
		});
		return dssv;
	}

	@Override
	public List<SinhVien> getSVbyTT(String tt) {
		List<SinhVien> dssv = new ArrayList<SinhVien>();
		List<?> temp = em.createNativeQuery("select * from sinhviens where trangthai like'%"+tt+"%'").getResultList();
		temp.forEach(x->{
			SinhVien sv = (SinhVien) x;
			dssv.add(sv);
		});
		return dssv;
	}
	@Override
	public Optional<SinhVien> getSVbyID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteSV(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(getSVbyIDInApp(id));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

}

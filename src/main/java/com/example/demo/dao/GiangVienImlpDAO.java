package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.GiangVien;
import com.example.demo.service.GiangVienService;

public class GiangVienImlpDAO implements GiangVienDao{
	private EntityManager em;
	public GiangVienImlpDAO() {
		// TODO Auto-generated constructor stub
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addGV(GiangVien gv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(gv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean edit(GiangVien gv) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(gv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<GiangVien> getAllGV() {
		List<GiangVien> dsgv = new ArrayList<GiangVien>();
		List<?> temp = em.createNativeQuery("Select * from giangviens", GiangVien.class).getResultList();
		temp.forEach(x->{
			GiangVien gv = (GiangVien) x;
			dsgv.add(gv);
		});
		return dsgv;
	}

	@Override
	public GiangVien getGVbyID(Long id) {
		return em.find(GiangVien.class,id);
	}

	@Override
	public List<GiangVien> getGVbyName(String name) {
		List<GiangVien> dsgv = new ArrayList<GiangVien>();
		List<?> temp = em.createNamedQuery("Select * from giangviens where tengv like '"+name+"'", GiangVien.class).getResultList();
		temp.forEach(x->{
			GiangVien gv = (GiangVien) x;
			dsgv.add(gv);
		});
		return dsgv;
	}

	@Override
	public List<GiangVien> getGVbyTT(String tt) {
		List<GiangVien> dsgv = new ArrayList<GiangVien>();
		List<?> temp = em.createNamedQuery("Select * from giangviens where trangthai like '"+tt+"'", GiangVien.class).getResultList();
		temp.forEach(x->{
			GiangVien gv = (GiangVien) x;
			dsgv.add(gv);
		});
		return dsgv;
	}

}

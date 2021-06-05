package com.example.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.SinhVien;
import com.example.demo.model.LichHoc;

public class ThoiGianHocImplDAO implements ThoiGianHocDao{
	private EntityManager em;
	public ThoiGianHocImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addThoiGianHoc(LichHoc t) {
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
	public boolean editThoiGianHoc(LichHoc t) {
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
	public boolean removeThoiGianHoc(LocalDate ngayhoc) {
		// TODO Auto-generated method stub
		
		return false;
	}
	

	@Override
	public LichHoc getThoiGianHoc(Long id) {
		// TODO Auto-generated method stub
		return em.find(LichHoc.class, id);
	}
	@Override
	public boolean removeThoiGianHocByID(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(LichHoc.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<LichHoc> getALLTGH() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM thoigianhocs",LichHoc.class).getResultList();
	}

	@Override
	public List<LichHoc> getTGHbyIDLHP(Long id) {
		// TODO Auto-generated method stub
		List<LichHoc> dslh=new ArrayList<LichHoc>();
		List<?> temp=em.createNativeQuery("select * from thoigianhocs tgh join lophocphans lhp "
				+ "on tgh.thoigianhoc_lophocphan=lhp.malophp where lhp.malophp="+id+"",LichHoc.class).getResultList();
		temp.forEach(x->{
			LichHoc tgh=(LichHoc) x;
			dslh.add(tgh);
		});
		return dslh;
	}

}

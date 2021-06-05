package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.SinhVien;
import com.example.demo.model.TaiKhoan;

public class TaiKhoanImplDAO implements TaiKhoanDao {
	private EntityManager em;
	public TaiKhoanImplDAO() {
		// TODO Auto-generated constructor stub
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addTaiKhoan(TaiKhoan tk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editTaiKhoan(TaiKhoan tk) {
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(tk);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<TaiKhoan> getAllTK() {
		List<TaiKhoan> dstaikhoan = new ArrayList<TaiKhoan>();
		List<?> temp = em.createNativeQuery("select * from taikhoans").getResultList();
		temp.forEach(x->{
			TaiKhoan k = (TaiKhoan) x;
			dstaikhoan.add(k);
		});
		return dstaikhoan;
	}
	@Override
	public TaiKhoan getTKbyID(Long id) {
		@SuppressWarnings("unchecked")
		List<TaiKhoan> temp = em.createNativeQuery("select * from taikhoans",TaiKhoan.class).getResultList();
		for(TaiKhoan tk : temp) {
			System.out.println(tk.getTentaikhoan().equals(id));	
			if(tk.getTentaikhoan().equals(id)) {
				return tk;
			}
		}
		return null ;
	}
	@Override
	public TaiKhoan getTKbyID1(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<TaiKhoan> query = (TypedQuery<TaiKhoan>) em.createNativeQuery("select * from taikhoans where tentaikhoan="+id+"",TaiKhoan.class);
		TaiKhoan tk = query.getSingleResult();
		return tk;
	}
}

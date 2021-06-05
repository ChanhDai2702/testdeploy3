package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.example.demo.MyEntityManager.MyEntityManager;
import com.example.demo.model.LopHocPhan;
import com.example.demo.model.SinhVien;

public class LopHocPhanImplDAO implements LopHocPhanDao{
	private EntityManager em;
	public LopHocPhanImplDAO() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	@Override
	public boolean addLHP(LopHocPhan lhp) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(lhp);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editLHP(LopHocPhan lhp) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.merge(lhp);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removebyIdLHP(Long id) {
		// TODO Auto-generated method stub
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.remove(em.find(LopHocPhan.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removebyTenLHP(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LopHocPhan> getAllLHP() {
		// TODO Auto-generated method stub
		return em.createNativeQuery("SELECT * FROM lophocphans",LopHocPhan.class).getResultList();
	}
	
	@Override
	public LopHocPhan getLHPbyID(Long id) {
		// TODO Auto-generated method stub
		return em.find(LopHocPhan.class, id);
	}

	@Override
	public LopHocPhan getLHPbyName(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SinhVien> getSVByLHP(Long id) {
		// TODO Auto-generated method stub
		List<SinhVien> dssv=new ArrayList<SinhVien>();
		List<?> temp=em.createNativeQuery("SELECT * FROM lophocphans LHP JOIN dangkyhocphans DKHP ON DKHP.dangkylophocphan_lophochan=LHP.malophp \r\n" + 
				"JOIN sinhviens SV ON SV.tentaikhoan_sv=DKHP.sinhvien_dangky \r\n" + 
				"WHERE LHP.malophp="+id+"",SinhVien.class).getResultList();
		temp.forEach(x->{
			SinhVien sv=(SinhVien) x;
			dssv.add(sv);
		});
		return dssv;
	}

}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.MonHoc;

@Repository
public interface MonHocRepository  extends CrudRepository<MonHoc, Long>{
	List<MonHoc> findAll();
	@Query(value = "select * from monhoc where mamonhoc is NULL",nativeQuery = true)
	MonHoc getMHNullValue();
	@Query(value = "select * from monhoc where mamonhoc =:id",nativeQuery = true)
	MonHoc getMHById(Long id);
	@Query(value = "select * from monhoc mh join lophocphan lhp on lhp.monhoc_id=mh.mamonhoc join dangkyhocphan dkhp on dkhp.lophocphan_id=lhp.malophocphan "
			+ "join sinhvien sv on sv.masinhvien=dkhp.sinhvien_id where sv.masinhvien=:id",nativeQuery = true)
	List<MonHoc> getMHBySVID(Long id);
	@Query(value = "select * from monhoc mh join lophocphan lhp on lhp.monhoc_id=mh.mamonhoc join dangkyhocphan dkhp "
			+ "on dkhp.lophocphan_id=lhp.malophocphan join sinhvien sv "
			+ "on sv.masinhvien=dkhp.sinhvien_id join nienkhoa nk on "
			+ "nk.idnienkhoa=dkhp.nienkhoa_id where sv.masinhvien=:id and nk.idnienkhoa=:nienKhoaid",nativeQuery = true)
	List<MonHoc> getMHBySVIDandNienKhoa(Long id,Long nienKhoaid);
	
	@Query(value = "select * from monhoc mh join hoc_ky hk on hk.idhocky=mh.hocky_id where hocky_id=:idHocKy",nativeQuery = true)
	List<MonHoc> getMhByHocKi(Long idHocKy);
}

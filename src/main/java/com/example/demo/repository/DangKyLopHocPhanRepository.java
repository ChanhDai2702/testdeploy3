package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DangKyLopHocPhan;

@Repository
public interface DangKyLopHocPhanRepository extends CrudRepository<DangKyLopHocPhan, Long>,JpaRepository<DangKyLopHocPhan, Long> {
	List<DangKyLopHocPhan> findAll();
	@Query(value = "select * from dangkyhocphan dkhp join lophocphan lhp "
			+ "on lhp.malophocphan=dkhp.lophocphan_id join sinhvien sv on dkhp.sinhvien_id=sv.masinhvien join giangvien gv on lhp.giangvien_id=gv.magiangvien where masinhvien=:id",nativeQuery = true)
	List<DangKyLopHocPhan> findAllLHPBySVID(Long id);
	
	
	@Query(value = "select * from dangkyhocphan dkhp join lophocphan lhp on lhp.malophocphan=dkhp.lophocphan_id join sinhvien sv "
			+ "on dkhp.sinhvien_id=sv.masinhvien "
			+ "join nienkhoa nk on nk.idnienkhoa=dkhp.nienkhoa_id join giangvien gv on lhp.giangvien_id=gv.magiangvien where masinhvien=:id and nk.idnienkhoa =:nienKhoaid",nativeQuery = true)
	List<DangKyLopHocPhan> getAllLHPBYSVIDandNienKhoa(Long id,Long nienKhoaid);
}

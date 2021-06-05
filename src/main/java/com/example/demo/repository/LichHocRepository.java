package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.LichHoc;
import com.example.demo.model.SinhVien;

@Repository
public interface LichHocRepository extends CrudRepository<LichHoc, Long> {
	List<LichHoc> findAll();
	@Query(value = "delete from thoigianhocs tgh where tgh.ngayhoc=%ngayhoc%",nativeQuery = true)
	void deleteByDate(LocalDate ngayhoc);
	
	@Query(value = "select * from lichhoc lh join lophocphan lhp on lh.lophocphan_id=lhp.malophocphan join dangkyhocphan "
			+ "dkhp on dkhp.lophocphan_id=lhp.malophocphan join sinhvien sv on sv.masinhvien=dkhp.sinhvien_id WHERE sv.masinhvien=:id ORDER BY lh.tiethocbatdau ",nativeQuery = true)
	List<LichHoc> getLichHocBySVID(Long id);
	

	@Query(value = "select * from lichhoc lh join lophocphan lhp on lh.lophocphan_id=lhp.malophocphan join dangkyhocphan dkhp on dkhp.lophocphan_id=lhp.malophocphan join sinhvien sv on sv.masinhvien=dkhp.sinhvien_id join nienkhoa nk on nk.idnienkhoa=lhp.nienkhoa_id WHERE sv.masinhvien=:id and nk.idnienkhoa=:idNienKhoa",nativeQuery = true)
	List<LichHoc> getLichHocBySVIDandNK(Long id,Long idNienKhoa);
	
	@Query(value = "select top 1 * from lichhoc lh join lophocphan lhp on lhp.malophocphan=lh.lophocphan_id where lhp.malophocphan=:id",nativeQuery = true)
	List<LichHoc> getLichHocByLHPID(Long id);
	
	
	@Query(value = "select * from lichhoc lh join lophocphan lhp on lh.lophocphan_id=lhp.malophocphan\r\n" + 
			" join giangvien gv on gv.magiangvien=lhp.giangvien_id WHERE gv.magiangvien = :id ORDER BY lh.tiethocbatdau",nativeQuery = true)
	List<LichHoc> getLichdaybyGV(Long id);
	
}

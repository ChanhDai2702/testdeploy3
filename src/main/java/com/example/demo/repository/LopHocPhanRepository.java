package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.LopHocPhan;

@Repository
public interface LopHocPhanRepository extends CrudRepository<LopHocPhan, Long> {
	@Query(value = "DELETE FROM lophocphan lhp WHERE lhp.malophocphan like %:name%",nativeQuery = true)
	LopHocPhan deleteLHPByTenLHP(String name);
	
	@Query(value = "SELECT * FROM lophocphan lhp WHERE lhp.malophocphan =:id",nativeQuery = true)
	LopHocPhan getLHPbyID(long id);
	
	List<LopHocPhan> findAll();
	
	@Query(value = "select * from lophocphan where malophocphan is NULL",nativeQuery = true)
	LopHocPhan getLHPNullValue();
	
	@Query(value = "select * from lophocphan lhp join monhoc mh on lhp.monhoc_id=mh.mamonhoc join giangvien gv on gv.magiangvien=lhp.giangvien_id where mh.mamonhoc=:id",nativeQuery = true)
	List<LopHocPhan> getAllLHPByMonHoc(Long id);
	
	@Query(value = "select * from lophocphan lhp join monhoc mh on lhp.monhoc_id=mh.mamonhoc join giangvien gv on gv.magiangvien=lhp.giangvien_id join nienkhoa nk on nk.idnienkhoa=lhp.nienkhoa_id where mh.mamonhoc=:id and nk.idnienkhoa=:idNienKhoa",nativeQuery = true)
	List<LopHocPhan> getAllLHPByMonHocAndNK(Long id,Long idNienKhoa);
	
	@Query(value = "select * from lophocphan lhp join dangkyhocphan dkhp on dkhp.lophocphan_id=lhp.malophocphan "
			+ "join sinhvien sv on sv.masinhvien=dkhp.sinhvien_id "
			+ "join giangvien gv on gv.magiangvien=lhp.giangvien_id where sv.masinhvien=:id",nativeQuery = true)
	List<LopHocPhan> getAllLHPBySVID(Long id);
	
	@Query(value = "select * from lophocphan l where l.giangvien_id = :id",nativeQuery = true)
	List<LopHocPhan> getAllLHPByGVID(long id);
	
	@Query(value = "select * from lophocphan lhp join nienkhoa nk on lhp.nienkhoa_id = nk.idnienkhoa where lhp.giangvien_id = :idgv and nk.idnienkhoa = :idnk ",nativeQuery = true)
	List<LopHocPhan> getAllLHPbyidGVandNK(long idgv, long idnk);
}

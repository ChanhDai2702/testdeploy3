package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.HocKy;
@Repository
public interface HocKyRepository extends CrudRepository<HocKy, Long>{
	@Query(value = "select*from hoc_ky",nativeQuery = true)
	List<HocKy> getAllHocKy();
	
	@Query(value = "select distinct hk. * from hoc_ky hk join nienkhoa nk on nk.hocky_id=hk.idhocky where idnienkhoa=:id",nativeQuery = true)
	HocKy getAllHocKyByIdNienKhoa(Long id);
	
	@Query(value = "select distinct hk. * from hoc_ky hk join nienkhoa nk on nk.hocky_id=hk.idhocky \r\n" + 
			"		join bangdiem bd on bd.nienkhoa_id = nk.idnienkhoa where bd.sinhvien_id  = ?",nativeQuery = true)
	List<HocKy> getAllHocKybySV(long id);
}

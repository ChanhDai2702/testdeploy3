package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.NienKhoa;

@Repository
public interface NienKhoaRepository extends CrudRepository<NienKhoa,Long>{
	@Query(value = "select * from nienkhoa ORDER BY idnienkhoa DESC",nativeQuery = true)
	List<NienKhoa> getAllNienKhoa();
	@Query(value = "select distinct * from nienkhoa nk where nk.idnienkhoa=:id",nativeQuery = true)
	NienKhoa getNienKhoaByID(Long id);
	
	@Query(value = "select distinct nk.* from hoc_ky hk join nienkhoa nk on nk.hocky_id=hk.idhocky \r\n" + 
			"		join bangdiem bd on bd.nienkhoa_id = nk.idnienkhoa where bd.sinhvien_id = ?",nativeQuery = true)
	List<NienKhoa> getAllNienKhoabyIdSV(long id);
	
	
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SinhVien;

@Repository
public interface SinhVienRepository extends CrudRepository<SinhVien, Long> {
	@Query(value = "SELECT * FROM SINHVIENS sv WHERE sv.tensv like %:name%", nativeQuery = true)
	List<SinhVien> getSvbyname(String name);
	
	@Query(value = "SELECT * FROM SINHVIENS sv WHERE sv.trangthai like %:tt%", nativeQuery = true)
	List<SinhVien> getSvbytrangthai(String tt);
	List<SinhVien> findAll();
}

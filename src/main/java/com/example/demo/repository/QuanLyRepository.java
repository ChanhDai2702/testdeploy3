package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.QuanLy;
import com.example.demo.model.SinhVien;

@Repository
public interface QuanLyRepository extends CrudRepository<QuanLy, Long> {
	
	@Query(value = "SELECT * FROM quanlys ql WHERE ql.tenql like %:name%", nativeQuery = true)
	QuanLy getQLbyname(String name);
	List<QuanLy> findAll();
}

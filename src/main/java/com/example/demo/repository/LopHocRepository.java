package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.LopHoc;

@Repository
public interface LopHocRepository extends CrudRepository<LopHoc, Long> {
	List<LopHoc> findAll();
}

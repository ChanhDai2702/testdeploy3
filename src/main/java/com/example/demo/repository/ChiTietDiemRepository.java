package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.DiemThanhPhan;

@Repository
public interface ChiTietDiemRepository extends CrudRepository<DiemThanhPhan, Long>{
	List<DiemThanhPhan> findAll();
}

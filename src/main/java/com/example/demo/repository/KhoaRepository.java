package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Khoa;

@Repository
public interface KhoaRepository extends CrudRepository<Khoa, Long> {
	List<Khoa> findAll();
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Phong;

@Repository
public interface PhongRepository extends CrudRepository<Phong, Long> {
	List<Phong> findAll();
	//@Query(value = "")
	//Phong deletePhongByPhongName(String name);
}

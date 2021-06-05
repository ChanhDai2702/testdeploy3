package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends CrudRepository<TaiKhoan	, Long> {
	List<TaiKhoan> findAll();
	@Query(value = "select * from taikhoan where  tentaikhoan = ?", nativeQuery = true)
	Optional<TaiKhoan> findByTaiKhoan(String tk);
}

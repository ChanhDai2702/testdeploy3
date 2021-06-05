package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LichHoc;
import com.example.demo.model.LichThi;

@Repository
public interface ThoiGianThiRepository extends CrudRepository<LichThi, Long> {
	List<LichThi> findAll();
	@Query(value = "delete from thoigianthis tgt where tgt.ngaythi=%ngaythi%",nativeQuery = true)
	void deleteByDate(LocalDate ngaythi);
}

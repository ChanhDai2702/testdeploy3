package com.example.demo.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name = "khoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Khoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "makhoa")
	private Long makhoa;
	
	@Column(name = "tenkhoa",columnDefinition = "nvarchar(50)")
	private String tenkhoa;

	@OneToMany(mappedBy = "khoa",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<ChuyenNganh> dsChuyenNganh;

	public Khoa() {
		super();

	}

	public Khoa(Long makhoa, String tenkhoa) {
		super();
		this.makhoa = makhoa;
		this.tenkhoa = tenkhoa;
	}

	public Long getMakhoa() {
		return makhoa;
	}

	public void setMakhoa(Long makhoa) {
		this.makhoa = makhoa;
	}

	public String getTenkhoa() {
		return tenkhoa;
	}

	public void setTenkhoa(String tenkhoa) {
		this.tenkhoa = tenkhoa;
	}

	public List<ChuyenNganh> getDsChuyenNganh() {
		return dsChuyenNganh;
	}

	public void setDsChuyenNganh(List<ChuyenNganh> dsChuyenNganh) {
		this.dsChuyenNganh = dsChuyenNganh;
	}

	@Override
	public String toString() {
		return "Khoa [makhoa=" + makhoa + ", tenkhoa=" + tenkhoa + ", dsChuyenNganh=" + dsChuyenNganh + "]";
	}
	
	
}

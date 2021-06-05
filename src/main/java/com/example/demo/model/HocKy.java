package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class HocKy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idhocky")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="loaihocky",columnDefinition = "nvarchar(225) not null")
	private String loaiHocKy;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoaiHocKy() {
		return loaiHocKy;
	}
	public void setLoaiHocKy(String loaiHocKy) {
		this.loaiHocKy = loaiHocKy;
	}
	
	public HocKy(Long id, String loaiHocKy) {
		super();
		this.id = id;
		this.loaiHocKy = loaiHocKy;
	}
	public HocKy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

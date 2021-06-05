package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="nienkhoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NienKhoa {
	@Id
	@Column(name = "idnienkhoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="nambatdau")
	private int namBatDau;
	@Column(name="namketthuc")
	private int namKetThuc;
	@Column(name="nienkhoa",columnDefinition = "nvarchar(50) not null")
	private String Khoa;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hocky_id",nullable = true,foreignKey = @ForeignKey)
	private HocKy hocKy;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNamBatDau() {
		return namBatDau;
	}
	public void setNamBatDau(int namBatDau) {
		this.namBatDau = namBatDau;
	}
	public int getNamKetThuc() {
		return namKetThuc;
	}
	public void setNamKetThuc(int namKetThuc) {
		this.namKetThuc = namKetThuc;
	}

	public HocKy getHocKy() {
		return hocKy;
	}
	public void setHocKy(HocKy hocKy) {
		this.hocKy = hocKy;
	}
	public boolean isSelected(Long id) {
		if(id!=null) {
			return id.equals(id);
		}
		return false;
	}
	
	public NienKhoa(Long id, int namBatDau, int namKetThuc, String khoa, HocKy hocKy) {
		super();
		this.id = id;
		this.namBatDau = namBatDau;
		this.namKetThuc = namKetThuc;
		Khoa = khoa;
		this.hocKy = hocKy;
	}
	public String getKhoa() {
		return Khoa;
	}
	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	public NienKhoa() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NienKhoa [id=" + id + ", namBatDau=" + namBatDau + ", namKetThuc=" + namKetThuc + ", Khoa=" + Khoa
				+ ", hocKy=" + hocKy + "]";
	}
	
	
}

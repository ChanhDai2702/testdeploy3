package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name = "lophoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LopHoc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "malophoc")
	private Long malophoc;
	
	@Column(name = "tenlop",columnDefinition = "nvarchar(225) not null")
	private String tenlop;

	@Column(name = "nienkhoa",columnDefinition = "nvarchar(225) not null")
	private String nienkhoa;
	
	@Column(name = "loaihinhdaotao",columnDefinition = "nvarchar(225) not null")
	private String loaihinhdaotao;
	
	@Column(name = "siso")
	private int siso;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chuyennganh_id", nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference(value = "chuyennganh-lophoc")
	private ChuyenNganh chuyenNganh;

	@OneToMany(mappedBy = "lopHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<SinhVien> dsSinhVien;

	

	public String getLoaihinhdaotao() {
		return loaihinhdaotao;
	}

	public void setLoaihinhdaotao(String loaihinhdaotao) {
		this.loaihinhdaotao = loaihinhdaotao;
	}

	public LopHoc(Long malophoc, String tenlop, String nienkhoa, String loaihinhdaotao, int siso) {
		super();
		this.malophoc = malophoc;
		this.tenlop = tenlop;
		this.nienkhoa = nienkhoa;
		this.loaihinhdaotao = loaihinhdaotao;
		this.siso = siso;
	}

	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getMalophoc() {
		return malophoc;
	}

	public void setMalophoc(Long malophoc) {
		this.malophoc = malophoc;
	}

	public String getTenlop() {
		return tenlop;
	}

	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}

	
	public String getNienkhoa() {
		return nienkhoa;
	}

	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}

	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public List<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(List<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public int getSiso() {
		return siso;
	}

	public void setSiso(int siso) {
		this.siso = siso;
	}

	@Override
	public String toString() {
		return "LopHoc [malophoc=" + malophoc + ", tenlop=" + tenlop + ", nienkhoa=" + nienkhoa + ", loaihinhdaotao="
				+ loaihinhdaotao + ", siso=" + siso + ", chuyenNganh=" + chuyenNganh + ", dsSinhVien=" + dsSinhVien
				+ "]";
	}
	
	
}

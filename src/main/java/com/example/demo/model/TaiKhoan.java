package com.example.demo.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;





@Entity(name = "taikhoan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "tentaikhoan")
public class TaiKhoan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3716318567868148235L;
	@Id
	@Column(name = "tentaikhoan")
	private Long tentaikhoan;
	
	@Column(name = "matkhau",columnDefinition = "nvarchar(225) not null")
	private String matkhau;
	
	@Column(name = "phanloai",columnDefinition = "nvarchar(50) not null")
	private String phanloai;
	
	@OneToOne(mappedBy = "taiKhoan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private QuanLy quanLy;
	
	@OneToOne(mappedBy = "taiKhoan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private SinhVien sinhVien;
	
	@OneToOne(mappedBy = "taiKhoan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private GiangVien giangVien;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(Long tentaikhoan, String matkhau, String phanloai) {
		super();
		this.tentaikhoan = tentaikhoan;
		this.matkhau = matkhau;
		this.phanloai = phanloai;
	}

	public Long getTentaikhoan() {
		return tentaikhoan;
	}

	public void setTentaikhoan(Long tentaikhoan) {
		this.tentaikhoan = tentaikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public String getPhanloai() {
		return phanloai;
	}

	public void setPhanloai(String phanloai) {
		this.phanloai = phanloai;
	}

	public QuanLy getQuanLy() {
		return quanLy;
	}

	public void setQuanLy(QuanLy quanLy) {
		this.quanLy = quanLy;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tentaikhoan=" + tentaikhoan + ", matkhau=" + matkhau + ", phanloai=" + phanloai + "]";
	}
	
	
	
}
